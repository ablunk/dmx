package hub.sam.dmx.launcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.text.Position;

import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.Extension;
import hub.sam.dbl.ExtensionSemantics;
import hub.sam.dbl.Import;
import hub.sam.dbl.Model;
import hub.sam.dmx.Activator;
import hub.sam.dmx.editor.modelcreation.DbxParser;
import hub.sam.dmx.launcher.java.JavaClassLauncher;
import hub.sam.dmx.launcher.programoutput.ProgramOutputPrinter;
import hub.sam.dmx.launcher.programoutput.SimplePrinterStream;
import hub.sam.dmx.modelcreation.DblModelWorkingCopy;
import hub.sam.dmx.modifications.Modification;
import hub.sam.dmx.modifications.ModificationsPackage;
import hub.sam.dmx.modifications.ModificationsRecord;
import hub.sam.dmx.semantics.AbstractExtensionSemantics;
import hub.sam.dmx.semantics.AbstractGenerator;
import hub.sam.dmx.semantics.BasicDblToJavaGenerator;
import hub.sam.dmx.semantics.ExtensionDefinitionsToJava;
import hub.sam.dmx.semantics.IncrementalModificationApplier;
import hub.sam.dmx.semantics.TargetLanguageGenerator;
import hub.sam.dmx.targetcode.DblToDesmojJavaGenerator;
import hub.sam.tef.modelcreating.HeadlessEclipseParser;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.semantics.AbstractError;

public class ModelLauncher {
	
	protected static final Logger logger = Logger.getLogger(ModelLauncher.class.getName());
	
	protected final IProgressMonitor progressMonitor;
	
	protected final IFile modelFile;
	protected final Resource metaModelResource;
	protected final IModelCreatingContext lastModelCreatingContext;
	
	private final TargetLanguageGenerator targetLanguageGenerator;
	private final JavaClassLauncher javaClassLauncher;
	protected final ProgramOutputPrinter programOutputPrinter;

	public static final String JAVA_GEN_FOLDER = "gen-src";
	public static final String TEMP_FOLDER = "temp";
	
	public ModelLauncher(IProgressMonitor monitor, IFile modelFile, Resource metaModelResource, 
			IModelCreatingContext lastModelCreatingContext, TargetLanguageGenerator targetLanguageGenerator, 
			JavaClassLauncher javaClassLauncher,
			ProgramOutputPrinter programOutputPrinter) {
		
		this.progressMonitor = monitor;
		
		this.modelFile = modelFile;
		this.metaModelResource = metaModelResource;
		this.lastModelCreatingContext = lastModelCreatingContext;
		
		this.targetLanguageGenerator = targetLanguageGenerator;
		this.javaClassLauncher = javaClassLauncher;
		this.programOutputPrinter = programOutputPrinter;
	}
	
	public void compileAndRun(Resource modelResource) {
		long startCompileTime = System.nanoTime();
		
		progressMonitor.beginTask("Compile && Run ...", 100);
		
		progressMonitor.subTask("Refreshing folders");
		refreshCurrentProject();
		
		IProject currentProject = getCurrentProject();
		IPath genPath = getJavaGenFolder(currentProject).getRawLocation();

		progressMonitor.subTask("Cleaning folders");
		cleanFolder(getTempFolder(currentProject));
		cleanFolder(getJavaGenFolder(currentProject));
		
		programOutputPrinter.clear();

		progressMonitor.worked(5); // 5%
//		monitor.subTask("Generating EMF Java classes for DBL metamodel");
//		genEmfJavaClasses(currentProject);

		progressMonitor.subTask("Translating model to target language program");

		// 1a. NEW --> Access properties by EMF's reflection mechanism. In this, no EMF code needs to generated here.

		Resource originalResource = modelResource;
		Model rootModel = (Model) originalResource.getContents().get(0);

		final boolean isDbxInputFile = modelFile.getFileExtension().equals("dbx");

		logger.info("Compiling and executing model " + modelFile + " ...");

		translate(rootModel, true, targetLanguageGenerator, genPath, isDbxInputFile);
		
		progressMonitor.worked(50); // 55%
		progressMonitor.subTask("Compiling target language program");

		boolean compileOk = false;
		compileOk = compileJavaFiles(currentProject, getJavaGenFolder(currentProject));

		long estimatedTime = System.nanoTime() - startCompileTime;
		long ms = estimatedTime / (1000 * 1000);
		logger.info("Overall compile time: " + ms / 1000.0 + " seconds");
		
		progressMonitor.worked(40); // 95%

		if (compileOk) {
			progressMonitor.subTask("Executing target language program");				
			
			IJavaProject currentJavaProject = JavaCore.create(currentProject);
			IPath workingDirectory = currentProject.getLocation();

			javaClassLauncher.launch(currentJavaProject, workingDirectory, 
					BasicDblToJavaGenerator.javaPackageFolderPrefix + "/JavaMain", null,
					programOutputPrinter);
			
			progressMonitor.worked(5); // 100%
		}
	}
	
	protected IProject getCurrentProject() {
		return modelFile.getProject();
	}
	
	private String getLabel() {
		return modelFile.getName();
	}
	
	private Map<Model, Model> processedModels = new HashMap<Model, Model>();

	protected Model translate(Model inputModel, boolean rootModel, TargetLanguageGenerator baseGenerator, IPath genFolder, boolean substituteExtensions) {
		URI filenameAndPathWithoutFileExtensions = inputModel.eResource().getURI().trimFileExtension();
		String modelDbxTextFileString = getXmiRawLocation(filenameAndPathWithoutFileExtensions.appendFileExtension("dbx")).toOSString();
	
		File inputFile = new File(modelDbxTextFileString);
		if (inputFile.exists()) {
			IPath inputPath = getXmiRawLocation(filenameAndPathWithoutFileExtensions.trimSegments(1));
			return translateDbx(inputPath, inputFile, inputModel, rootModel, baseGenerator, genFolder, substituteExtensions);
		}
		else {
			return translateDbl(inputModel, rootModel, baseGenerator, genFolder, substituteExtensions);
		}
	}

	private Model translateDbl(Model inputModel, boolean rootModel, TargetLanguageGenerator baseGenerator, IPath genFolder, boolean substituteExtensions) {
		if (!processedModels.containsKey(inputModel)) {
			// 2.a. forward translation to imported models, so that extensions used in imported models are translated
			// 2.b. replaced imported models by translated imported models
			for (Import imprt: inputModel.getImports()) {
				Model importedModel = imprt.getModel();
				if (importedModel != null) {
					translate(importedModel, false, baseGenerator, genFolder, substituteExtensions);
				}
			}
			
			// 3. generate target language code with baseGenerator for outputModel
			baseGenerator.genModel(inputModel, rootModel, genFolder);
			
			processedModels.put(inputModel, inputModel);
			return inputModel;
		}
		return processedModels.get(inputModel);
	}

	private Model translateDbx(IPath inputPath, File inputFile, Model inputModel, boolean rootModel, TargetLanguageGenerator baseGenerator, IPath genFolder, boolean substituteExtensions) {
		// prevents processing a model which is imported by different imports again
		if (!processedModels.containsKey(inputModel)) {
			
			// 1. create working copy of input model
			DblModelWorkingCopy parsedWorkingModel = null;
			
			// parse model (text) with headless parser! we need the object positions of imported models during substitution later ;-(

			if (!rootModel) {
				String modelAsText = getContent(inputFile);
				if (modelAsText != null) {
					HeadlessEclipseParser parser = new DbxParser(inputPath, inputFile.getName());
					try {
						IModelCreatingContext creationContext = parser.parse(modelAsText);
						if (creationContext.getErrors().size() > 0) {
							printParseErrorsToEditorConsole(creationContext, inputFile.getName(), modelAsText);
							throw new RuntimeException(creationContext.getErrors().iterator().next().getMessage());
						}
						else {
							parsedWorkingModel = new DblModelWorkingCopy(
									inputModel.eResource().getURI(),
									creationContext.getResource(), false, creationContext,
									workingCopiesResourceSet);
						}
					}
					catch (ModelCreatingException e) {
						e.printStackTrace();
					}
				}
			}
			else {
				// model is currently opened in active editor
				parsedWorkingModel = new DblModelWorkingCopy(inputModel.eResource().getURI(),
						inputModel.eResource(), true, lastModelCreatingContext,
						workingCopiesResourceSet);
			}
			
			
			// 2.a. forward translation to imported models, so that extensions used in imported models are translated
			// 2.b. replace imported models by translated imported models
			for (Import imprt: parsedWorkingModel.getModel().getImports()) {
				Model importedModel = imprt.getModel();
				if (importedModel != null) {
					Model translatedModel = translate(importedModel, false, baseGenerator, genFolder, substituteExtensions);
					imprt.setModel(translatedModel);
				}
			}
			

			// model was created from DBX file -> substitute extensions
			// 2. substitute all extensions of the current model
			parsedWorkingModel = substituteExtensions(parsedWorkingModel);
			
			// 3. generate target language code with baseGenerator for outputModel
			baseGenerator.genModel(parsedWorkingModel.getModel(), rootModel, genFolder);
			
			processedModels.put(inputModel, parsedWorkingModel.getModel());
			return parsedWorkingModel.getModel();
		}
		
		return processedModels.get(inputModel);
	}
	
	private String getContent(File file) {
		FileReader fileReader;
		try {
			fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();

		        while (line != null) {
		            sb.append(line);
		            sb.append(System.getProperty("line.separator"));
		            line = br.readLine();
		        }
		        return sb.toString();
		    }
		    catch (IOException e) {
				e.printStackTrace();
			}
		    finally {
		        try {
					br.close();
				}
		        catch (IOException e) {
					e.printStackTrace();
				}
		    }
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected void refreshCurrentProject() {
		try {
			getCurrentProject().refreshLocal(IResource.DEPTH_INFINITE, null);
		}
		catch (CoreException e1) {
			e1.printStackTrace();
		}
	}
	
	private boolean transitivelyContainsExtensionInstance(EObject eObject) {
		TreeIterator<EObject> allContents = eObject.eAllContents();
		while (allContents.hasNext()) {
			EObject content = allContents.next();
			if (content instanceof ExtensibleElement && ((ExtensibleElement) content).isInstanceOfExtensionDefinition()) {
				return true;
			}
		}
		return false;
	}
	
	protected Map<String, Collection<ExtensibleElement>> getLeafExtensionInstances(Model inputModel) {
		Map<String, Collection<ExtensibleElement>> extensionDefinitionNames_to_extensionInstances = new HashMap<String, Collection<ExtensibleElement>>();
		
		TreeIterator<EObject> allContents = inputModel.eAllContents();
		while (allContents.hasNext()) {
			EObject eObject = allContents.next();
			if (eObject instanceof ExtensibleElement && ((ExtensibleElement) eObject).isInstanceOfExtensionDefinition()) {
				// NOTE All extension meta-classes have to extend the meta-class ExtensibleElement.
				// In addition, instances of meta-classes added by extension, have to set their attribute objectIsExtensionInstance to true.
				// This is needed, because even the class Statement is a specialization of ExtensibleElement. However, direct Statement
				// instances are not extensions.
				
				ExtensibleElement extensionInstance = (ExtensibleElement) eObject;
				
				// NOTE the extension instance MUST NOT transitively contain other extension instances.
				// if it does, the contained extension instances have to be replaced first.
				// reason: extension instance substitution is implemented based on text substitution.
				//         when an other extension instance is replaced, its contained extension instances change positions.
				//         therefore, contained extension instances have to be replaced first.
				
				// TODO this is not working when an object which is part of an extension (instanceOfExtensionDefinition=true)
				// contains base elements (with instanceOfExtensionDefinition=false) 
				
				if (!transitivelyContainsExtensionInstance(extensionInstance)) {
					String extensionDefinitionName = extensionInstance.eClass().getName();
					if (!extensionDefinitionNames_to_extensionInstances.containsKey(extensionDefinitionName)) {
						extensionDefinitionNames_to_extensionInstances.put(extensionDefinitionName, new HashSet<ExtensibleElement>());
					}
					extensionDefinitionNames_to_extensionInstances.get(extensionDefinitionName).add(extensionInstance);
				}
			}
		}

		return extensionDefinitionNames_to_extensionInstances;
	}
	
	protected Collection<String> extensionDefinitionSemanticsGenerated = new HashSet<String>();
	
	private ExtensionDefinitionsToJava _extensionDefinitionGenerator;
	
	protected ExtensionDefinitionsToJava getExtensionDefinitionGenerator() {
		if (_extensionDefinitionGenerator == null) {
			IPath genFolder = getJavaGenFolder(getCurrentProject()).getRawLocation();
			_extensionDefinitionGenerator = new ExtensionDefinitionsToJava();
			_extensionDefinitionGenerator.initOutputFolder(genFolder);
		}
		return _extensionDefinitionGenerator;
	}
	
	/**
	 * substitutes all extensions by processing leaf extensions first
	 * 
	 * @param inputModel model containing extension instances
	 * @return workingModel either the inputModel or a copy of the inputModel with extension instances replaced
	 */
	protected DblModelWorkingCopy substituteExtensions(DblModelWorkingCopy inputModel) {
		final IProject currentProject = getCurrentProject();
		final IJavaProject currentJavaProject = JavaCore.create(currentProject);

		DblModelWorkingCopy workingModel = inputModel;
		
		Map<String, Collection<ExtensibleElement>> leafExtensionInstances = getLeafExtensionInstances(workingModel.getModel());
		while (leafExtensionInstances.size() > 0) {
			
			IncrementalModificationApplier modificationApplier = new IncrementalModificationApplier(
					new StringBuffer(workingModel.getText()), workingModel.getAllObjectPositions(),
					workingModel.getResource());
			
			boolean javaCodeAdded = false;
			Map<String, Extension> extensionDefinitions = new HashMap<String, Extension>();
			
			for (String extensionDefinitionName: leafExtensionInstances.keySet()) {

				// generate executable code from extension definition semantics
				ExtensionSemantics semanticsDefinition = getExtensionDefinitionGenerator().getImportedExtensionSemanticsDefinition(workingModel.getModel(), extensionDefinitionName);
				if (semanticsDefinition == null) {
					logger.severe("cannot find semantics of extension definition " + extensionDefinitionName + " by import anymore."
							+ "maybe the extension definition itself was replaced."
							+ "if " + extensionDefinitionName + " is a newly introduced metaclass, "
							+ "please make sure to update the factory method hub.sam.dbl.DblFactoryImpl.create(EClass).");
					throw new RuntimeException();
				}else {
					extensionDefinitions.put(extensionDefinitionName, semanticsDefinition.getSyntaxDefinition());
	
					if (!extensionDefinitionSemanticsGenerated.contains(extensionDefinitionName)) {
						extensionDefinitionSemanticsGenerated.add(extensionDefinitionName);
						logger.info("Generating executable semantics for extension definition " + extensionDefinitionName);
						
						getExtensionDefinitionGenerator().genExtensionSemanticsDefinition(workingModel.getModel(), semanticsDefinition);
						javaCodeAdded = true;
					}
				}
			}
			
			if (javaCodeAdded) {
				// compile all extension definitions used by extension instances ONCE
				compileJavaFiles(currentProject, getJavaGenFolder(currentProject));
			}

			IPath inputPath = getXmiRawLocation(workingModel.getResource().getURI().trimSegments(1));

			for (String extensionDefinitionName: leafExtensionInstances.keySet()) {
				extensionInstanceLoop: for (ExtensibleElement extensionInstance: leafExtensionInstances.get(extensionDefinitionName)) {
					
					// a copy of the extended DBL metamodel is needed as well.
					// this is because the semantics of extension definitions access added metamodel classes and properties.
					saveExtendedDblMetaModelIfNecessary(currentProject);
					
					IPath workingDirectory = currentProject.getLocation();

					// get modifications of extension instance by executing the semantics definition
					String[] arguments = new String[] {
							getXmiRawLocation(workingModel.getResource().getURI()).toString(),
							AbstractExtensionSemantics.getEmfUriFragment(extensionInstance),
							inputPath.toString()
						};
					String qualifiedExtensionDefinitionName = getExtensionDefinitionGenerator().javaNameQualified(extensionDefinitions.get(extensionDefinitionName));
					javaClassLauncher.launch(currentJavaProject, workingDirectory, 
							qualifiedExtensionDefinitionName + "Semantics", arguments,
							programOutputPrinter);
					
					// text substitute extension instances by result of semantics executions
					EList<Modification> storedModifications = getLastStoredModifications();
					
					progressMonitor.subTask("Applying modifications");
					
					logger.info("--------- input text ---------" + Activator.lineSep
							+ modificationApplier.getWorkingText() + Activator.lineSep);
						
					if (storedModifications == null || storedModifications.size() == 0) {
						logger.severe("No modifications found after executing semantics description of extension definition " + extensionDefinitionName + ".");
						continue extensionInstanceLoop;
					}
					else {									
						modificationApplier.applyAll(storedModifications);
					}
				}
			}
			
			// after leaf extensions have been substituted:
			// parse text with headless DBL parser to >>workingModel<<
			String filename = workingModel.getResource().getURI().trimFileExtension().appendFileExtension("dbx").lastSegment();

			HeadlessEclipseParser parser = new DbxParser(inputPath, filename);
			
			try {
				//lastInputModelContext = parser.parse("module test { void main() { print \"hello\"; } }");
				IModelCreatingContext modelCreationContext = parser.parse(modificationApplier.getWorkingText().toString());
				
				if (modelCreationContext.getErrors().size() > 0) {
					printParseErrorsToEditorConsole(modelCreationContext, filename, modificationApplier.getWorkingText().toString());
					throw new RuntimeException(modelCreationContext.getErrors().iterator().next().getMessage());
				}
				else {
					workingModel = new DblModelWorkingCopy(workingModel,
							modelCreationContext.getResource(), modelCreationContext);
				}
			}
			catch (ModelCreatingException e) {
				e.printStackTrace();
			}
			
			// repeat the process until the model does not contain extension instances anymore,
			// i.e. no extension instances occur in code generated by extension semantics anymore
			
			// get the new leaf extensions (which were node extensions before)
			leafExtensionInstances = getLeafExtensionInstances(workingModel.getModel());
		}
		
		return workingModel;
	}
	
	protected void printParseErrorsToEditorConsole(IModelCreatingContext context, String filename, String sourceText) {
		SimplePrinterStream errorStream = programOutputPrinter.newErrorPrinterStream();
		for (AbstractError error: context.getErrors()) {
			Position errorPosition = error.getPosition(context);
			errorStream.println(filename + " >> " + error.getMessage());
			if (errorPosition.offset >= 0) {
				errorStream.println("text before error:\n" + sourceText.substring(0, errorPosition.offset));
			}
		}
	}
		
	protected EList<Modification> getLastStoredModifications() {
		// get all the modifications from <temp-folder>/modifications.xmi
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
    	resourceSet.getPackageRegistry().put(ModificationsPackage.eNS_URI, ModificationsPackage.eINSTANCE);

    	String modificationsXmiFile = getTempFolder(getCurrentProject()).getLocation().append("modifications.xmi").toString();
		URI modificationsFileUri = URI.createFileURI(new File(modificationsXmiFile).getAbsolutePath());		
		
		Resource modificationsResource = resourceSet.getResource(modificationsFileUri, true);
		ModificationsRecord modificationsRecord = null;
		for (EObject rootObject: modificationsResource.getContents()) {
			modificationsRecord = (ModificationsRecord) rootObject;
			return modificationsRecord.getModifications();
		}

		return null;
	}
	
//	@Deprecated
//	private String textSubstituteExtensionInstances_old(ParsedWorkingCopyModel workingModel) {
//		monitor.subTask("Applying modifications");
//		
//		// get all the modifications from <temp-folder>/modifications.xmi
//		ResourceSet resourceSet = new ResourceSetImpl();
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
//    	resourceSet.getPackageRegistry().put(ModificationsPackage.eNS_URI, ModificationsPackage.eINSTANCE);
//
//    	String modificationsXmiFile = getTempFolder(getCurrentProject()).getLocation().append("modifications.xmi").toString();
//		URI modificationsFileUri = URI.createFileURI(new File(modificationsXmiFile).getAbsolutePath());		
//		
//		Resource modificationsResource = resourceSet.getResource(modificationsFileUri, true);
//		ModificationsRecord modificationsRecord = null;
//		for (EObject rootObject: modificationsResource.getContents()) {
//			modificationsRecord = (ModificationsRecord) rootObject;
//			break;
//		}
//		
//		logger.info("--------- input text ---------" + Activator.lineSep
//				+ workingModel.getText() + Activator.lineSep);
//			
//		if (modificationsRecord == null || modificationsRecord.getModifications().size() == 0) {
//			logger.info("No modifications found. Skipping extension substitution.");
//			
//			return null;
//		}
//		else {
//			// compute text positions from position objects
//			for (Modification mod: modificationsRecord.getModifications()) {
//				EObject positionObject = workingModel.getResource().getEObject(mod.getSourceEObjectUri());
//				
//				Position position = workingModel.getObjectPosition(positionObject);
//				
//				if (mod instanceof Substitution) {
//					Substitution sub = (Substitution) mod;
//					sub.setSourceStart(position.getOffset());
//					sub.setSourceLength(position.getLength());
//				}
//				else if (mod instanceof Addition) {
//					Addition addition = (Addition) mod;
//					if (addition.isAddAfterPosition()) {
//						addition.setSourceStart(position.getOffset() + position.getLength());
//					}
//					else {
//						addition.setSourceStart(position.getOffset());
//					}
//				}				
//			}
//			
//			SequentialModificationApplier modificationApplier = new SequentialModificationApplier(modificationsRecord.getModifications(), workingModel.getText());
//			String workingText = modificationApplier.applyAll();
//			
//			logger.info("--------- text with extension substitutions ---------" + Activator.lineSep
//					+ workingText + Activator.lineSep);
//
//			return workingText;
//		}
//	}
	
	protected IPath getXmiRawLocation(URI xmiUri) {
		IPath xmiPath = new Path(xmiUri.toPlatformString(true));
		IPath xmiRawLocation = ResourcesPlugin.getWorkspace().getRoot().getFile(xmiPath).getRawLocation();
		return xmiRawLocation;
	}
	
	private ResourceSet workingCopiesResourceSet = new ResourceSetImpl();

	protected void cleanFolder(IFolder folder) {
		logger.info("Cleaning \"" + folder.toString() + "\" ...");
		File dir = new File(folder.getLocation().toString());
		if (dir.isDirectory()) {
			cleanFolderRecursive(dir);
		}
	}
	
	private void cleanFolderRecursive(File directory) {
		for (File containedElement: directory.listFiles()) {
			if (containedElement.isDirectory()) {
				cleanFolderRecursive(containedElement);
			}
			containedElement.delete();
		}
	}
	
	protected boolean compileJavaFiles(IProject project, IFolder folder) {
		try {
			//IFolder genFolder = getGenFolder(project);
			logger.info("Refresing \"" + folder.toString() + "\" ...");
			folder.refreshLocal(IResource.DEPTH_INFINITE, null);
			
			logger.info("Compiling Java files in project \"" + project.getName() + "\" ...");
			project.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor() {
				@Override
				public void done() {
					super.done();
				}
			});
			logger.info("Finished compiling.");
			return true;
			
			//logger.info("Refresing \"" + project.toString() + "\" ...");
			//project.refreshLocal(IResource.DEPTH_INFINITE, null);
		}
		catch (CoreException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	
	protected void launchJavaProgram(boolean sync, final IJavaProject project, final IPath workingDirectory, final String className, final String[] args) throws CoreException {

	}	
	
	protected IFolder javaGenFolder = null;

	protected IFolder getJavaGenFolder(IProject project) {
		if (javaGenFolder == null) {
			javaGenFolder = project.getFolder(JAVA_GEN_FOLDER);
		}
		return javaGenFolder;
	}
	
	private IFolder tempFolder = null;
	
	protected IFolder getTempFolder(IProject project) {
		if (tempFolder == null) {
			tempFolder = project.getFolder(TEMP_FOLDER);
		}
		return tempFolder;
	}
	
	boolean extendedMetamodelSaved = false;
	
	protected void saveExtendedDblMetaModelIfNecessary(IProject currentProject) {
		if (!extendedMetamodelSaved) {
			logger.info("Saving dbl.ecore (with extensions) to current project ...");
			URI metamodelXmiFile = URI.createFileURI(currentProject.getLocation().append("temp").append("dbl.ecore").toString());
			
			Resource resource = workingCopiesResourceSet.createResource(metamodelXmiFile);
			resource.getContents().clear();
			resource.getContents().add(EcoreUtil.copy(metaModelResource.getContents().get(0)));
			// TODO save resource directly by using a FileOutputStream
			
			try {
				resource.save(Collections.EMPTY_MAP);
				extendedMetamodelSaved = true;
				logger.info("Finished saving.");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

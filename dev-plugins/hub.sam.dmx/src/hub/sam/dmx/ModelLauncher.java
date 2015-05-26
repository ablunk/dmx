package hub.sam.dmx;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.ExtensionDefinition;
import hub.sam.dbl.Import;
import hub.sam.dbl.Model;
import hub.sam.dmx.modifications.Addition;
import hub.sam.dmx.modifications.Modification;
import hub.sam.dmx.modifications.ModificationsPackage;
import hub.sam.dmx.modifications.ModificationsRecord;
import hub.sam.dmx.modifications.Substitution;
import hub.sam.tef.modelcreating.HeadlessEclipseParser;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.semantics.AbstractError;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.IStreamListener;
import org.eclipse.debug.core.Launch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMRunner;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.VMRunnerConfiguration;
import org.eclipse.jface.text.Position;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.part.FileEditorInput;

public class ModelLauncher {
	
	private static final Logger logger = Logger.getLogger(ModelLauncher.class.getName());
	
	private final IProgressMonitor monitor;
	private final DblTextEditor editor;
	private final Display associatedDisplay;
	private final String targetSimLib;
	private final String targetLanguage;

	public static final String JAVA_GEN_FOLDER_NAME = "gen-src";
	public static final String TEMP_FOLDER_NAME = "temp";
	
	public ModelLauncher(IProgressMonitor monitor, Display associatedDisplay, DblTextEditor editor, String targetSimLib, String targetLanguage) {
		this.monitor = monitor;
		this.editor = editor;
		this.associatedDisplay = associatedDisplay;
		this.targetSimLib = targetSimLib;
		this.targetLanguage = targetLanguage;
	}
	
	private IProject getCurrentProject() {
		IFile file = ((FileEditorInput) editor.getEditorInput()).getFile();
		return file.getProject();
	}
	
	private class ParsedWorkingCopyModel {
		
		private final Resource resource;
		private final String text;
		private final ObjectPositionsContainer objectPositions;

		public ParsedWorkingCopyModel(ParsedWorkingCopyModel formerWorkingModel, Resource newResource, IModelCreatingContext newResourceCreationContext) {
			resource = formerWorkingModel.getResource();
			resource.getContents().clear();
			resource.getContents().addAll(newResource.getContents());
			
			text = newResourceCreationContext.getText();
			
			try {
				resource.save(Collections.EMPTY_MAP);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
			this.objectPositions = new ModelCreatingContextObjectPositionsContainer(newResourceCreationContext);
		}
		
		private class ObjectPositionCopier extends EcoreUtil.Copier {
			
			private final ObjectPositionsContainer originalObjectPositions;
			private final ObjectPositionsContainer copyObjectPositions = new ObjectPositionsContainer();
			
			public ObjectPositionCopier(ObjectPositionsContainer originalObjectPositions) {
				this.originalObjectPositions = originalObjectPositions;
			}

			@Override
			protected EObject createCopy(EObject original) {
				EObject copy = super.createCopy(original);
				Position originalPosition = originalObjectPositions.getPosition(original);
				if (originalPosition != null) {
					copyObjectPositions.setPosition(copy, new PositionWithNegative(originalPosition));
				}
				return copy;
			}
			
			public ObjectPositionsContainer getCopyObjectPositions() {
				return copyObjectPositions;
			}
			
		}
		
		private class ObjectPositionsContainer {
			
			private Map<EObject, Position> positions = new HashMap<EObject, Position>();
			
			public Position getPosition(EObject eObject) {
				return positions.get(eObject);
			}
			
			public void setPosition(EObject eObject, Position position) {
				positions.put(eObject, position);
			}
		}
		
		private class ModelCreatingContextObjectPositionsContainer extends ObjectPositionsContainer {
			private final IModelCreatingContext resourceCreationContext;
			
			public ModelCreatingContextObjectPositionsContainer(IModelCreatingContext resourceCreationContext) {
				this.resourceCreationContext = resourceCreationContext;
			}

			@Override
			public Position getPosition(EObject eObject) {
				return resourceCreationContext.getTreeNodeForObject(eObject).getPosition();
			}
		}
		
		public ParsedWorkingCopyModel(URI originalUri, Resource originalResource, boolean copy, IModelCreatingContext originalResourceCreationContext) {
			String workingCopyXmiName = originalUri.trimFileExtension() + "_base.xmi";
			URI workingCopyXmiUri = URI.createURI(workingCopyXmiName);
			
			resource = workingCopiesResourceSet.createResource(workingCopyXmiUri);
			resource.getContents().clear();
			
			if (copy) {
				ObjectPositionCopier copier = new ObjectPositionCopier(new ModelCreatingContextObjectPositionsContainer(originalResourceCreationContext));
				Collection<EObject> contentCopy = copier.copyAll(originalResource.getContents());
				copier.copyReferences();
				resource.getContents().addAll(contentCopy);
				objectPositions = copier.getCopyObjectPositions();
			}
			else {
				resource.getContents().addAll(originalResource.getContents());
				objectPositions = new ModelCreatingContextObjectPositionsContainer(originalResourceCreationContext);
			}
			
			text = originalResourceCreationContext.getText();
			
			try {
				resource.save(Collections.EMPTY_MAP);
			}
			catch (IOException e) {
				e.printStackTrace();
			}			
		}

		public Position getObjectPosition(EObject eObject) {
			return objectPositions.getPosition(eObject);
		}
		
		public void setObjectPosition(EObject eObject, Position position) {
			objectPositions.setPosition(eObject, position);
		}
		
		public Resource getResource() {
			return resource;
		}
		
		public String getText() {
			return text;
		}
		
		public Model getModel() {
			return (Model) resource.getContents().get(0);
		}
		
		public void save() {
			try {
				resource.save(Collections.EMPTY_MAP);
			}
			catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	/**
	 * substitutes a set of leaf extensions one after the other.
	 * 
	 * @author blunk
	 *
	 */
	private class SharedLeafExtensionsFirstModificationApplier {
		
		private final ParsedWorkingCopyModel workingModel;
		private final StringBuffer workingText;
		
		public SharedLeafExtensionsFirstModificationApplier(StringBuffer originalText, ParsedWorkingCopyModel originalModel) {
			this.workingText = originalText;
			this.workingModel = originalModel;			
		}
		
		public StringBuffer getWorkingText() {
			return workingText;
		}
		
		private EObject setStartLength(Modification mod) {
			EObject positionObject = workingModel.getResource().getEObject(mod.getSourceEObjectUri());
			
			Position position = workingModel.getObjectPosition(positionObject);
			
			if (mod instanceof Substitution) {
				Substitution sub = (Substitution) mod;
				sub.setSourceStart(position.getOffset());
				sub.setSourceLength(position.getLength());
			}
			else if (mod instanceof Addition) {
				Addition addition = (Addition) mod;
				if (addition.isAddAfterPosition()) {
					addition.setSourceStart(position.getOffset() + position.getLength());
				}
				else {
					addition.setSourceStart(position.getOffset());
				}
			}
			
			return positionObject;
		}
		
		private void shiftObjects(EObject referenceObject, boolean after, int v, boolean includeRefObjectChilds) {
			TreeIterator<EObject> containerContentsTree = referenceObject.eContainer().eAllContents();
			
			EObject current = null;
			Position referenceObjectPosition = workingModel.getObjectPosition(referenceObject);

			// shift all objects before referenceObject
			while (containerContentsTree.hasNext()) {
				current = containerContentsTree.next();
				Position currentPosition = workingModel.getObjectPosition(current);

				if (current == referenceObject) {
					if (!includeRefObjectChilds) containerContentsTree.prune();
					
					if (!after) {
						logger.info("shifting object " + current.eResource().getURIFragment(current) + " by " + v + " characters");
						currentPosition.setOffset(currentPosition.getOffset() + v);
					}
				}
				else if (currentPosition.getOffset() > referenceObjectPosition.getOffset()) {
					logger.info("shifting object " + current.eResource().getURIFragment(current) + " by " + v + " characters");
					currentPosition.setOffset(currentPosition.getOffset() + v);
				}
			}
		}
		
		private boolean substitutionApplied = false;
		
		public void applyAll(EList<Modification> unsortedModifications) {
			// apply modifications, adjust positions for other constructs						
			for (Modification mod: unsortedModifications) {
				
				EObject positionObject = setStartLength(mod);
				int startPos = mod.getSourceStart();
				
				if (mod instanceof Addition) {
					Addition addition = (Addition) mod;
					
					logger.info("inserting at text position: " + startPos + ", just after ... " + Activator.lineSep
							+ workingText.substring((startPos - 20 < 0 ? 0 : startPos - 20), startPos) + Activator.lineSep);
					
					workingText.insert(startPos, addition.getReplacementText());

					// adjust positions for other constructs
					shiftObjects(positionObject, addition.isAddAfterPosition(), addition.getReplacementText().length(), false);
				}
				else if (mod instanceof Substitution) {
//					if (substitutionApplied) {
//						logger.severe("there are at least 2 substitution modifications. an extension can only be substituted once.");
//						throw new RuntimeException();
//					}
					substitutionApplied = true;
					
					Substitution sub = (Substitution) mod;
					
					int endPos = startPos + sub.getSourceLength();
					
					String sourceFragment = workingText.substring(startPos, endPos);					
					logger.info("substituting source fragement: " + Activator.lineSep +
							sourceFragment + Activator.lineSep
							+ "by: " + Activator.lineSep +
							mod.getReplacementText() + Activator.lineSep);
					
					workingText.replace(startPos, endPos, mod.getReplacementText());

					shiftObjects(positionObject, true, mod.getReplacementText().length() - sub.getSourceLength(), false);
				}				

				logger.info("new working text: " + Activator.lineSep
						+ workingText + Activator.lineSep);
			}
		}
		
	}
	
	private Map<Model, Model> processedModels = new HashMap<Model, Model>();

	private Model translate(Model inputModel, boolean rootModel, BasicDblToJavaGenerator baseGenerator, IPath genFolder, boolean substituteExtensions) {
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

	private Model translateDbl(Model inputModel, boolean rootModel, BasicDblToJavaGenerator baseGenerator, IPath genFolder, boolean substituteExtensions) {
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
			baseGenerator.genModel(inputModel, rootModel);
			
			processedModels.put(inputModel, inputModel);
			return inputModel;
		}
		return processedModels.get(inputModel);
	}

	private Model translateDbx(IPath inputPath, File inputFile, Model inputModel, boolean rootModel, BasicDblToJavaGenerator baseGenerator, IPath genFolder, boolean substituteExtensions) {
		// prevents processing a model which is imported by different imports again
		if (!processedModels.containsKey(inputModel)) {
			
			// 1. create working copy of input model
			ParsedWorkingCopyModel parsedWorkingModel = null;
			
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
							parsedWorkingModel = new ParsedWorkingCopyModel(inputModel.eResource().getURI(),
									creationContext.getResource(), false, creationContext);
						}
					}
					catch (ModelCreatingException e) {
						e.printStackTrace();
					}
				}
			}
			else {
				// model is currently opened in active editor
				parsedWorkingModel = new ParsedWorkingCopyModel(inputModel.eResource().getURI(),
						inputModel.eResource(), true, editor.getLastModelCreatingContext());
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
			baseGenerator.genModel(parsedWorkingModel.getModel(), rootModel);
			
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
	
	private void refreshCurrentProject() {
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
	
	private Map<String, Collection<ExtensibleElement>> getLeafExtensionInstances(Model inputModel) {
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
	
	private Collection<String> extensionDefinitionSemanticsGenerated = new HashSet<String>();
	
	private ExtensionDefinitionsToJava _extensionDefinitionGenerator;
	
	private ExtensionDefinitionsToJava getExtensionDefinitionGenerator() {
		if (_extensionDefinitionGenerator == null) {
			IPath genFolder = getJavaGenFolder(getCurrentProject()).getRawLocation();
			_extensionDefinitionGenerator = new ExtensionDefinitionsToJava(genFolder);
		}
		return _extensionDefinitionGenerator;
	}
	
	/**
	 * substitutes all extensions by processing leaf extensions first
	 * 
	 * @param inputModel model containing extension instances
	 * @return workingModel either the inputModel or a copy of the inputModel with extension instances replaced
	 */
	private ParsedWorkingCopyModel substituteExtensions(ParsedWorkingCopyModel inputModel) {
		final IProject currentProject = getCurrentProject();
		final IJavaProject currentJavaProject = JavaCore.create(currentProject);

		ParsedWorkingCopyModel workingModel = inputModel;
		
		Map<String, Collection<ExtensibleElement>> leafExtensionInstances = getLeafExtensionInstances(workingModel.getModel());
		while (leafExtensionInstances.size() > 0) {
			
			SharedLeafExtensionsFirstModificationApplier sharedModificationApplier = new SharedLeafExtensionsFirstModificationApplier(
					new StringBuffer(workingModel.getText()), workingModel);
			
			boolean javaCodeAdded = false;
			Map<String, ExtensionDefinition> extensionDefinitions = new HashMap<String, ExtensionDefinition>();
			
			for (String extensionDefinitionName: leafExtensionInstances.keySet()) {

				// generate executable code from extension definition semantics
				ExtensionDefinition extensionDefinition = getExtensionDefinitionGenerator().getImportedExtensionDefinition(workingModel.getModel(), extensionDefinitionName);
				if (extensionDefinition == null) {
					logger.severe("cannot find the extension definition " + extensionDefinitionName + " by import anymore. possibly the extension definition itself was replaced.");
					throw new RuntimeException();
				}else {
					extensionDefinitions.put(extensionDefinitionName, extensionDefinition);
	
					if (!extensionDefinitionSemanticsGenerated.contains(extensionDefinitionName)) {
						extensionDefinitionSemanticsGenerated.add(extensionDefinitionName);
						logger.info("Generating executable semantics for extension definition " + extensionDefinitionName);
						
						getExtensionDefinitionGenerator().genExtensionDefinition(workingModel.getModel(), extensionDefinition);
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
					try {			
						String[] arguments = new String[] {
								getXmiRawLocation(workingModel.getResource().getURI()).toString(),
								AbstractExtensionSemantics.getEmfUriFragment(extensionInstance),
								inputPath.toString()
							};
						String qualifiedExtensionDefinitionName = getExtensionDefinitionGenerator().javaNameQualified(extensionDefinitions.get(extensionDefinitionName));
						launchJavaProgram(true, currentJavaProject, workingDirectory, qualifiedExtensionDefinitionName + "Semantics", arguments);
					}
					catch (CoreException e) {
						e.printStackTrace();
					}
					
					// text substitute extension instances by result of semantics executions
					EList<Modification> storedModifications = getLastStoredModifications();
					
					monitor.subTask("Applying modifications");
					
					logger.info("--------- input text ---------" + Activator.lineSep
							+ workingModel.getText() + Activator.lineSep);
						
					if (storedModifications == null || storedModifications.size() == 0) {
						logger.severe("No modifications found after executing semantics description of extension definition " + extensionDefinitionName + ".");
						continue extensionInstanceLoop;
					}
					else {									
						sharedModificationApplier.applyAll(storedModifications);
					}
				}
			}
			
			// after leaf extensions have been substituted:
			// parse text with headless DBL parser to >>workingModel<<
			String filename = workingModel.getResource().getURI().trimFileExtension().appendFileExtension("dbx").lastSegment();

			HeadlessEclipseParser parser = new DbxParser(inputPath, filename);
			
			try {
				//lastInputModelContext = parser.parse("module test { void main() { print \"hello\"; } }");
				IModelCreatingContext modelCreationContext = parser.parse(sharedModificationApplier.getWorkingText().toString());
				
				if (modelCreationContext.getErrors().size() > 0) {
					printParseErrorsToEditorConsole(modelCreationContext, filename, sharedModificationApplier.getWorkingText().toString());
					throw new RuntimeException(modelCreationContext.getErrors().iterator().next().getMessage());
				}
				else {
					workingModel = new ParsedWorkingCopyModel(workingModel,
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
	
	private void printParseErrorsToEditorConsole(IModelCreatingContext context, String filename, String sourceText) {
		final MessageConsoleStream stream = getConsoleForCurrentEditor().newMessageStream();
		for (AbstractError error: context.getErrors()) {
			Position errorPosition = error.getPosition(context);
			stream.println(filename + " >> " + error.getMessage());
			if (errorPosition.offset >= 0) {
				stream.println("text before error:\n" + sourceText.substring(0, errorPosition.offset));
			}
		}
	}
		
	private EList<Modification> getLastStoredModifications() {
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
	
	@Deprecated
	private String textSubstituteExtensionInstances_old(ParsedWorkingCopyModel workingModel) {
		monitor.subTask("Applying modifications");
		
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
			break;
		}
		
		logger.info("--------- input text ---------" + Activator.lineSep
				+ workingModel.getText() + Activator.lineSep);
			
		if (modificationsRecord == null || modificationsRecord.getModifications().size() == 0) {
			logger.info("No modifications found. Skipping extension substitution.");
			
			return null;
		}
		else {
			// compute text positions from position objects
			for (Modification mod: modificationsRecord.getModifications()) {
				EObject positionObject = workingModel.getResource().getEObject(mod.getSourceEObjectUri());
				
				Position position = workingModel.getObjectPosition(positionObject);
				
				if (mod instanceof Substitution) {
					Substitution sub = (Substitution) mod;
					sub.setSourceStart(position.getOffset());
					sub.setSourceLength(position.getLength());
				}
				else if (mod instanceof Addition) {
					Addition addition = (Addition) mod;
					if (addition.isAddAfterPosition()) {
						addition.setSourceStart(position.getOffset() + position.getLength());
					}
					else {
						addition.setSourceStart(position.getOffset());
					}
				}				
			}
			
			IncrementalModificationApplier modificationApplier = new IncrementalModificationApplier(modificationsRecord.getModifications(), workingModel.getText());
			String workingText = modificationApplier.applyAll();
			
			logger.info("--------- text with extension substitutions ---------" + Activator.lineSep
					+ workingText + Activator.lineSep);

			return workingText;
		}
	}
	
	private IPath getXmiRawLocation(URI xmiUri) {
		IPath xmiPath = new Path(xmiUri.toPlatformString(true));
		IPath xmiRawLocation = ResourcesPlugin.getWorkspace().getRoot().getFile(xmiPath).getRawLocation();
		return xmiRawLocation;
	}
	
	private ResourceSet workingCopiesResourceSet = new ResourceSetImpl();
	
	private Resource createWorkingCopy(Resource originalResource) {
		String workingCopyXmiName = originalResource.getURI().trimFileExtension() + "_base.xmi";

		URI workingCopyXmiUri = URI.createURI(workingCopyXmiName);

//		IPath workingCopyXmiRawLocation = getXmiRawLocation(workingCopyXmiUri);		
//		FileOutputStream originalAsXmiStream;
//		try {
//			originalAsXmiStream = new FileOutputStream(workingCopyXmiRawLocation.toString());
//			originalResource.save(originalAsXmiStream, Collections.EMPTY_MAP);
//		}
//		catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
		
		Resource workingCopyResource = workingCopiesResourceSet.createResource(workingCopyXmiUri);
		workingCopyResource.getContents().clear();
		workingCopyResource.getContents().addAll(EcoreUtil.copyAll(originalResource.getContents()));
		
		try {
			workingCopyResource.save(Collections.EMPTY_MAP);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return workingCopyResource;
	}

	private void cleanFolder(IFolder folder) {
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
	
	private boolean compileJavaFiles(IProject project, IFolder folder) {
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
	
	private void launchJavaProgram(boolean sync, final IJavaProject project, final IPath workingDirectory, final String className, final String[] args) throws CoreException {
		if (associatedDisplay != null) {
			if (sync) {
				associatedDisplay.syncExec(new Runnable () {
				      public void run () {
				    	  try {
							launchJavaProgram0(project, workingDirectory, className, args);
						}
				    	catch (CoreException e) {
							e.printStackTrace();
						}
				      }
				});
			}
			else {
				associatedDisplay.asyncExec(new Runnable () {
				      public void run () {
				    	  try {
							launchJavaProgram0(project, workingDirectory, className, args);
						}
				    	catch (CoreException e) {
							e.printStackTrace();
						}
				      }
				});
			}
		}
		else {
			launchJavaProgram0(project, workingDirectory, className, args);
		}
	}
	
	private void launchJavaProgram0(IJavaProject project, IPath workingDirectory, String className, String[] args) throws CoreException {
		IVMInstall vmInstall = JavaRuntime.getVMInstall(project);
		if (vmInstall == null) {
			vmInstall = JavaRuntime.getDefaultVMInstall();
		}
		if (vmInstall != null) {
			IVMRunner vmRunner = vmInstall.getVMRunner(ILaunchManager.RUN_MODE);
			if (vmRunner != null) {
				String[] classPath = null;
				try {
					classPath = JavaRuntime.computeDefaultRuntimeClassPath(project);
				}
				catch (CoreException e) {
				}
				if (classPath != null) {
					VMRunnerConfiguration vmConfig = new VMRunnerConfiguration(className, classPath);
					if (args != null) {
						vmConfig.setProgramArguments(args);
					}
					vmConfig.setWorkingDirectory(workingDirectory.toString());
					final ILaunch launch = new Launch(null, ILaunchManager.RUN_MODE, null);
					logger.info("Launching Java program " + className + " ... ");
					vmRunner.run(vmConfig, launch, null);
			        final IProcess[] processes = launch.getProcesses();

			        if (launch.getProcesses().length == 0) {
			        	logger.severe("Program could not be launched.");
					}
					else {
						final MessageConsoleStream stream = getConsoleForCurrentEditor().newMessageStream();
						
						IStreamListener outputStreamListener = new IStreamListener() {
							@Override
							public void streamAppended(String text, IStreamMonitor monitor) {
								stream.print(text);
							}
						};
						processes[0].getStreamsProxy().getOutputStreamMonitor().addListener(outputStreamListener);
						
						final MessageConsoleStream errorStream = getConsoleForCurrentEditor().newMessageStream();
						if (associatedDisplay != null) {
							final Color errorColor = associatedDisplay.getSystemColor(SWT.COLOR_RED);
							errorStream.setColor(errorColor);
						}
						
						IStreamListener errorStreamListener = new IStreamListener() {
							@Override
							public void streamAppended(String text, IStreamMonitor monitor) {
								errorStream.print(text);
							}
						};
						processes[0].getStreamsProxy().getErrorStreamMonitor().addListener(errorStreamListener);
						
        				while (!launch.isTerminated()) {
        					try {
        						Thread.sleep(100);
        					}
				            catch (InterruptedException ie) {
				                ie.printStackTrace();
				            }
        					if (processes[0].getStreamsProxy().getErrorStreamMonitor().getContents().length() > 0) {
        						logger.severe("Error encountered.");
        						break;
        					}
        				}
        				
        				processes[0].getStreamsProxy().getOutputStreamMonitor().removeListener(outputStreamListener);
        				processes[0].getStreamsProxy().getErrorStreamMonitor().removeListener(errorStreamListener);
        				
        				try {
							stream.close();
							errorStream.close();
						}
        				catch (IOException e) {
							e.printStackTrace();
						}
        				
        				logger.info("Program terminated.");
					}
				}
			}
		}
	}
	
	private void resetConsole() {
		MessageConsole console = getConsoleForCurrentEditor();
		console.clearConsole();
		console.activate();
	}
	
	private MessageConsole getConsoleForCurrentEditor() {
		return getConsole(editor.getPartName() + " execution");
	}
	
	private List<String> getJavaFiles(IPath folder) {
		File file = new File(folder.toString());
		String[] javaFiles = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});
		List<String> list = new ArrayList<String>();
		for (String javaFile: javaFiles) {
			list.add(javaFile);
		}
		return list;
	}
	
	MessageConsole getConsole(String name) {
		IConsoleManager conMgr = ConsolePlugin.getDefault().getConsoleManager();
		for (IConsole console: conMgr.getConsoles()) {
			if (console instanceof MessageConsole) {
				MessageConsole msgConsole = (MessageConsole) console;
				if (msgConsole.getName().equals(name)) {
					return msgConsole;
				}
			}
		}
		MessageConsole msgConsole = new MessageConsole(name, null);
		conMgr.addConsoles(new IConsole[] { msgConsole });
		return msgConsole;
	}
	
	private void redirectInputToConsole(Process process) {
		try {
			MessageConsole console = getConsole(editor.getPartName() + " execution");
			int b = process.getInputStream().read();
			while (b != -1) {
				console.newMessageStream().write(b);
				b = process.getInputStream().read();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Resource copyResourceToXmi(Resource originalResource, URI xmiFile) {
		EObject root = originalResource.getContents().get(0);

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(DblPackage.eNS_URI, DblPackage.eINSTANCE);
		
		Resource res = resourceSet.createResource(xmiFile);
		
		res.getContents().clear();
		res.getContents().add(EcoreUtil.copy(root));

		return res;
	}
	
	private void saveAsXmi(Resource resource, URI xmiFile) {
		EObject root = resource.getContents().get(0);

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(DblPackage.eNS_URI, DblPackage.eINSTANCE);
		
		Resource res = resourceSet.createResource(xmiFile);
		
		res.getContents().clear();
		res.getContents().add(EcoreUtil.copy(root));
		//res.getContents().add(root);
		
		try {
			res.save(Collections.EMPTY_MAP);
			logger.info("saved XMI: " + xmiFile);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void compileAndRun() {
		long startCompileTime = System.nanoTime();
		
		monitor.beginTask("Compile && Run ...", 100);
		
		monitor.subTask("Refreshing folders");
		refreshCurrentProject();
		
		IProject currentProject = getCurrentProject();
		IPath genPath = getJavaGenFolder(currentProject).getRawLocation();

		monitor.subTask("Cleaning folders");
		cleanFolder(getTempFolder(currentProject));
		cleanFolder(getJavaGenFolder(currentProject));
		
		resetConsole();

		monitor.worked(5); // 5%
//		monitor.subTask("Generating EMF Java classes for DBL metamodel");
//		genEmfJavaClasses(currentProject);

		monitor.subTask("Translating model to target language program");

		// 1a. NEW --> Access properties by EMF's reflection mechanism. In this, no EMF code needs to generated here.

		Resource originalResource = editor.getCurrentModel();
		Model rootModel = (Model) originalResource.getContents().get(0);
		BasicDblToJavaGenerator baseGenerator = null;
		if (targetSimLib == "desmoj") {
			baseGenerator = new DblToDesmojJavaGenerator(genPath);
		}

		final IFile inputFile = ((FileEditorInput) editor.getEditorInput()).getFile();
		final boolean isDbxInputFile = inputFile.getFileExtension().equals("dbx");

		logger.info("Compiling and executing model " + inputFile + " ...");

		translate(rootModel, true, baseGenerator, genPath, isDbxInputFile);
		
		monitor.worked(50); // 55%
		monitor.subTask("Compiling target language program");

		boolean compileOk = false;
		compileOk = compileJavaFiles(currentProject, getJavaGenFolder(currentProject));

		long estimatedTime = System.nanoTime() - startCompileTime;
		long ms = estimatedTime / (1000 * 1000);
		logger.info("Overall compile time: " + ms / 1000.0 + " seconds");
		
		monitor.worked(40); // 95%

		if (compileOk) {
			try {
				monitor.subTask("Executing target language program");				
				
				IJavaProject currentJavaProject = JavaCore.create(currentProject);
				IPath workingDirectory = currentProject.getLocation();

				launchJavaProgram(true, currentJavaProject, workingDirectory, baseGenerator.javaPackageFolderPrefix + "/JavaMain", null);
				
				monitor.worked(5); // 100%
			}
			catch (CoreException e) {
				e.printStackTrace();
				return;
			}
		}
	}
	
	private IFolder javaGenFolder = null;

	private IFolder getJavaGenFolder(IProject project) {
		if (javaGenFolder == null) {
			javaGenFolder = project.getFolder(JAVA_GEN_FOLDER_NAME);
		}
		return javaGenFolder;
	}
	
	private IFolder tempFolder = null;
	
	private IFolder getTempFolder(IProject project) {
		if (tempFolder == null) {
			tempFolder = project.getFolder(TEMP_FOLDER_NAME);
		}
		return tempFolder;
	}
	
	boolean extendedMetamodelSaved = false;
	
	private void saveExtendedDblMetaModelIfNecessary(IProject currentProject) {
		if (!extendedMetamodelSaved) {
			logger.info("Saving dbl.ecore (with extensions) to current project ...");
			Resource metaModelResource = editor.getDblMetaModel().eResource();
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
	
	private void genEmfJavaClasses(IProject currentProject) {
		IPath tempFolder = currentProject.getLocation().append("temp");
		
		// 1.1. save current dbl metamodel (probably modified by extensions) as an ecore file
		saveExtendedDblMetaModelIfNecessary(currentProject);
		
		// 1.2. copy dbl.genmodel to current project by opening a stream to it in the hub.sam.dmx bundle
		logger.info("Copying dbl.genmodel to current project ...");
		URL genModelUrl = FileLocator.find(Activator.getDefault().getBundle(), new Path("resources/dbl.genmodel"), null);
		IPath workingGenModel = tempFolder.append("dbl.genmodel");
		try {
			InputStream inStream = genModelUrl.openStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inStream));

			FileWriter outStream = new FileWriter(workingGenModel.toString());
			BufferedWriter out = new BufferedWriter(outStream);
			
			String line = null;
			while ((line = in.readLine()) != null) {
				out.write(line + "\n");
			}
			
			out.close();
			in.close();
			
			logger.info("Finished copying.");
		}
		catch (Exception e) {
			throw new RuntimeException();
		}

		// 1.2.1. Reload genmodel
		
		logger.info("Reloading genmodel ...");
		ResourceSet resourceSet = new ResourceSetImpl();
        //resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());
        URI genModelURI = URI.createFileURI(workingGenModel.toString());
        Resource genModelResource = resourceSet.getResource(genModelURI, true);
        GenModel genModel = (GenModel) genModelResource.getContents().get(0);
        
        Resource metaModelResource = editor.getDblMetaModel().eResource();
        EPackage metaModelPackage = (EPackage) metaModelResource.getContents().get(0);
        for (GenPackage genPackage: genModel.getGenPackages()) {
        	EPackage ePackage = genPackage.getEcorePackage();
        	if (ePackage.getNsURI().equals(metaModelPackage.getNsURI())) {
        		genModel.initialize(Collections.singleton(ePackage));
        	}
        }
        
		try {
			genModelResource.save(Collections.EMPTY_MAP);
			logger.info("Finished reloading.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
        
		// 1.3. run code generation for the genmodel
		
		// INFO: EMF code generation ultimately takes place in method
		//       org.eclipse.emf.codegen.ecore.genmodel.generator.generateModel(...)
		//       in plugin org.eclipse.emf.codegen.ecore

		logger.info("Generating EMF Java code ...");
		
		Generator emfGenerator = new Generator();
		
		String args = "-projects " + currentProject.getLocation().toString()
				+ " -model"
				+ " " + workingGenModel.toString();
				//+ " " + currentProject.getLocation().append("gen-src");
		logger.info(args);
		
		StringTokenizer st = new StringTokenizer(args);
		String[] args2 = new String[st.countTokens()];
		int i=0;
		while (st.hasMoreTokens()) {
			args2[i] = st.nextToken();
			i++;
		}
		Object generatorResult = emfGenerator.run(args2);
		if (generatorResult instanceof Integer) {
			Integer intGeneratorResult = (Integer) generatorResult;
			if (intGeneratorResult.intValue() == 1) {
				logger.info("An error occured.");
				return;
			}
		}
		logger.info("Finished generating.");
		
		// 1.4. Compile generated EMF code
		IProject emfProject = currentProject.getWorkspace().getRoot().getProject("hub.sam.dbl.model");
		compileJavaFiles(emfProject, emfProject.getFolder("src"));
	}

}

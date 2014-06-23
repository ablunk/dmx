package hub.sam.dmx;

import hub.sam.tef.modelcreating.HeadlessEclipseParser;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.dmx.modifications.Addition;
import hub.sam.dmx.modifications.Modification;
import hub.sam.dmx.modifications.ModificationsPackage;
import hub.sam.dmx.modifications.ModificationsRecord;
import hub.sam.dmx.modifications.Substitution;
import hub.sam.dbl.Extension;
import hub.sam.dbl.ExtensionDefinition;
import hub.sam.dbl.Import;
import hub.sam.dbl.Model;
import hub.sam.dbl.Module;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Procedure;
import hub.sam.dbl.SimpleAnnotation;
import hub.sam.tef.semantics.AbstractError;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.IStreamListener;
import org.eclipse.debug.core.Launch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
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
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.text.Position;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IOConsoleOutputStream;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.part.FileEditorInput;

public class XtendRunAction extends Action {

	private final DblTextEditor editor;

	public static final String JAVA_GEN_FOLDER_NAME = "gen-src";
	public static final String TEMP_FOLDER_NAME = "temp";
	
	private String targetSimLib;
	
	public XtendRunAction(DblTextEditor editor) {
		this.editor = editor;
	}
	
	public String getTargetSimLib() {
		return targetSimLib;
	}

	public void setTargetSimLib(String targetSimLib) {
		this.targetSimLib = targetSimLib;
	}

	public boolean isEnabled() {
		return !editor.hasError() && editor.getCurrentModel() != null && editor.getCurrentModel().getContents().size() > 0;
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
	
	private void saveCurrentDblMetaModel(IProject currentProject) {
		System.out.println("Saving dbl.ecore (with extensions) to current project ...");
		Resource metaModelResource = editor.getDblMetaModel().eResource();
		URI metamodelXmiFile = URI.createFileURI(currentProject.getLocation().append("temp").append("dbl.ecore").toString());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource res = resourceSet.createResource(metamodelXmiFile);
		res.getContents().clear();
		res.getContents().add(EcoreUtil.copy(metaModelResource.getContents().get(0)));
		// TODO save resource directly by using a FileOutputStream
		
		try {
			res.save(Collections.EMPTY_MAP);
			System.out.println("Finished saving.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void genEmfJavaClasses(IProject currentProject) {
		IPath tempFolder = currentProject.getLocation().append("temp");
		
		// 1.1. save current dbl metamodel (probably modified by extensions) as an ecore file
		saveCurrentDblMetaModel(currentProject);
		
		// 1.2. copy dbl.genmodel to current project by opening a stream to it in the hub.sam.dmx bundle
		System.out.println("Copying dbl.genmodel to current project ...");
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
			
			System.out.println("Finished copying.");
		}
		catch (Exception e) {
			throw new RuntimeException();
		}

		// 1.2.1. Reload genmodel
		
		System.out.println("Reloading genmodel ...");
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
			System.out.println("Finished reloading.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
        
		// 1.3. run code generation for the genmodel
		
		// INFO: EMF code generation ultimately takes place in method
		//       org.eclipse.emf.codegen.ecore.genmodel.generator.generateModel(...)
		//       in plugin org.eclipse.emf.codegen.ecore

		System.out.println("Generating EMF Java code ...");
		
		Generator emfGenerator = new Generator();
		
		String args = "-projects " + currentProject.getLocation().toString()
				+ " -model"
				+ " " + workingGenModel.toString();
				//+ " " + currentProject.getLocation().append("gen-src");
		System.out.println(args);
		
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
				System.out.println("An error occured.");
				return;
			}
		}
		System.out.println("Finished generating.");
		
		// 1.4. Compile generated EMF code
		IProject emfProject = currentProject.getWorkspace().getRoot().getProject("hub.sam.dbl.model");
		compileJavaFiles(emfProject, emfProject.getFolder("src"));
	}
	
	private Display currentDisplay;
	
	public void run() {
		currentDisplay = Display.getCurrent();

		final IRunnableWithProgress runnable = new IRunnableWithProgress() {
			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				run0(monitor);
				monitor.done();
			}
		};
		
//		final Job job = new Job("Compile & Run") {
//			@Override
//			protected IStatus run(IProgressMonitor monitor) {
//				runnable.run(monitor);
//				return Status.OK_STATUS;
//			}
//		};
//		job.schedule();
		
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(currentDisplay.getActiveShell());
        try {
			dialog.run(true, false, runnable);
		}
        catch (InvocationTargetException e) {
			e.printStackTrace();
		}
        catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	private IProject getCurrentProject() {
		IFile file = ((FileEditorInput) editor.getEditorInput()).getFile();
		return file.getProject();
	}
	
	private void run0(IProgressMonitor monitor) {
		long startCompileTime = System.nanoTime();
		
		IFile file = ((FileEditorInput) editor.getEditorInput()).getFile();
		final boolean dbxFile = file.getFileExtension().equals("dbx");

		monitor.beginTask("Compile && Run ...", 100);
		
		monitor.subTask("Refreshing and cleaning");
		IProject currentProject = getCurrentProject();
		try {
			currentProject.refreshLocal(IResource.DEPTH_INFINITE, null);
		}
		catch (CoreException e1) {
			e1.printStackTrace();
			return;
		}
		
		IPath genFolder = getJavaGenFolder(currentProject).getRawLocation();
		cleanFolder(getTempFolder(currentProject));
		cleanFolder(getJavaGenFolder(currentProject));
		
		resetConsole();
		monitor.worked(5); // 5%
		
		// 1a. NEW --> Access properties by EMF's reflection mechanism. In this, no EMF code needs to generated here.

		// 1b. save the current dbl meta-model to '<current-project>/temp/dbl.ecore' including additions made by extensions
		//saveCurrentDblMetaModel(currentProject);
		
		// TODO 2. for every extension used in the model, generate Java code for executing the semantics of the extension definition that they are defined by
		
		if (dbxFile) {
			// TODO
		}
		monitor.worked(10); // 15%
				
		// 3. invoke Xtend for BaseToTarget transformation
		
		monitor.subTask("Generating program in target language");
		
		System.out.println("Executing Base-To-Target transformation ...");
		System.out.println("Target: Java/" + TransformationProperties.getSimLib());
		
		Resource originalResource = editor.getCurrentModel();
		
		BasicDblToJavaGenerator generator = null;
		
		if (targetSimLib == "desmoj") {
			generator = new DblToDesmojJavaGenerator(originalResource, genFolder);
		}
		generator.startGenerator();

		IPath workingDirectory = currentProject.getLocation();
		IJavaProject currentJavaProject = JavaCore.create(currentProject);
//		try {
//			launchJavaProgram(true, currentJavaProject, workingDirectory, "hub.sam.dmx.BaseToJava", new String[] { modelFile, genFolder.toString() });
//		}
//		catch (CoreException e1) {
//			e1.printStackTrace();
//			return;
//		}
		
		monitor.worked(30); // 45%

		// 6. compile and execute generated artifacts
		
		/*monitor.subTask("Compiling target language code");
		
		boolean compileOk = false;
		compileOk = compileJavaFiles(currentProject, getJavaGenFolder(currentProject));

		long estimatedTime = System.nanoTime() - startCompileTime;
		long ms = estimatedTime / (1000 * 1000);
		System.out.println("Compile time: " + ms / 1000.0 + " seconds");
		
		monitor.worked(5); // 95%

		if (compileOk) {
			try {
				monitor.subTask("Executing target language program");				
				launchJavaProgram(true, currentJavaProject, workingDirectory, "JavaMain", null);
				monitor.worked(5); // 100%
			}
			catch (CoreException e) {
				e.printStackTrace();
				return;
			}
		}*/		
	}
	
	private void translateExtensions(IProgressMonitor monitor, Resource originalResource,
			URI workingCopyXmiUri, IPath workingCopyXmiFile) {

		monitor.subTask("Looking for extension instances");
		
		Collection<String> importedExtensionDefinitionNames = new HashSet<String>();
		Model model = (Model) originalResource.getContents().get(0);
		for (Import imprt: model.getImports()) {
			for (Module importedModule: imprt.getModel().getModules()) {
				// TODO add support for multiple levels of imports
				for (ExtensionDefinition extensionDef: importedModule.getExtensionDefs()) {
					importedExtensionDefinitionNames.add(extensionDef.getName());
				}
			}
		}
		
		Collection<Extension> extensionInstances = new HashSet<Extension>();
		TreeIterator<EObject> allContents = originalResource.getAllContents();
		while (allContents.hasNext()) {
			EObject eObject = allContents.next();
			if (eObject instanceof Extension) {
				// NOTE All extension meta-classes have to extend the meta-class Extension. This is necessary in order to find them in the model.
				// For example, a Statement extension must instantiate StatementExtension: Statement:instantiates(StatementExtension) -> ... ;
				
				Extension extensionInstance = (Extension) eObject;
				if (importedExtensionDefinitionNames.contains(extensionInstance.eClass().getName())) {
					extensionInstances.add(extensionInstance);
					System.out.println("Found an extension instance of class " + extensionInstance.eClass().getName());
				}
			}
		}
		
		monitor.worked(5); // 55%		
		
		if (extensionInstances.size() > 0) {
		
			monitor.subTask("Generating Java code for semantics definitions");
			
			IProject currentProject = getCurrentProject();
			IPath genFolder = getJavaGenFolder(currentProject).getRawLocation();

			IPath workingDirectory = currentProject.getLocation();
			IJavaProject currentJavaProject = JavaCore.create(currentProject);

			// generate all ExtensionSemantics classes by executing ExtensionsToJava.mtl
			System.out.println("Generating Java files for executing semantics definitions (ExtensionsToJava.mtl) ...");
			
			// NOTE Usually, launching an Acceleo template from the current project won't work. This is because Acceleo
			//      needs to create objects of non-existent extension meta-classes, e.g. Unless. We worked around this
			//      problem by manually adapting the metamodel factory in DblFactoryImpl.create(...).
			//      -> changed default case to: return DbxModelCreationContext.createObjectOfParentClass(eClass);
			//ExtensionsToJava.main(new String[] { workingCopyXmiFile.toString(), genFolder.toString() });
			try {
				launchJavaProgram(true, currentJavaProject, workingDirectory, "hub.sam.dmx.ExtensionsToJava", new String[] { workingCopyXmiFile.toString(), genFolder.toString() });
			}
			catch (CoreException e1) {
				e1.printStackTrace();
				return;
			}
			System.out.println("Finished.");
			
			monitor.worked(10); // 65%
			
			monitor.subTask("Compiling Java code for semantics definitions");
			
			// execute the generated Java code and remember its execution result as the substitution text for step 3 below
			compileJavaFiles(currentProject, getJavaGenFolder(currentProject));
			
			monitor.worked(5); // 70%
			
			monitor.subTask("Executing semantics definition");
			
			createEmptyModificationsXmi(currentProject);
			
			for (Extension extensionInstance: extensionInstances) {
				String extensionDef = extensionInstance.eClass().getName();
				
				try {
					launchJavaProgram(true, currentJavaProject, workingDirectory, extensionDef+"Semantics",
							new String[] { workingCopyXmiFile.toString(), AbstractExtensionSemantics.getEmfUriFragment(extensionInstance) });
				}
				catch (CoreException e) {
					e.printStackTrace();
					return;
				}
			}
			
			monitor.subTask("Applying modifications");
				
			// get all the modifications from <temp-folder>/modifications.xmi
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
	    	resourceSet.getPackageRegistry().put(ModificationsPackage.eNS_URI, ModificationsPackage.eINSTANCE);
	
	    	String modificationsXmiFile = getTempFolder(currentProject).getLocation().append("modifications.xmi").toString();
			URI modificationsFileUri = URI.createFileURI(new File(modificationsXmiFile).getAbsolutePath());		
			
			Resource modificationsResource = resourceSet.getResource(modificationsFileUri, true);
			ModificationsRecord modificationsRecord = null;
			for (EObject rootObject: modificationsResource.getContents()) {
				modificationsRecord = (ModificationsRecord) rootObject;
				break;
			}
			
			// 3. substitute the text of extension instances by their semantics execution result
			String originalText = editor.getCurrentText();
			System.out.println("--------- original text ---------");
			System.out.println(originalText);
			System.out.println("--------- ------------- ---------");
				
			if (modificationsRecord == null) {
				System.out.println("No modifications found. Skipping extension substitution.");
			}
			else {
				// compute text positions from position objects
				for (Modification mod: modificationsRecord.getModifications()) {
					EObject positionObject = originalResource.getEObject(mod.getSourceEObjectUri());
					Position position = editor.getLastModelCreatingContext().getTreeNodeForObject(positionObject).getPosition();
					
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
				
				IncrementalModificationApplier modificationApplier = new IncrementalModificationApplier(modificationsRecord.getModifications(), originalText);
				String workingText = modificationApplier.applyAll();
				
				System.out.println("--------- text with extension substitutions ---------");
				System.out.println(workingText);
				System.out.println("--------- --------------------------------- ---------");
	
				// 4. parse input text again (contains BL constructs only), save as XMI
				HeadlessEclipseParser parser = new DblParser(workingCopyXmiFile);
				try {
					//IModelCreatingContext context = parser.parse("module test { void main() { print \"hello\"; } }");
					IModelCreatingContext context = parser.parse(workingText);
					if (context.getErrors().size() > 0) {
						for (AbstractError error: context.getErrors()) {
							System.out.println("ERROR: " + error.getMessage());
							return;
						}
					}
				}
				catch (ModelCreatingException e) {
					e.printStackTrace();
				}
				saveAsXmi(parser.getLastModelCreationContext().getResource(), workingCopyXmiUri);
			}
			
			monitor.worked(10); // 80%
		}
		else {
			monitor.worked(25); // 80%
		}
	}
	
	private void createEmptyModificationsXmi(IProject currentProject) {
		ResourceSet resourceSet = new ResourceSetImpl();
		//resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
    	resourceSet.getPackageRegistry().put(ModificationsPackage.eNS_URI, ModificationsPackage.eINSTANCE);

    	String modificationsXmiFile = getTempFolder(currentProject).getLocation().append("modifications.xmi").toString();
		URI modificationsFileUri = URI.createFileURI(new File(modificationsXmiFile).getAbsolutePath());		
		
		Resource modificationsResource = resourceSet.createResource(modificationsFileUri);
		
		try {
			modificationsResource.save(Collections.EMPTY_MAP);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void cleanFolder(IFolder folder) {
		System.out.println("Cleaning \"" + folder.toString() + "\" ...");
		File dir = new File(folder.getLocation().toString());
		if (dir.isDirectory()) {
			for (File file: dir.listFiles()) {
				file.delete();
			}
		}
	}

	private Collection<Extension> getExtensionInstances(Resource resource) {
		Collection<Extension> instances = new HashSet<Extension>();
		TreeIterator<EObject> allContents = resource.getAllContents();
		while (allContents.hasNext()) {
			EObject eObject = allContents.next();
			if (eObject instanceof Extension) {
				instances.add((Extension) eObject);
			}
		}
		return instances;
	}
	
	private boolean compileJavaFiles(IProject project, IFolder folder) {
		try {
			//IFolder genFolder = getGenFolder(project);
			System.out.println("Refresing \"" + folder.toString() + "\" ...");
			folder.refreshLocal(IResource.DEPTH_INFINITE, null);
			
			System.out.println("Compiling Java files in project \"" + project.getName() + "\" ...");
			project.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor() {
				@Override
				public void done() {
					super.done();
				}
			});
			System.out.println("Finished compiling.");
			return true;
			
			//System.out.println("Refresing \"" + project.toString() + "\" ...");
			//project.refreshLocal(IResource.DEPTH_INFINITE, null);
		}
		catch (CoreException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	
	private void launchJavaProgram(boolean sync, final IJavaProject project, final IPath workingDirectory, final String className, final String[] args) throws CoreException {
		if (sync) {
			currentDisplay.syncExec(new Runnable () {
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
			currentDisplay.asyncExec(new Runnable () {
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
					System.out.println("Launching Java program " + className + " ... ");
					vmRunner.run(vmConfig, launch, null);
			        final IProcess[] processes = launch.getProcesses();

			        if (launch.getProcesses().length == 0) {
						System.out.println("Program could not be launched.");
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
						final Color errorColor = Display.getCurrent().getSystemColor(SWT.COLOR_RED);
						errorStream.setColor(errorColor);
						
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
        						System.out.println("Error encountered.");
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
        				
						System.out.println("Program terminated.");
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
			System.out.println("saved XMI: " + xmiFile);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

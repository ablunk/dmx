package hub.sam.dmx.launcher;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Display;

import hub.sam.dbl.Import;
import hub.sam.dbl.Model;
import hub.sam.dmx.launcher.java.JavaClassLauncher;
import hub.sam.dmx.launcher.programoutput.ProgramOutputPrinter;
import hub.sam.dmx.semantics.BaseCPlusPlusGenerator;
import hub.sam.dmx.targetcode.SpecificSimulationCPlusPlusGenerator;
import hub.sam.tef.modelcreating.IModelCreatingContext;

public class ModelLauncherC<BasicDBLToCGenerator, DblToLabelsAsValuesCGenerator> extends ModelLauncher{
	
	public static final String C_GEN_FOLDER_NAME = "gen-src-C++";
	public static final String cPackageSuffix = "/gen/";
	
	protected IFolder cGenFolder = null;
	protected IFolder getCGenFolder(IProject project) {
		if (cGenFolder == null) {
			cGenFolder = project.getFolder(C_GEN_FOLDER_NAME);
		}
		return cGenFolder;
	}
	
	public ModelLauncherC(IProgressMonitor monitor, IFile inputFile, Resource metaModelResource, 
			IModelCreatingContext lastModelCreatingContext, String targetSimLib, JavaClassLauncher javaClassLauncher,
			ProgramOutputPrinter programOutputPrinter){
		super(monitor, inputFile, metaModelResource, lastModelCreatingContext, targetSimLib,
				javaClassLauncher, programOutputPrinter);
	}
	private Map<Model, Model> processedModels = new HashMap<Model, Model>();
	
	private Model translate(Model inputModel, boolean rootModel, BaseCPlusPlusGenerator baseGenerator, IPath genFolder) {
			return translateDbl(inputModel, rootModel, baseGenerator, genFolder);
	}
	
	private Model translateDbl(Model inputModel, boolean rootModel, BaseCPlusPlusGenerator baseGenerator, IPath genFolder) {
		if (!processedModels.containsKey(inputModel)) {
			// 2.a. forward translation to imported models, so that extensions used in imported models are translated
			// 2.b. replaced imported models by translated imported models
			for (Import imprt: inputModel.getImports()) {
				Model importedModel = imprt.getModel();
				if (importedModel != null) {
					translate(importedModel, false, baseGenerator, genFolder);
				}
			}
			
			// 3. generate target language code with baseGenerator for outputModel
			baseGenerator.genModel(inputModel, rootModel);
			processedModels.put(inputModel, inputModel);
			return inputModel;
		}
		return processedModels.get(inputModel);
	}
	
	private boolean compileCppFiles(IProject project, IFolder folder) {		    
		 	try 
	        {
	            logger.info("Refreshing \"" + folder.toString() + "\" ...");
	            boolean isCompiled = false;
	            List<String> command = new ArrayList<String>();
	          
	            if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0){
	            	//Windows
	            	command = java.util.Arrays.asList("CMD", "/C", "mingw32-make");
	            }
	            else{
	            	//Mac
	            	command = java.util.Arrays.asList("make");
	            }
	            ProcessBuilder pb = new ProcessBuilder(command);
	            if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0){
	            	//Windows
	            	Map<String, String> envs = pb.environment();
	            	envs.put("Path", "C:\\MinGW\\bin\\");
	            }
	            File file = new File(folder.getRawLocation().makeAbsolute().toFile()+cPackageSuffix); 
	            pb.directory(file);
	            
	            Process shell = pb.start();
				try {
					shell.waitFor();
				} catch (InterruptedException e) {
					return false;
				}
				String line;
		        // read output from shell
				 BufferedReader inContent = new BufferedReader(new InputStreamReader(shell.getInputStream()));
		           
		         while((line = inContent.readLine()) != null) {
		        	 System.out.println(line);
		         }
		         inContent.close();
		         
		         BufferedReader inError = new BufferedReader(new InputStreamReader(shell.getErrorStream()));
		         if (inError.readLine() == null) isCompiled = true;
		         while((line = inError.readLine()) != null) {
			        System.out.println(line);
			     }
			        inError.close();
		         
			     if(isCompiled) logger.info("Finished compiling.");
			     else logger.info("Errors when compiling");
		         
		         return true;
	        }
	       catch (IOException e) {
	    	   logger.info("Errors when compiling");
	    	   return false;
	       }
	}
	
	private void startProgram(IProject project, IFolder folder) {	
		 try 
	        {
	            logger.info("Refreshing \"" + folder.toString() + "\" ...");
	            
	            ProcessBuilder pb = null;
	            if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
	            	 //Windows
	            	pb = new ProcessBuilder("CMD", "/C", "start", "my_program.exe");
	            }
	            else {
	            	//Mac
	            	pb = new ProcessBuilder("./my_program");
	            }
	            File file = new File(folder.getRawLocation().makeAbsolute().toFile()+cPackageSuffix); 
	            pb.directory(file);
	            pb.redirectErrorStream(true);
	           
	            Process shell = pb.start();
				
				// read output from shell
				String line;
				BufferedReader inContent = new BufferedReader(new InputStreamReader(shell.getInputStream()));
				
		        while((line = inContent.readLine()) != null) 
		        	System.out.println(line);
		        inContent.close();
		        
		        try {
					shell.waitFor();
				} catch (InterruptedException e) {
				}
		        
		        logger.info("Finished execution.");
	        }
	       catch (IOException e) {
	    	   logger.info("Error when executing program!!!");
	       }
		 
	}
	
	@Override
	public void compileAndRun(Resource modelResource){
		long startCompileTime = System.nanoTime();
		progressMonitor.beginTask("Compile && Run ...", 100);
		progressMonitor.subTask("Refreshing folders");
		// ueber Editor-> Datei.dbl -> zugehöriges Projekt 
		// Projekt aktualisieren (Aenderungen automatisch erkannt, Erkennungstiefe wurde auf infinite gestellt)
		refreshCurrentProject();
		
		IProject currentProject = getCurrentProject();
		IPath genPath = getCGenFolder(currentProject).getRawLocation();

		progressMonitor.subTask("Cleaning folders");
		// Ordner werden rekursiv bereinigt 
		cleanFolder(getTempFolder(currentProject));
		cleanFolder(getCGenFolder(currentProject));
		
		programOutputPrinter.clear();

		progressMonitor.worked(10); // 10%
		
		progressMonitor.subTask("Translating model to target language program");
		
		Resource originalResource = modelResource;
		Model rootModel = (Model) originalResource.getContents().get(0);
		BaseCPlusPlusGenerator baseGenerator = new SpecificSimulationCPlusPlusGenerator(genPath);
		
		// aktuell geoeffnetes File
		final boolean isDbxInputFile = modelFile.getFileExtension().equals("dbx");

		logger.info("Compiling and executing model " + modelFile + " ...");

		translate(rootModel, true, baseGenerator, genPath, isDbxInputFile);
		progressMonitor.worked(50); // 55%
		progressMonitor.subTask("Compiling target language program");

		boolean isCompiled = false;
		isCompiled = compileCppFiles(currentProject, getCGenFolder(currentProject));

		long estimatedTime = System.nanoTime() - startCompileTime;
		long ms = estimatedTime / (1000 * 1000);
		logger.info("Overall compile time: " + ms / 1000.0 + " seconds");

		progressMonitor.worked(40); // 95%
		if(isCompiled){
			progressMonitor.subTask("Executing target language program");
			startProgram(currentProject, getJavaGenFolder(currentProject));
			progressMonitor.worked(5);
		}
	}
}

package hub.sam.dmx.launcher;

import hub.sam.dbl.Import;
import hub.sam.dbl.Model;
import hub.sam.dmx.editor.DblTextEditor;
import hub.sam.dmx.targetcode.BasicDblToCGenerator;
import hub.sam.dmx.targetcode.ExtendedDblToCGenerator;

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
import org.eclipse.ui.part.FileEditorInput;

import java.io.*;

public class ModelLauncherC<BasicDBLToCGenerator, DblToLabelsAsValuesCGenerator> extends ModelLauncher{
	
	public static final String C_GEN_FOLDER_NAME = "gen-src2";
	public static final String TEMP2_FOLDER_NAME = "temp2";
	public static final String cPackageSuffix = "/hub/sam/dmx/csim/gen/";
	
	public ModelLauncherC (IProgressMonitor monitor, Display associatedDisplay, DblTextEditor editor, String targetSimLib, String targetLanguage){
		super(monitor, associatedDisplay, editor, targetSimLib, targetLanguage);
	}
	
	private IFolder cGenFolder = null;

	private IFolder getCGenFolder(IProject project) {
		if (cGenFolder == null) {
			cGenFolder = project.getFolder(C_GEN_FOLDER_NAME);
		}
		return cGenFolder;
	}
	
	private IFolder tempFolder = null;
	
	private IFolder getTempFolder(IProject project) {
		if (tempFolder == null) {
			tempFolder = project.getFolder(TEMP2_FOLDER_NAME);
		}
		return tempFolder;
	}
	
	private Map<Model, Model> processedModels = new HashMap<Model, Model>();
	
	private Model translate(Model inputModel, boolean rootModel, BasicDblToCGenerator baseGenerator, IPath genFolder) {
			return translateDbl(inputModel, rootModel, baseGenerator, genFolder);
	}
	
	private Model translateDbl(Model inputModel, boolean rootModel, BasicDblToCGenerator baseGenerator, IPath genFolder) {
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
	
	private boolean compileCppFiles(IProject project, IFolder folder, List<String> cppNames) {		    
		    try 
	        {
	            logger.info("Refreshing \"" + folder.toString() + "\" ...");
	            boolean isCompiled = false;
	            List<String> command = new ArrayList<String>();
	            List<String> prefix;
	          
	            if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0){
	            	//Windows
	            	prefix = java.util.Arrays.asList("CMD", "/C", "g++", "-O3", "-std=c++11","-o", "my_program", "Main.cpp");
	            }
	            else{
	            	//Mac
	            	prefix = java.util.Arrays.asList("g++","-O3", "-std=c++11","-Wno-parentheses-equality", "-o", "my_program", "Main.cpp");
	            }
		        command.addAll(prefix);
	            command.addAll(cppNames);
	            ProcessBuilder pb = new ProcessBuilder(command);
	            if (System.getProperty("os.name").indexOf("win") >= 0){
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
	public void compileAndRun(){
		long startCompileTime = System.nanoTime();
		monitor.beginTask("Compile && Run ...", 100);
		monitor.subTask("Refreshing folders");
		// ueber Editor-> Datei.dbl -> zugehöriges Projekt 
		// Projekt aktualisieren (Aenderungen automatisch erkannt, Erkennungstiefe wurde auf infinite gestellt)
		refreshCurrentProject();
		
		IProject currentProject = getCurrentProject();

		monitor.subTask("Cleaning folders");
		// Ordner werden rekursiv bereinigt 
		cleanFolder(getTempFolder(currentProject));
		cleanFolder(getCGenFolder(currentProject));
		
		resetConsole();

		monitor.worked(10); // 10%

		// aktuell geoeffnetes File
		final IFile inputFile = ((FileEditorInput) editor.getEditorInput()).getFile();
		final boolean isDbxInputFile = inputFile.getFileExtension().equals("dbx");
		// aktuell nur Unterstuetzung fuer .dbl Dateien
		monitor.subTask("Translating model to target language program");
		if(isDbxInputFile) {
			logger.info("" + inputFile + " could not be compiled.");
		}
		else{
			// genPath speichert den absoluten Pfad des gen-src folders
			IPath genPath = getCGenFolder(currentProject).getRawLocation();
			ExtendedDblToCGenerator baseGenerator = new ExtendedDblToCGenerator(genPath);
			Resource originalResource = editor.getCurrentModel();
			Model rootModel = (Model) originalResource.getContents().get(0);

			logger.info("Compiling and executing model " + inputFile + " ...");
			translateDbl(rootModel, true, baseGenerator, genPath);
			refreshCurrentProject();
			
			monitor.worked(50); // 55%
			monitor.subTask("Compiling target language program");
			
			compileCppFiles(currentProject, getCGenFolder(currentProject), baseGenerator.allCppFiles);

			long estimatedTime = System.nanoTime() - startCompileTime;
			long ms = estimatedTime / (1000 * 1000);
			logger.info("Overall compile time: " + ms / 1000.0 + " seconds");
			
			monitor.worked(40); // 95%
			monitor.subTask("Executing target language program");
			startProgram(currentProject, getCGenFolder(currentProject));
			monitor.worked(5);
		}
	}
}

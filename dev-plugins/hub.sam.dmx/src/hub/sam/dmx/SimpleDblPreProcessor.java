package hub.sam.dmx;

import hub.sam.dbl.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class SimpleDblPreProcessor implements IPreProcessor {
	
	protected static ResourceSet resourceSet = new ResourceSetImpl();
	protected Map<String, IModelContainer> allImports = new HashMap<String, IModelContainer>();
	
	private final static Logger logger = Logger.getLogger(SimpleDblPreProcessor.class.getName());
	
	public static URI getPlatformResourceURI(IPath fileLocation) {
	    IFile projectFile = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(fileLocation.toFile().toURI())[0];
	    return URI.createPlatformResourceURI(projectFile.getFullPath().toString(), true);
	}
	
	protected void importedModelChanged(Model model) {
		// empty
	}
	
	public void preProcess(String inputText, IPath inputPath) {
		if (inputText != null) {
			Pattern importRegex = Pattern.compile("^#import \"(.+)\"", Pattern.MULTILINE);
			Matcher matcher = importRegex.matcher(inputText);
			
			while (matcher.find()) {
				final String fileToImport = matcher.group(1);
				importFile(fileToImport, true, inputPath);
			}
		}
	}
	
	protected void importFile(final String fileToImport, final boolean directImport, IPath inputPath) {			
		try {
    		final Resource resource = loadXmi(fileToImport, inputPath);
    		if (resource != null) {
	    		allImports.put(fileToImport, new IModelContainer() {
					@Override
					public Model getModel() {
						return (Model) resource.getContents().get(0);
					}

					@Override
					public Resource getResource() {
						return resource;
					}
				});		
	    		logger.info("loaded import '" + fileToImport + "'.");
    		}
		}
	    catch (RuntimeException e) {
	    	logger.severe(e.getMessage());
	    }
	}
	
	protected Resource loadXmi(String fileToImport, IPath inputPath) {
		IPath xmiToImport = inputPath.append(fileToImport).addFileExtension("xmi");
		if (xmiToImport.toFile().exists()) {
			try {
				Resource resource = resourceSet.getResource(getPlatformResourceURI(xmiToImport), true);
				EcoreUtil.resolveAll(resource);
				return resource;
			}
			catch (RuntimeException e) {
				logger.severe("cannot load XMI file " + xmiToImport + ": " + e.getMessage());
				return null;
			}
		}
		else {
			logger.severe("XMI file is missing: " + xmiToImport);
			return null;
		}
	}
	
	public synchronized IModelContainer getImportedModel(String fileOfImport) {
		return allImports.get(fileOfImport);
	}
	
	public void loseImport(String fileOfImport) {
		allImports.remove(fileOfImport);
	}
	
	public void loseImports() {
		for (IModelContainer imprt: allImports.values()) {
			imprt.getResource().unload();
		}
		allImports.clear();
	}
	
	public synchronized Collection<IModelContainer> getImportedModels() {
		return allImports.values();
	}
	
//	public Resource getFileImportResource(String fileToImport) {
//		if (fileImportsSelfLoaded.containsKey(fileToImport)) return fileImportsSelfLoaded.get(fileToImport);
//		else if (importsOpenedInActiveEditors.containsKey(fileToImport)) return importsOpenedInActiveEditors.get(fileToImport).getCurrentModel();
//		else return null;
//	}
//	
//	public void loseImportedResource(String importedFile) {
//		fileImportsSelfLoaded.remove(importedFile);
//		importsOpenedInActiveEditors.remove(importedFile);
//	}
//	
//	public synchronized Collection<Resource> getImportedResources() {
//		Set<Resource> importedResources = new HashSet<Resource>();
//		importedResources.addAll(fileImportsSelfLoaded.values());
//		for (DblTextEditor editor: importsOpenedInActiveEditors.values()) {
//			importedResources.add(editor.getCurrentModel());
//		}
//		return importedResources;
//	}
	
}

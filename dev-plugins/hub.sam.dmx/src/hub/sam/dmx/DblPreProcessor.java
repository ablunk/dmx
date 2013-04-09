package hub.sam.dmx;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class DblPreProcessor {

	private ResourceSet importedResourcesResourceSet = new ResourceSetImpl();
	private Map<String, Resource> fileForImportedResources = new HashMap<String, Resource>();
	
	public static URI getPlatformResourceURI(IPath fileLocation) {
	    IFile projectFile = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(fileLocation.toFile().toURI())[0];
	    return URI.createPlatformResourceURI(projectFile.getFullPath().toString(), true);
	}

	public void preProcess(String inputText, IPath inputLocation) {
		Pattern importRegex = Pattern.compile("^#import \"(.*)\"");
		Matcher matcher = importRegex.matcher(inputText);
		
		while (matcher.find()) {
			String fileToImport = matcher.group(1);
			System.out.println(fileToImport);
			
			IPath editorInputLocation = inputLocation.removeLastSegments(1);
			IPath file = editorInputLocation.append(fileToImport).addFileExtension("xmi");
		    
		    URI uri = getPlatformResourceURI(file);
		    if (!fileForImportedResources.containsKey(uri.toString())) {
				Resource resource = importedResourcesResourceSet.getResource(uri, true);
				EcoreUtil.resolveAll(resource);
				fileForImportedResources.put(uri.toString(), resource);
			}			
		}
	}
	
	public Map<String, Resource> getFileForImportedResources() {
		return fileForImportedResources;
	}

	public synchronized Collection<Resource> getImportedResources() {
		return importedResourcesResourceSet.getResources();
	}
	
}

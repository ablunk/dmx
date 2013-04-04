package hub.sam.dmx;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class DblPreProcessor {

	private ResourceSet importedResourcesResourceSet = new ResourceSetImpl();
	private Map<String, Resource> fileForImportedResources = new HashMap<String, Resource>();

	public void preProcess(String inputText, IPath inputLocation) {
		Pattern importRegex = Pattern.compile("^#import \"(.*)\"");
		Matcher matcher = importRegex.matcher(inputText);
		
		while (matcher.find()) {
			String fileToImport = matcher.group(1);
			System.out.println(fileToImport);
			
			//IPath editorInputLocation = ((FileEditorInput) getEditorInput()).getFile().getLocation().removeLastSegments(1);
			IPath editorInputLocation = inputLocation.removeLastSegments(1);
			IPath file = editorInputLocation.append(fileToImport).addFileExtension("xmi");
			
			if (!fileForImportedResources.containsKey(file.toString())) {
				URI fileURI = URI.createFileURI(file.toPortableString());
				Resource resource = importedResourcesResourceSet.getResource(fileURI, true);
				EcoreUtil.resolveAll(resource);
				fileForImportedResources.put(file.toString(), resource);
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

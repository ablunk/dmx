package hub.sam.dmx;

import hub.sam.tef.editor.text.ITefEditorStatusListener;
import hub.sam.tef.editor.text.TextEditor;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

public class DblPreProcessor {

	private ResourceSet resourceSet = new ResourceSetImpl();
	private Map<String, Resource> fileImportsSelfLoaded = new HashMap<String, Resource>();
	private Map<String, DblTextEditor> fileImportsInActiveEditors = new HashMap<String, DblTextEditor>();
	
	public static URI getPlatformResourceURI(IPath fileLocation) {
	    IFile projectFile = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(fileLocation.toFile().toURI())[0];
	    return URI.createPlatformResourceURI(projectFile.getFullPath().toString(), true);
	}

	public void preProcess(String inputText, IPath inputLocation) {
		Pattern importRegex = Pattern.compile("^#import \"(.+)\"");
		Matcher matcher = importRegex.matcher(inputText);
		
		while (matcher.find()) {
			final String fileToImport = matcher.group(1);
			
			IPath editorInputLocation = inputLocation.removeLastSegments(1);
			IPath file = editorInputLocation.append(fileToImport).addFileExtension("xmi");
		    
			try {
		    	if (!fileImportsInActiveEditors.containsKey(fileToImport)) {
			    	// check if import is currently opened in another editor window

		    		// TODO needs to be called from a UI thread
		    		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
		    			public void run() {
					    	IEditorReference[] editorRefs = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
					    	
					    	for (IEditorReference editorRef: editorRefs) {
					    		IEditorPart editorPart = editorRef.getEditor(false);
					    		if (editorPart instanceof DblTextEditor) {
									DblTextEditor dblTextEditor = (DblTextEditor) editorPart;
									IPath otherEditorInputLocation = ((FileEditorInput) dblTextEditor.getEditorInput()).getFile().getLocation();
									String otherEditorFileName = otherEditorInputLocation.removeFileExtension().lastSegment().toString();
									if (otherEditorFileName.equals(fileToImport)) {
										fileImportsInActiveEditors.put(otherEditorFileName, dblTextEditor);

										fileImportsSelfLoaded.remove(otherEditorFileName);
										System.out.println("linked import '" + fileToImport + "' to opened editor.");
										
										dblTextEditor.addEditorStatusListener(new ITefEditorStatusListener() {	
											@Override
											public void rccSyntaxChanged(TextEditor editor) {
												// empty
											}
											
											@Override
											public void errorStatusChanged(TextEditor editor) {
												System.out.println("editor changed: " + editor.getEditorInput().getName());
												// TODO reconcile current editor
											}
										});
									}
								}
					    	}
		    			}
		    		});
		    	}
		    	
			    if (!fileImportsInActiveEditors.containsKey(fileToImport)) {
		    		Resource resource = resourceSet.getResource(getPlatformResourceURI(file), true);
		    		EcoreUtil.resolveAll(resource);
		    		fileImportsSelfLoaded.put(fileToImport, resource);		
					System.out.println("loaded import '" + fileToImport + "'.");
				}
			}
		    catch (RuntimeException e) {
		    	System.out.println(e.getMessage());
		    }
		}
	}
	
	public Resource getFileImportResource(String fileToImport) {
		if (fileImportsSelfLoaded.containsKey(fileToImport)) return fileImportsSelfLoaded.get(fileToImport);
		else if (fileImportsInActiveEditors.containsKey(fileToImport)) return fileImportsInActiveEditors.get(fileToImport).getCurrentModel();
		else return null;
	}
	
	public void loseImportedResource(String importedFile) {
		fileImportsSelfLoaded.remove(importedFile);
		fileImportsInActiveEditors.remove(importedFile);
	}

	public synchronized Collection<Resource> getImportedResources() {
		Set<Resource> importedResources = new HashSet<Resource>();
		importedResources.addAll(fileImportsSelfLoaded.values());
		for (DblTextEditor editor: fileImportsInActiveEditors.values()) {
			importedResources.add(editor.getCurrentModel());
		}
		return importedResources;
	}
	
}

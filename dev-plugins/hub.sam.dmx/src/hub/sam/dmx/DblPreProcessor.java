package hub.sam.dmx;

import hub.sam.dbl.Import;
import hub.sam.dbl.Model;
import hub.sam.tef.editor.text.ITefEditorStatusListener;
import hub.sam.tef.editor.text.TextEditor;

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
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

public class DblPreProcessor {
	
	private final DblTextEditor editor;
	private ResourceSet resourceSet = new ResourceSetImpl();
	private Map<String, Resource> fileImportsSelfLoaded = new HashMap<String, Resource>();
	private Map<String, DblTextEditor> fileImportsInActiveEditors = new HashMap<String, DblTextEditor>();
	
	/**
	 * 
	 * @param editor if non-null, pre-processors updates imports. otherwise, null may be passed as a legal value.
	 */
	public DblPreProcessor(DblTextEditor editor) {
		this.editor = editor;
	}
	
	public static URI getPlatformResourceURI(IPath fileLocation) {
	    IFile projectFile = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(fileLocation.toFile().toURI())[0];
	    return URI.createPlatformResourceURI(projectFile.getFullPath().toString(), true);
	}
	
	private class BackgroundEditorListener implements ITefEditorStatusListener {
		
		@Override
		public void rccSyntaxChanged(TextEditor editor) {
			// empty
		}
		
		@Override
		public void errorStatusChanged(TextEditor editor) {
			// empty
		}

		@Override
		public void modelChanged(TextEditor changedEditor) {
			
			if (changedEditor != editor) {
				System.out.println("editor '" + editor.getEditorInput().getName()
					+ "' is notified of change in imported model '" + changedEditor.getEditorInput().getName() + "'");
	
				if (editor.getCurrentModel() != null) {
					// update imports
					Model model = (Model) editor.getCurrentModel().getContents().get(0);
					for (Import imprt: model.getImports()) {
						if (imprt.getFile().concat(".dbl").equals(changedEditor.getEditorInput().getName())) {
							imprt.setModel((Model) editor.getCurrentModel().getContents().get(0));

							// initiate reconcile
							editor.fireReferencedModelChanged();
							break;
						}
					}
					
				}
			}
		}

		@Override
		public void referencedModelChanged(TextEditor editor) {
			//empty
		}
		
	}
	
	private BackgroundEditorListener backgroundEditorListener = null;
	
	private BackgroundEditorListener getBackgroundEditorListener() {
		if (backgroundEditorListener == null) {
			return new BackgroundEditorListener();
		}
		return backgroundEditorListener;
	}
	
	private IPartListener2 otherEditorRefPartListener = new IPartListener2() {
		
		@Override
		public void partOpened(IWorkbenchPartReference partRef) {			
			if (!partRef.getPartName().equals(editor.getPartName())) {
				System.out.println("editor '"+ editor.getPartName() + "' is notified that " + "editor '" + partRef.getPartName() + "' is opened");
				IWorkbenchPart part = partRef.getPart(false);
				if (part instanceof DblTextEditor) {
					DblTextEditor changedEditor = (DblTextEditor) part;
					if (changedEditor.getCurrentModel() != null
							&& editor.getFileImportResource(changedEditor.getCurrentModel().getURI().trimFileExtension().lastSegment()) != null) {
						editor.fireReferencedModelChanged();
					}
				}
			}			
		}
		
		@Override
		public void partClosed(IWorkbenchPartReference partRef) {
			if (!partRef.getPartName().equals(editor.getPartName())) {
				System.out.println("editor '"+ editor.getPartName() + "' is notified that " + "editor '" + partRef.getPartName() + "' is closed");
			}			
		}
		
		@Override
		public void partVisible(IWorkbenchPartReference partRef) {}

		@Override
		public void partInputChanged(IWorkbenchPartReference partRef) {}
		
		@Override
		public void partHidden(IWorkbenchPartReference partRef) {}
		
		@Override
		public void partDeactivated(IWorkbenchPartReference partRef) {}
		
		@Override
		public void partBroughtToTop(IWorkbenchPartReference partRef) {}
		
		@Override
		public void partActivated(IWorkbenchPartReference partRef) {}
	};
	
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

		    		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
		    			public void run() {
					    	IEditorReference[] editorRefs = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
					    	
					    	for (IEditorReference otherEditorRef: editorRefs) {					    		
								if (editor != null) {
									otherEditorRef.getPage().addPartListener(otherEditorRefPartListener);
								}
					    		
					    		IEditorPart otherEditorPart = otherEditorRef.getEditor(false);
					    		if (otherEditorPart instanceof DblTextEditor) {
									DblTextEditor otherEditor = (DblTextEditor) otherEditorPart;
									
									if (!editor.getPartName().equals(otherEditor.getPartName())) {
										
										IPath otherEditorInputLocation = ((FileEditorInput) otherEditor.getEditorInput()).getFile().getLocation();
										String otherEditorFileName = otherEditorInputLocation.removeFileExtension().lastSegment().toString();
	
										if (otherEditorFileName.equals(fileToImport)) {
											if (editor != null) {
												otherEditor.getSite().getPage().removePartListener(otherEditorRefPartListener);
												
												otherEditor.addEditorStatusListener(getBackgroundEditorListener());
												System.out.println("editor '" + editor.getEditorInput().getName() + "' listens to other editor '"
														+ otherEditor.getEditorInput().getName() + "'");
											}

											fileImportsInActiveEditors.put(otherEditorFileName, otherEditor);
	
											fileImportsSelfLoaded.remove(otherEditorFileName);
											System.out.println("linked import '" + fileToImport + "' to opened editor.");
										}
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

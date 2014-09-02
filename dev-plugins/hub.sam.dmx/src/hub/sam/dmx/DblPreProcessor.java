package hub.sam.dmx;

import hub.sam.dbl.Import;
import hub.sam.dbl.Model;
import hub.sam.tef.editor.text.ITefEditorStatusListener;
import hub.sam.tef.editor.text.TextEditor;

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
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

public class DblPreProcessor {
	
	private final DblTextEditor editor;
	private final String filename; // the file that is pre-processed by this pre-processor
	private static ResourceSet resourceSet = new ResourceSetImpl();
	private Map<String, IModelContainer> allImports = new HashMap<String, IModelContainer>();
	private Map<String, DblTextEditor> importsOpenedInActiveEditors = new HashMap<String, DblTextEditor>();
	
	private final static Logger logger = Logger.getLogger(DblPreProcessor.class.getName());
	
	/**
	 * 
	 * @param editor if non-null, pre-processors updates imports. otherwise, null may be passed as a legal value.
	 */
	public DblPreProcessor(String filename, DblTextEditor editor) {
		this.filename = filename;
		this.editor = editor;
	}
	
	public static URI getPlatformResourceURI(IPath fileLocation) {
	    IFile projectFile = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(fileLocation.toFile().toURI())[0];
	    return URI.createPlatformResourceURI(projectFile.getFullPath().toString(), true);
	}
	
	protected class ImportsEditorListener implements ITefEditorStatusListener {
		
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
				logger.info("editor '" + editor.getEditorInput().getName()
					+ "' is notified of change in imported model '" + changedEditor.getEditorInput().getName() + "'");
	
				if (editor.getCurrentModel() != null) {
					// update imports
					Model model = (Model) editor.getCurrentModel().getContents().get(0);
					for (Import imprt: model.getImports()) {
						String fileName = imprt.getFile();
						if (fileName.concat(".dbl").equals(changedEditor.getEditorInput().getName())
								|| fileName.concat(".dbx").equals(changedEditor.getEditorInput().getName()))
						{
							Model changedModel = (Model) changedEditor.getCurrentModel().getContents().get(0);
							//imprt.setModel((Model) editor.getCurrentModel().getContents().get(0));
							imprt.setModel(changedModel);
							importedModelChanged(changedModel);
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
	
	protected void importedModelChanged(Model model) {
		// initiate reconcile
		editor.fireReferencedModelChanged();
	}
	
	protected ITefEditorStatusListener importsEditorListener = null;
	
	protected ITefEditorStatusListener getImportsEditorListener() {
		if (importsEditorListener == null) {
			importsEditorListener = new ImportsEditorListener();
		}
		return importsEditorListener;
	}
	
	private IPartListener2 otherEditorRefPartListener = new IPartListener2() {
		
		@Override
		public void partOpened(IWorkbenchPartReference partRef) {			
			if (!partRef.getPartName().equals(editor.getPartName())) {
				logger.info("editor '"+ editor.getPartName() + "' is notified that " + "editor '" + partRef.getPartName() + "' is opened");
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
				logger.info("editor '"+ editor.getPartName() + "' is notified that " + "editor '" + partRef.getPartName() + "' is closed");
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
	
	public void preProcess(String inputText, IPath inputPath) {
		if (inputText != null) {
			Pattern importRegex = Pattern.compile("#import \"(.+)\"");
			Matcher matcher = importRegex.matcher(inputText);
			
			while (matcher.find()) {
				final String fileToImport = matcher.group(1);
				importFile(fileToImport, true, inputPath);
			}
		}
	}
	
	protected DblTextEditor getOpenedEditorForImport(final String fileToImport, final boolean directImport) {
		final String fileToImportDbl = fileToImport.concat(".dbl");
		final String fileToImportDbx = fileToImport.concat(".dbx");
		RunnableWithReturn<DblTextEditor> runnable = new RunnableWithReturn<DblTextEditor>() {
			public void run() {
		    	IEditorReference[] editorRefs = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
		    	
		    	// check if import is currently opened in another editor window
		    	for (IEditorReference otherEditorRef: editorRefs) {					    		

		    		IEditorPart otherEditorPart = otherEditorRef.getEditor(false);
					if (otherEditorPart == null && editor != null && directImport) {
						try {
							String otherEditorName = otherEditorRef.getEditorInput().getName();
							if (otherEditorName.equals(fileToImportDbl) || otherEditorName.equals(fileToImportDbx)) {
								otherEditorRef.getPage().addPartListener(otherEditorRefPartListener);
							}
						}
						catch (PartInitException e) {
							throw new RuntimeException(e);
						}
					}
					else if (otherEditorPart instanceof DblTextEditor) {
						final DblTextEditor otherEditor = (DblTextEditor) otherEditorPart;
						
						if (editor != null && !editor.getPartName().equals(otherEditor.getPartName())) {
							
							IPath otherEditorInputLocation = ((FileEditorInput) otherEditor.getEditorInput()).getFile().getLocation();
							String otherEditorFileName = otherEditorInputLocation.removeFileExtension().lastSegment().toString();

							if (otherEditorFileName.equals(fileToImport)) {
								if (editor != null && directImport) {
									otherEditor.getSite().getPage().removePartListener(otherEditorRefPartListener);
									
									otherEditor.addEditorStatusListener(getImportsEditorListener());
									logger.info("editor '" + editor.getEditorInput().getName() + "' listens to other editor '"
											+ otherEditor.getEditorInput().getName() + "'");
								}
								setResult(otherEditor);
							}
						}
						else if (editor == null && filename.equals(otherEditor.getPartName())) {
							setResult(otherEditor);
						}
						
		    		}
		    	}
			}
		};
		PlatformUI.getWorkbench().getDisplay().syncExec(runnable);
		return runnable.getResult();
	}
	
	/**
	 * Loads the model of the specified fileToImport. Listens to changes in the model if directImport is set to true.
	 * Note: Changes of indirect imports are propagated from outside to inside.
	 * 
	 * @param fileToImport
	 * @param directImport
	 * @param inputPath
	 */
	protected void importFile(final String fileToImport, final boolean directImport, IPath inputPath) {			
		try {
	    	if (!importsOpenedInActiveEditors.containsKey(fileToImport)) {
	    		final DblTextEditor openedEditor = getOpenedEditorForImport(fileToImport, directImport);
	    		if (openedEditor != null) {
					IPath openedEditorInputLocation = ((FileEditorInput) openedEditor.getEditorInput()).getFile().getLocation();
					String openedEditorFileName = openedEditorInputLocation.removeFileExtension().lastSegment().toString();

					importsOpenedInActiveEditors.put(openedEditorFileName, openedEditor);
					logger.info("linked import '" + fileToImport + "' to opened editor.");

					allImports.put(openedEditorFileName, new IModelContainer() {
						@Override
						public Model getModel() {
							return (Model) openedEditor.getCurrentModel().getContents().get(0);
						}

						@Override
						public Resource getResource() {
							return openedEditor.getCurrentModel();
						}
					});
	    		}
	    	}
	    	
		    if (!importsOpenedInActiveEditors.containsKey(fileToImport)) {
	    		final Resource resource = loadXmi(fileToImport, inputPath);
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
		Resource resource = resourceSet.getResource(getPlatformResourceURI(xmiToImport), true);
		EcoreUtil.resolveAll(resource);
		return resource;
	}
	
	public synchronized IModelContainer getImportedModel(String fileOfImport) {
		return allImports.get(fileOfImport);
	}
	
	public void loseImport(String fileOfImport) {
		allImports.remove(fileOfImport);
		importsOpenedInActiveEditors.remove(fileOfImport);
	}
	
	public void loseImports() {
		allImports.keySet().removeAll(importsOpenedInActiveEditors.keySet());
		for (IModelContainer imprt: allImports.values()) {
			imprt.getResource().unload();
		}
		allImports.clear();
		importsOpenedInActiveEditors.clear();
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

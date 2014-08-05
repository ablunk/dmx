package hub.sam.dmx;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Model;
import hub.sam.dbl.provider.DblItemProviderAdapterFactory;
import hub.sam.tef.editor.SourceViewerConfiguration;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.semantics.ISemanticsProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.osgi.framework.Bundle;

public class DblTextEditor extends hub.sam.tef.editor.text.TextEditor {
	
	private SaveXmiAction saveXmiAction;
	private List<Action> runActions = new ArrayList<Action>();
	
	protected DblPreProcessor _preProcessor;
	
	protected DblPreProcessor getPreProcessor() {
		return _preProcessor;
	}
	
	protected void initPreProcessor() {
		if (_preProcessor == null) {
			_preProcessor = new DblPreProcessor(getEditorInput().getName(), this);
		}
	}
	
	@Override
	protected SourceViewerConfiguration createSourceViewerConfiguration() {
		return new DblSourceViewerConfiguration(this);
	}

	@Override
	public IModelCreatingContext createModelCreatingContext() {
		//resourceSet.getPackageRegistry().put(DblPackage.eNS_URI, DblPackage.eINSTANCE);

		return new DblModelCreationContext(getMetaModelPackages(), getSemanticsProvider(),
				new ResourceImpl(), resourceSet, getCurrentText());
	}
	
	@Override
	protected String getResourceFile() {
		IEditorInput editorInput = getEditorInput();
		if (editorInput instanceof IFileEditorInput) {
			// file input internal to the workspace
			IFileEditorInput fileInput = (IFileEditorInput)editorInput;
			return fileInput.getFile().getFullPath().removeFileExtension().addFileExtension("xmi").toString();
		}
		else if (editorInput instanceof FileStoreEditorInput) {
			// file input external to the workspace
			FileStoreEditorInput fileInput = (FileStoreEditorInput) editorInput;
			return fileInput.getURI().getPath(); // TODO should be same as above
		}
		return null;

	}
	
	@Override
	public void preProcessDocument() {
		initPreProcessor();
		super.preProcessDocument();
		IPath inputFile = ((FileEditorInput) getEditorInput()).getFile().getLocation();
		getPreProcessor().preProcess(getCurrentText(), inputFile.removeLastSegments(1));		
	}
	
	public synchronized Collection<IModelContainer> getImportedModels() {
		return getPreProcessor().getImportedModels();
	}
	
	public synchronized Resource getFileImportResource(String fileToImport) {
		IModelContainer model = getPreProcessor().getImportedModel(fileToImport);
		if (model != null) return model.getResource();
		else return null;
	}
	
	private DblPackage dblMetaModel;
	
	public DblPackage getDblMetaModel() {
		if (dblMetaModel == null) {
			for (EPackage pkg: getMetaModelPackages()) {
				if (pkg instanceof DblPackage) {
					dblMetaModel = (DblPackage) pkg;
					break;
				}
			}			
		}
		return dblMetaModel;
	}

	@Override
	public EPackage[] createMetaModelPackages() {
		return new EPackage[] { DblPackage.eINSTANCE };
	}

	@Override
	protected Bundle getPluginBundle() {
		return Activator.getDefault().getBundle();
	}

	@Override
	protected String getSyntaxPath() {
		return "/resources/dbl.etslt";
	}
	
	@Override
	protected ISemanticsProvider createSemanticsProvider() {
		return new DblSemanticsProvider(new IPreProcessedDocument() {
			
			@Override
			public IPath getPath() {
				return ((FileEditorInput) getEditorInput()).getFile().getLocation().removeLastSegments(1);
			}

			@Override
			public Collection<IModelContainer> getImportsModels() {
				return getPreProcessor().getImportedModels();
			}

			@Override
			public Model getModel() {
				Resource resource = DblTextEditor.this.getCurrentModel();
				if (resource != null) {
					return (Model) resource.getContents().get(0);
				}
				return null;
			}
		});
	}

	@Override
	public AdapterFactory[] createItemProviderAdapterFactories() {
		return new AdapterFactory[] { new DblItemProviderAdapterFactory() };
	}
	
	private static final String RUN_MENU_ID = "hub.sam.dmx.menu.run";

	@Override
	protected void editorContextMenuAboutToShow(IMenuManager menu) {
		MenuManager runMenu = new MenuManager("Compile && Run", RUN_MENU_ID);
		menu.add(runMenu);
		for (Action runAction: runActions) {
			runMenu.add(runAction);
		}
		menu.add(saveXmiAction);
		super.editorContextMenuAboutToShow(menu);
	}
	
	@Override
	protected void createActions() {
		super.createActions();

		saveXmiAction = new SaveXmiAction(this);
		setAction(SaveXmiAction.ACTION_DEFINITION_ID, saveXmiAction);
		
		addRunAction("DESMO-J", "desmoj", "java");		
//		addRunAction("JiST-Pro (using Acceleo)", "jist");
//		addRunAction("jDisco (using Acceleo)", "jdisco");
	}
	
	private void addRunAction(String name, String targetSimLib, String targetLanguage) {
		XtendRunAction runAction = new XtendRunAction(this);
		runAction.setTargetSimLib(targetSimLib);
		runAction.setTargetLanguage(targetLanguage);
		runAction.setText(name);
		setAction("hub.sam.dmx.action.run." + targetSimLib, runAction);
		runActions.add(runAction);
	}

	@Override
	protected void addActions(Collection<String> actionIds) {
		super.addActions(actionIds);
		//actionIds.add(DropXmiAction.ACTION_DEFINITION_ID);
	}

	@Override
	public void dispose() {
		if (saveXmiAction != null) {
			saveXmiAction.dispose();
		}
		if (editorPartListener != null) {
			getEditorSite().getPage().removePartListener(editorPartListener);
		}
		getPreProcessor().loseImports();
		super.dispose();
	}
	
	protected IPartListener2 editorPartListener;
	
	@Override
	public void fireEditorStatus() {
		super.fireEditorStatus();
		installEditorPartListener();
	}
	
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		saveAsXmi();
		super.doSave(progressMonitor);
	}
	
	protected void saveAsXmi() {
		SaveXmiAction.run(DblTextEditor.this);
	}

	protected void installEditorPartListener() {
		if (editorPartListener == null) {
			editorPartListener = new IPartListener2() {
				
				@Override
				public void partVisible(IWorkbenchPartReference partRef) {
				}
				
				@Override
				public void partOpened(IWorkbenchPartReference partRef) {
				}
				
				@Override
				public void partInputChanged(IWorkbenchPartReference partRef) {
				}
				
				@Override
				public void partHidden(IWorkbenchPartReference partRef) {
				}
				
				@Override
				public void partDeactivated(IWorkbenchPartReference partRef) {
					if (partRef.getPart(false) == getEditorSite().getPart()) {
						if (isDirty()) {
							saveAsXmi();
						}
					}
				}
				
				@Override
				public void partClosed(IWorkbenchPartReference partRef) {
				}
				
				@Override
				public void partBroughtToTop(IWorkbenchPartReference partRef) {
				}
				
				@Override
				public void partActivated(IWorkbenchPartReference partRef) {
				}
			};
			
			getEditorSite().getPage().addPartListener(editorPartListener);
		}
	}
	
}
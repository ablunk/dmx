package hub.sam.dmx;

import hub.sam.dbl.Model;
import hub.sam.tef.TEFPlugin;
import hub.sam.tef.Utilities;
import hub.sam.tef.editor.SourceViewerConfiguration;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;

import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

public class DbxTextEditor extends DblTextEditor implements IExtensionDefinitionApplier {

	@Override
	protected String getMetaModelPath() {
		return "/resources/dbl.ecore";
	}
	
	@Override
	protected void initPreProcessor() {
		if (_preProcessor == null) {
			_preProcessor = new DbxPreProcessor(this, getEditorInput().getName(), this);
		}
	}
	
	private ExtensionDefinitionManager _extensionDefinitionManager;
	
	private ExtensionDefinitionManager getExtensionDefinitionManager() {
		if (_extensionDefinitionManager == null) {
			_extensionDefinitionManager = new ExtensionDefinitionManager(getSyntax(), getDblMetaModel());
		}
		return _extensionDefinitionManager;
	}

	@Override
	public void preProcessDocument() {
		super.preProcessDocument();

		// extension definitions have to be added for each import beginning at the leaves of the import tree.
		// what is needed, is a pre-processed model of the full import tree. this pre-model is used for adding extension definitions
		// from outside to inside (i.e. beginning at the leaves of the import tree back to the model itself)

		if (extensionDefinitionsAdded) {
			extensionDefinitionsAdded = false;
			fireRccSyntaxChanged();
		}
	}
	
	private boolean extensionDefinitionsAdded = false;
	
	public void syntaxChanged() {
		getExtensionDefinitionManager().syntaxChanged();
		fireRccSyntaxChanged();
	}

	public boolean addExtensionDefinitions(Model model) {		
		boolean added = getExtensionDefinitionManager().addExtensionDefinitions(model);
		
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				getSourceViewerConfiguration().getPresentationReconciler(getSourceViewer()).uninstall();
				((SourceViewerConfiguration) getSourceViewerConfiguration()).clearPresentationReconciler();
				getSourceViewerConfiguration().getPresentationReconciler(getSourceViewer()).install(getSourceViewer());
			}
		});
		
		return added;
	}
	
	public void unwindExtensionDefinitionEffects(Model model) {
		getExtensionDefinitionManager().unwindExtensionDefinitionEffects(model);
	}

	@Override
	public IModelCreatingContext createModelCreatingContext() {
//		URL url = FileLocator.find(getPluginBundle(), new Path(getMetaModelPath()), null);
//		FileLocator.toFileURL(url)
//		try {
//			System.out.println(FileLocator.toFileURL(url).toString());
//		}
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//ResourceSet resourceSet = new ResourceSetImpl();
        //Resource resource = resourceSet.getResource(url.toURI(), true);
		return new DbxModelCreationContext(getMetaModelPackages(), getSemanticsProvider(),
				new ResourceImpl(), resourceSet, getCurrentText());
	}

	@Override
	protected Bundle getPluginBundle() {
		return Activator.getDefault().getBundle();
	}
	
	
	private Syntax syntax;
	
	@Override
	public Syntax getSyntax() {
		if (syntax == null) {
			try {
				syntax = createSyntax();
			}
			catch (TslException e) {
				throw new RuntimeException(e);
			}
		}
		return syntax;
	}

	@Override
	protected Syntax createSyntax() throws TslException {
		Bundle bundle = getPluginBundle();
		if (bundle == null) {
			bundle = TEFPlugin.getDefault().getBundle();
		}
		
		return Utilities.loadSyntaxDescription(bundle, getSyntaxPath(), getMetaModelPackages());
	
		/*InputDialog dialog = new InputDialog(getEditorSite().getShell(), "Syntax File", "Enter syntax file name:", "/resources/dbl-ext.etslt", null);
		if (dialog.open() == IDialogConstants.OK_ID) {
			String syntaxFile = dialog.getValue();
			return Utilities.loadSyntaxDescription(bundle, syntaxFile, getMetaModelPackages());
		}
		else {
			throw new TslException("no textual syntax file specified.");
		}*/
	}

}

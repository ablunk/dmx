package hub.sam.dmx.editor.modelcreation;

import hub.sam.dmx.editor.DbxPreProcessor;
import hub.sam.dmx.editor.semantics.ExtensionManager;
import hub.sam.tef.modelcreating.IModelCreatingContext;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

public class DbxParser extends DblParser {
	
	public DbxParser(IPath inputPath, String filename) {
		super(inputPath, filename);
	}
	
	protected void initPreProcessor() {
		_preProcessor = new DbxPreProcessor(getExtensionDefinitionManager(), filename, null);
	}
	
	private ExtensionManager _extensionDefinitionManager;
	
	private ExtensionManager getExtensionDefinitionManager() {
		if (_extensionDefinitionManager == null) {
			_extensionDefinitionManager = new ExtensionManager(getSyntax(), getDblMetaModel());
		}
		return _extensionDefinitionManager;
	}

	@Override
	public IModelCreatingContext createModelCreatingContext() {
		return new DbxModelCreationContext(getMetaModelPackages(), getSemanticsProvider(),
				new ResourceImpl(), resourceSet, getCurrentText());

	}

}

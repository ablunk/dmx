package hub.sam.dmx.editor.modelcreation;

import hub.sam.dmx.editor.DbxPreProcessor;
import hub.sam.dmx.editor.semantics.ExtensionDefinitionManager;
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
	
	private ExtensionDefinitionManager _extensionDefinitionManager;
	
	private ExtensionDefinitionManager getExtensionDefinitionManager() {
		if (_extensionDefinitionManager == null) {
			_extensionDefinitionManager = new ExtensionDefinitionManager(getSyntax(), getDblMetaModel());
		}
		return _extensionDefinitionManager;
	}

	@Override
	public IModelCreatingContext createModelCreatingContext() {
		return new DbxModelCreationContext(getMetaModelPackages(), getSemanticsProvider(),
				new ResourceImpl(), resourceSet, getCurrentText());

	}

}

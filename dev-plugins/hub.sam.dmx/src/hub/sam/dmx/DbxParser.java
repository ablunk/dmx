package hub.sam.dmx;

import org.eclipse.core.runtime.IPath;

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

}

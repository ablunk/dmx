package hub.sam.dmx.editor.semantics;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Extension;
import hub.sam.dbl.Model;
import hub.sam.dbl.Module;
import hub.sam.dmx.editor.semantics.ExtensionSyntaxDefinitionProcessor;
import hub.sam.tef.tsl.Syntax;

public class ExtensionManager implements IExtensionApplier {
	
	private static final Logger logger = Logger.getLogger(ExtensionManager.class.getName());

	private final Map<String, ExtensionSyntaxDefinitionProcessor> extensionsProcessed = new HashMap<String, ExtensionSyntaxDefinitionProcessor>();
	
	private final Syntax _syntax;
	private final DblPackage _dblMetaModel;

	public ExtensionManager(Syntax _syntax, DblPackage _dblMetaModel) {
		this._syntax = _syntax;
		this._dblMetaModel = _dblMetaModel;
	}

	public Syntax getSyntax() {
		return _syntax;
	}

	public DblPackage getDblMetaModel() {
		return _dblMetaModel;
	}

	@Override
	public boolean addExtensions(Model model) {
		boolean extensioninitionsAdded = false;
		for (Module module: model.getModules()) {
			for (Extension extension: module.getExtensions()) {
				if (!extensionsProcessed.containsKey(extension.getName())) {
					extensioninitionsAdded |= addExtension(extension);;
				}
			}
		}
		return extensioninitionsAdded;
	}

	@Override
	public void unwindExtensionEffects(Model model) {
		for (Module module: model.getModules()) {
			for (Extension extension: module.getExtensions()) {
				if (extensionsProcessed.containsKey(extension.getName())) {
					logger.info("unwinding extension definition '" + extension.getName() + "' ...");
					extensionsProcessed.get(extension.getName()).revert();
					extensionsProcessed.remove(extension.getName());
				}
			}
		}
	}
	
	private boolean addExtension(Extension extension) {
		logger.info("adding extension definition '" + extension.getName() + "' ...");
		
		ExtensionSyntaxDefinitionProcessor processor = new ExtensionSyntaxDefinitionProcessor(extension, getSyntax(), getDblMetaModel());
		boolean added = processor.addToDbl();
		if (added) {
			extensionsProcessed.put(extension.getName(), processor);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void syntaxChanged() {
		// TODO Auto-generated method stub
		
	}

}

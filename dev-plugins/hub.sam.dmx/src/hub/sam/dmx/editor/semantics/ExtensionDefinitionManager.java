package hub.sam.dmx.editor.semantics;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExtensionDefinition;
import hub.sam.dbl.Model;
import hub.sam.dbl.Module;
import hub.sam.dmx.editor.semantics.ExtensionSyntaxDefinitionProcessor;
import hub.sam.tef.tsl.Syntax;

public class ExtensionDefinitionManager implements IExtensionDefinitionApplier {
	
	private static final Logger logger = Logger.getLogger(ExtensionDefinitionManager.class.getName());

	private final Map<String, ExtensionSyntaxDefinitionProcessor> extensionDefsProcessed = new HashMap<String, ExtensionSyntaxDefinitionProcessor>();
	
	private final Syntax _syntax;
	private final DblPackage _dblMetaModel;

	public ExtensionDefinitionManager(Syntax _syntax, DblPackage _dblMetaModel) {
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
	public boolean addExtensionDefinitions(Model model) {
		boolean extensionDefinitionsAdded = false;
		for (Module module: model.getModules()) {
			for (ExtensionDefinition extensionDef: module.getExtensionDefinitions()) {
				if (!extensionDefsProcessed.containsKey(extensionDef.getName())) {
					extensionDefinitionsAdded |= addExtensionDefinition(extensionDef);;
				}
			}
		}
		return extensionDefinitionsAdded;
	}

	@Override
	public void unwindExtensionDefinitionEffects(Model model) {
		for (Module module: model.getModules()) {
			for (ExtensionDefinition extensionDef: module.getExtensionDefinitions()) {
				if (extensionDefsProcessed.containsKey(extensionDef.getName())) {
					logger.info("unwinding extension definition '" + extensionDef.getName() + "' ...");
					extensionDefsProcessed.get(extensionDef.getName()).revert();
					extensionDefsProcessed.remove(extensionDef.getName());
				}
			}
		}
	}
	
	private boolean addExtensionDefinition(ExtensionDefinition extensionDef) {
		logger.info("adding extension definition '" + extensionDef.getName() + "' ...");
		
		ExtensionSyntaxDefinitionProcessor processor = new ExtensionSyntaxDefinitionProcessor(extensionDef, getSyntax(), getDblMetaModel());
		boolean added = processor.addToDbl();
		if (added) {
			extensionDefsProcessed.put(extensionDef.getName(), processor);
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

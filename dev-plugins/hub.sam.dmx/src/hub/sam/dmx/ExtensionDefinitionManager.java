package hub.sam.dmx;

import java.util.HashMap;
import java.util.Map;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExtensionDefinition;
import hub.sam.dbl.Model;
import hub.sam.dbl.Module;
import hub.sam.tef.tsl.Syntax;

public class ExtensionDefinitionManager implements IExtensionDefinitionApplier {

	private final Map<String, ExtensionDefinitionProcessor> extensionDefsProcessed = new HashMap<String, ExtensionDefinitionProcessor>();
	
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
			for (ExtensionDefinition extensionDef: module.getExtensionDefs()) {
				if (!extensionDefsProcessed.containsKey(extensionDef.getName())) {
					addExtensionDefinition(extensionDef);
					extensionDefinitionsAdded = true;
				}
			}
		}
		return extensionDefinitionsAdded;
	}

	@Override
	public void unwindExtensionDefinitionEffects(Model model) {
		for (Module module: model.getModules()) {
			for (ExtensionDefinition extensionDef: module.getExtensionDefs()) {
				if (extensionDefsProcessed.containsKey(extensionDef.getName())) {
					System.out.println("unwinding extension definition '" + extensionDef.getName() + "' ...");
					extensionDefsProcessed.get(extensionDef.getName()).revert();
					extensionDefsProcessed.remove(extensionDef.getName());
				}
			}
		}
	}
	
	private void addExtensionDefinition(ExtensionDefinition extensionDef) {
		System.out.println("adding extension definition '" + extensionDef.getName() + "' ...");
		
		ExtensionDefinitionProcessor processor = new ExtensionDefinitionProcessor(extensionDef, getSyntax(), getDblMetaModel());
		boolean added = processor.addToSyntax();
		if (added) {
			extensionDefsProcessed.put(extensionDef.getName(), processor);
		}
	}

	@Override
	public void syntaxChanged() {
		// TODO Auto-generated method stub
		
	}

}

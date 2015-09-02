package hub.sam.dmx.editor.semantics;

import hub.sam.dbl.Model;

public interface IExtensionDefinitionApplier {
	boolean addExtensionDefinitions(Model model);
	void unwindExtensionDefinitionEffects(Model model);
	void syntaxChanged();
}

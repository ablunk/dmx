package hub.sam.dmx.editor.semantics;

import hub.sam.dbl.Model;

public interface IExtensionApplier {
	boolean addExtensions(Model model);
	void unwindExtensionEffects(Model model);
	void syntaxChanged();
}

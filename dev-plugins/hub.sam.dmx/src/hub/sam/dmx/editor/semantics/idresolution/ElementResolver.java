package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;

import hub.sam.dbl.NamedElement;

public interface ElementResolver<C> {
	Collection<IdentifiedElement> resolvePossibleElements(String identifier, C context);
}

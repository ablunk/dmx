package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;

import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;

public interface ElementResolver {
	void resolvePossibleElements(NamedElement identifier, IdExpr idExprContext, Collection<IdentifiedElement> identifiedElements);
}

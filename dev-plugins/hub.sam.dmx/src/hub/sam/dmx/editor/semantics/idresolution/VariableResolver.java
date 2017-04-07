package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;

import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;

public class VariableResolver implements ElementResolver {

	@Override
	public void resolvePossibleElements(NamedElement identifier, IdExpr idExprContext,
			Collection<IdentifiedElement> identifiedElements) {
		
		new LocalVariableResolver().resolvePossibleElements(identifier, idExprContext, identifiedElements);
		
		if (identifiedElements.isEmpty()) {
			new AttributeResolver().resolvePossibleElements(identifier, idExprContext, identifiedElements);
		}
	}

}

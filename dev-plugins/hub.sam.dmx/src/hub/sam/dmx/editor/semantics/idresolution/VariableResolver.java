package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;

import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;

public class VariableResolver implements ElementResolver<IdExpr> {

	@Override
	public Collection<IdentifiedElement> resolvePossibleElements(NamedElement identifier, IdExpr idExprContext) {
		
		Collection<IdentifiedElement> identifiedLocalVariables = new LocalVariableResolver()
				.resolvePossibleElements(identifier, idExprContext);
		
		if (identifiedLocalVariables.isEmpty()) {
			return new AttributeResolver().resolvePossibleElements(identifier, idExprContext);
		}
		
		return identifiedLocalVariables;
	}

}

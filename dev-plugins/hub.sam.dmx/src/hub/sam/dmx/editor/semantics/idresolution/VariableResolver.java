package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;

import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;

public class VariableResolver implements ElementResolver<IdExpr> {
	
	private LocalVariableResolver localVariableResolver = new LocalVariableResolver();
	private AttributeResolver attributeResolver = new AttributeResolver();
	private GlobalVariableResolver globalVariableResolver = new GlobalVariableResolver();

	@Override
	public Collection<IdentifiedElement> resolvePossibleElements(NamedElement identifier, IdExpr idExprContext) {
		
		Collection<IdentifiedElement> identifiedLocalVariables = localVariableResolver
				.resolvePossibleElements(identifier, idExprContext);
		
		if (identifiedLocalVariables.isEmpty()) {
			identifiedLocalVariables.addAll(attributeResolver.resolvePossibleElements(identifier, idExprContext));
		}
		
		if (identifiedLocalVariables.isEmpty()) {
			identifiedLocalVariables.addAll(globalVariableResolver.resolvePossibleElements(identifier, idExprContext));
		}

		return identifiedLocalVariables;
	}

}

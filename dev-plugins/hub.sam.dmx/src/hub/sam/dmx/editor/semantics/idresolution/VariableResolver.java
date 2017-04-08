package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;

import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;

public class VariableResolver implements ElementResolver<IdExpr> {
	
	private LocalVariableResolver localVariableResolver = new LocalVariableResolver();
	private AttributeResolver attributeResolver = new AttributeResolver();
	private GlobalVariableResolver globalVariableResolver = new GlobalVariableResolver();

	@Override
	public Collection<IdentifiedElement> resolve(String identifier, IdExpr idExprContext) {
		
		Collection<IdentifiedElement> localVariables = localVariableResolver
				.resolve(identifier, idExprContext);
		
		if (localVariables.isEmpty()) {
			localVariables.addAll(attributeResolver.resolve(identifier, idExprContext));
		}
		
		if (localVariables.isEmpty()) {
			localVariables.addAll(globalVariableResolver.resolve(identifier, idExprContext));
		}

		return localVariables;
	}

}

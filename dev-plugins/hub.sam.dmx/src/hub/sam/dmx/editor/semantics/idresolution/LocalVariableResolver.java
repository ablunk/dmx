package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.Objects;

import hub.sam.dbl.Function;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.LocalScope;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.Variable;

public class LocalVariableResolver extends NamedElementIdentifier implements ElementResolver {
	
	@Override
	public void resolvePossibleElements(NamedElement identifier, IdExpr idExprContext,
			Collection<IdentifiedElement> identifiedElements) {
		Containment.getContainerObjectOfType(idExprContext, LocalScope.class)
			.ifPresent(localScope -> identifyLocalVariables(localScope, identifier, identifiedElements));
	}

	private void identifyLocalVariables(LocalScope localScopeContext, NamedElement identifier, Collection<IdentifiedElement> identifiedElements) {
		localScopeContext.getStatements().stream()
			.map(statement -> statement instanceof Variable ? (Variable) statement : null)
			.filter(Objects::nonNull)
			.forEach(localVariable -> identify(identifier, localVariable, identifiedElements));
		
		Containment.getContainerObjectOfType(localScopeContext.eContainer(), LocalScope.class)
			.ifPresent(parentScope -> identifyLocalVariables(parentScope, identifier, identifiedElements));

		Containment.getContainerObjectOfType(localScopeContext, Function.class)
			.ifPresent(functionContainer -> identifyMethodParameter(functionContainer, identifier, identifiedElements));
	}

	private void identifyMethodParameter(Function functionContainer, NamedElement identifier, Collection<IdentifiedElement> identifiedElements) {
		functionContainer.getParameters().stream()
			.forEach(parameter -> identify(identifier, parameter, identifiedElements));
	}

}

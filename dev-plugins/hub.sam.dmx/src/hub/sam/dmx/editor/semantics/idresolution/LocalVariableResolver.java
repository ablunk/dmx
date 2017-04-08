package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

import hub.sam.dbl.Function;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.LocalScope;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.Variable;

public class LocalVariableResolver extends NamedElementIdentifier implements ElementResolver<IdExpr> {
	
	private Collection<IdentifiedElement> identifiedLocalVariables = new HashSet<>();
	
	@Override
	public Collection<IdentifiedElement> resolvePossibleElements(NamedElement identifier, IdExpr idExprContext) {
		Containment.getContainerObjectOfType(idExprContext, LocalScope.class)
			.ifPresent(localScope -> addLocalVariablesMatchingIdentifier(localScope, identifier));
		
		return identifiedLocalVariables;
	}

	private void addLocalVariablesMatchingIdentifier(LocalScope localScopeContext, NamedElement identifier) {
		localScopeContext.getStatements().stream()
			.map(statement -> statement instanceof Variable ? (Variable) statement : null)
			.filter(Objects::nonNull)
			.forEach(localVariable -> addElementIfIdentifierIsMatching(identifiedLocalVariables, localVariable, identifier));
		
		addParentLocalScopeVariables(localScopeContext, identifier);
		addMethodParameters(localScopeContext, identifier);
	}

	private void addParentLocalScopeVariables(LocalScope localScopeContext, NamedElement identifier) {
		Containment.getContainerObjectOfType(localScopeContext.eContainer(), LocalScope.class)
			.ifPresent(parentScope -> addLocalVariablesMatchingIdentifier(parentScope, identifier));
	}

	private void addMethodParameters(LocalScope localScopeContext, NamedElement identifier) {
		Containment.getContainerObjectOfType(localScopeContext, Function.class)
			.ifPresent(functionContainer -> functionContainer.getParameters().stream()
					.forEach(parameter -> addElementIfIdentifierIsMatching(identifiedLocalVariables, parameter, identifier)));
	}
	
}

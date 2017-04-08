package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import hub.sam.dbl.Constructor;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Function;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.LocalScope;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.Variable;

public class LocalVariableResolver extends NamedElementResolver implements ElementResolver<IdExpr> {
		
	@Override
	public Collection<IdentifiedElement> resolvePossibleElements(NamedElement identifier, IdExpr idExprContext) {
		return identifyInContainer(identifier, idExprContext, LocalScope.class, 
				(id, localScope) -> identifyLocalVariables(id, localScope));		
	}
	
	private Collection<IdentifiedElement> identifyLocalVariables(NamedElement identifier, LocalScope localScopeContext) {
		Collection<IdentifiedElement> identifiedLocalVariables = identifyLocalScopeVariables(identifier, localScopeContext);
		identifiedLocalVariables.addAll(identifyMethodParameters(identifier, localScopeContext));
		identifiedLocalVariables.addAll(identifyConstructorParameters(identifier, localScopeContext));
		
		return identifiedLocalVariables;
	}
	
	private Collection<IdentifiedElement> identifyLocalScopeVariables(NamedElement identifier, LocalScope localScopeContext) {
		Collection<IdentifiedElement> identifiedLocalVariables = localScopeContext.getStatements().stream()
				.map(statement -> statement instanceof Variable ? (Variable) statement : null)
				.filter(Objects::nonNull)
				.map(localVariable -> identify(identifier, localVariable))
				.filter(Objects::nonNull)
				.collect(Collectors.toSet());
		
		identifiedLocalVariables.addAll(identifyParentLocalScopeVariables(identifier, localScopeContext));
		
		return identifiedLocalVariables;
	}

	private Collection<IdentifiedElement> identifyParentLocalScopeVariables(NamedElement identifier, LocalScope localScopeContext) {
		return identifyInContainer(identifier, localScopeContext.eContainer(), LocalScope.class, 
				(id, parentLocalScopeContetx) -> identifyLocalScopeVariables(id, parentLocalScopeContetx));
	}

	private Collection<IdentifiedElement> identifyMethodParameters(NamedElement identifier, LocalScope localScopeContext) {
		return identifyInContainer(identifier, localScopeContext, Function.class, DblPackage.Literals.FUNCTION__PARAMETERS);
	}
	
	private Collection<IdentifiedElement> identifyConstructorParameters(NamedElement identifier, LocalScope localScopeContext) {
		return identifyInContainer(identifier, localScopeContext, Constructor.class, DblPackage.Literals.CONSTRUCTOR__PARAMETERS);
	}

}

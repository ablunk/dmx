package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

import hub.sam.dbl.Constructor;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Function;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.LocalScope;
import hub.sam.dbl.Variable;

public class LocalVariableResolver extends HierarchicalResolver implements ElementResolver<IdExpr> {
		
	@Override
	public Collection<IdentifiedElement> resolve(String identifier, IdExpr idExprContext) {
		return resolveInContainer(identifier, idExprContext, LocalScope.class, 
				(id, localScope) -> resolveLocalVariables(id, localScope));		
	}
	
	private Collection<IdentifiedElement> resolveLocalVariables(String identifier, LocalScope localScopeContext) {
		Collection<IdentifiedElement> localVariables = new HashSet<>();
		localVariables.addAll(resolveLocalScopeVariables(identifier, localScopeContext));
		localVariables.addAll(resolveMethodParameters(identifier, localScopeContext));
		localVariables.addAll(resolveConstructorParameters(identifier, localScopeContext));
		
		return localVariables;
	}
	
	private Collection<IdentifiedElement> resolveLocalScopeVariables(String identifier, LocalScope localScopeContext) {
		Collection<IdentifiedElement> localVariables = localScopeContext.getStatements().stream()
				.map(statement -> statement instanceof Variable ? (Variable) statement : null)
				.filter(Objects::nonNull)
				.map(localVariable -> identify(identifier, localVariable))
				.filter(Objects::nonNull)
				.collect(Collectors.toSet());
		
		localVariables.addAll(resolveParentLocalScopeVariables(identifier, localScopeContext));
		
		return localVariables;
	}

	private Collection<IdentifiedElement> resolveParentLocalScopeVariables(String identifier, LocalScope localScopeContext) {
		return resolveInContainer(identifier, localScopeContext.eContainer(), LocalScope.class, 
				(id, parentLocalScopeContetx) -> resolveLocalScopeVariables(id, parentLocalScopeContetx));
	}

	private Collection<IdentifiedElement> resolveMethodParameters(String identifier, LocalScope localScopeContext) {
		return resolveInContainer(identifier, localScopeContext, Function.class, DblPackage.Literals.FUNCTION__PARAMETERS);
	}
	
	private Collection<IdentifiedElement> resolveConstructorParameters(String identifier, LocalScope localScopeContext) {
		return resolveInContainer(identifier, localScopeContext, Constructor.class, DblPackage.Literals.CONSTRUCTOR__PARAMETERS);
	}

}

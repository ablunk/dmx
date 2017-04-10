package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import hub.sam.dbl.Class;
import hub.sam.dbl.Function;
import hub.sam.dbl.IdExpr;

public class MethodResolver extends MemberResolver implements ElementResolver<IdExpr> {
	
	@Override
	public Collection<IdentifiedElement> resolve(String identifier, IdExpr idExprContext) {
		if (idExprContext.getCallPart() != null) {
			if (idExprContext.getParentIdExpr() == null) {
				return resolveInContainer(identifier, idExprContext, Class.class,
						(id, containerClass) -> resolvePlainMethods(identifier, idExprContext, containerClass));
			} else {
				return resolveFeaturesInNavigation(identifier, idExprContext);
			}
		} else {
			return new HashSet<>();
		}
	}
	
	protected Collection<IdentifiedElement> resolvePlainMembers(String identifier, IdExpr idExprContext, Class containerClass) {
		return resolvePlainMethods(identifier, idExprContext, containerClass);
	}
	
	private Collection<IdentifiedElement> resolvePlainMethods(String identifier, IdExpr idExprContext, Class containerClass) {
		Collection<IdentifiedElement> methods = resolveInElements(identifier, filterPossibleMethods(idExprContext, containerClass.getMethods()));
		
		if (methods.isEmpty()) {
			methods.addAll(resolveInheritedFeaturesRecursive(identifier, idExprContext, containerClass));
		}
		
		return methods;
	}
	
	private List<Function> filterPossibleMethods(IdExpr idExprContext, List<Function> methods) {
		return methods.stream()
				.filter(method -> method.getParameters().size() == idExprContext.getCallPart().getCallArguments().size())
				.collect(Collectors.toList());
	}
	
	private Collection<IdentifiedElement> resolveInheritedFeaturesRecursive(String identifier, IdExpr idExprContext, Class dblClass) {
		Collection<IdentifiedElement> methods = new HashSet<>();
		for (Class superClass: dblClass.getSuperClasses()) {
			if (methods.isEmpty()) {
				methods.addAll(resolveInElements(identifier, filterPossibleMethods(idExprContext, superClass.getMethods())));
			}
		}
		for (Class superClass: dblClass.getSuperClasses()) {
			if (methods.isEmpty()) {
				methods.addAll(resolveInheritedFeaturesRecursive(identifier, idExprContext, superClass));
			}
		}		
		return methods;
	}

}

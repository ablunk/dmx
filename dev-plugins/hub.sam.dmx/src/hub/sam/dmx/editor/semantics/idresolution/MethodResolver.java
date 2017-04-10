package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import hub.sam.dbl.Class;
import hub.sam.dbl.Function;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.TypedElement;

public class MethodResolver extends HierarchicalResolver implements ElementResolver<IdExpr> {
	
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

	private Collection<IdentifiedElement> resolveFeaturesInNavigation(String identifier, IdExpr idExprContext) {
		IdExpr parentIdExpr = idExprContext.getParentIdExpr();
		NamedElement parentNamedElement = parentIdExpr.getReferencedElement();
		if (parentNamedElement != null && parentNamedElement instanceof TypedElement) {
			TypedElement parentTypedElement = (TypedElement) parentNamedElement;
			IdExpr parentClassifierIdExpr = parentTypedElement.getClassifierType();
			if (parentClassifierIdExpr != null && parentClassifierIdExpr.getReferencedElement() != null
					&& parentClassifierIdExpr.getReferencedElement() instanceof Class) {
				Class referencedClassInParentClass = (Class) parentClassifierIdExpr.getReferencedElement();
				return resolvePlainMethods(identifier, idExprContext, referencedClassInParentClass);
			}
		}
		return Collections.emptySet();
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

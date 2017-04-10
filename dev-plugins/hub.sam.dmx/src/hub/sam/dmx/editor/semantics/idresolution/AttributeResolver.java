package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import hub.sam.dbl.Class;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.TypedElement;

public class AttributeResolver extends HierarchicalResolver implements ElementResolver<IdExpr> {
	
	@Override
	public Collection<IdentifiedElement> resolve(String identifier, IdExpr idExprContext) {
		if (idExprContext.getCallPart() == null) {
			if (idExprContext.getParentIdExpr() == null) {
				return resolveInContainer(identifier, idExprContext, Class.class,
						(id, containerClass) -> resolvePlainAttributes(identifier, containerClass));
			} else {
				return resolveAttributesInNavigation(identifier, idExprContext);
			}
		} else {
			return new HashSet<>();
		}
	}

	private Collection<IdentifiedElement> resolveAttributesInNavigation(String identifier, IdExpr idExprContext) {
		IdExpr parentIdExpr = idExprContext.getParentIdExpr();
		NamedElement parentNamedElement = parentIdExpr.getReferencedElement();
		if (parentNamedElement != null && parentNamedElement instanceof TypedElement) {
			TypedElement parentTypedElement = (TypedElement) parentNamedElement;
			IdExpr parentClassifierIdExpr = parentTypedElement.getClassifierType();
			if (parentClassifierIdExpr != null && parentClassifierIdExpr.getReferencedElement() != null
					&& parentClassifierIdExpr.getReferencedElement() instanceof Class) {
				Class referencedClassInParentClass = (Class) parentClassifierIdExpr.getReferencedElement();
				return resolvePlainAttributes(identifier, referencedClassInParentClass);
			}
		}
		return Collections.emptySet();
	}
	
	private Collection<IdentifiedElement> resolvePlainAttributes(String identifier, Class containerClass) {
		Collection<IdentifiedElement> attributes = resolveInElements(identifier, containerClass.getAttributes());
		
		if (attributes.isEmpty()) {
			attributes.addAll(resolveInheritedAttributesRecursive(identifier, containerClass));
		}
		
		return attributes;
	}
	
	private Collection<IdentifiedElement> resolveInheritedAttributesRecursive(String identifier, Class dblClass) {
		Collection<IdentifiedElement> attributes = new HashSet<>();
		for (Class superClass: dblClass.getSuperClasses()) {
			if (attributes.isEmpty()) {
				attributes.addAll(resolveInElements(identifier, superClass.getAttributes()));
			}
		}
		for (Class superClass: dblClass.getSuperClasses()) {
			if (attributes.isEmpty()) {
				attributes.addAll(resolveInheritedAttributesRecursive(identifier, superClass));
			}
		}		
		return attributes;
	}

}
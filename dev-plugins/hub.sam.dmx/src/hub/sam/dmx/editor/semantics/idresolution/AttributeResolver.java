package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import hub.sam.dbl.Class;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.TypedElement;

public class AttributeResolver extends NamedElementResolver implements ElementResolver<IdExpr> {
	
	@Override
	public Collection<IdentifiedElement> resolvePossibleElements(String identifier, IdExpr idExprContext) {
		if (idExprContext.getParentIdExpr() == null) {
			return resolveInContainer(identifier, idExprContext, Class.class,
					(id, containerClass) -> resolvePlainAttributes(identifier, containerClass));
		} else {
			return resolveNavigatedAttributes(identifier, idExprContext);
		}
	}

	private Collection<IdentifiedElement> resolveNavigatedAttributes(String identifier, IdExpr idExprContext) {
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
		Collection<IdentifiedElement> identifiedAttributes = resolve(identifier, containerClass.getAttributes());
		
		if (identifiedAttributes.isEmpty()) {
			identifiedAttributes.addAll(resolveInheritedAttributesRecursive(identifier, containerClass));
		}
		
		return identifiedAttributes;
	}
	
	private Collection<IdentifiedElement> resolveInheritedAttributesRecursive(String identifier, Class dblClass) {
		if (dblClass.getSuperClass() != null && dblClass.getSuperClass().getReferencedElement() != null) {
			NamedElement referencedSuperClass = dblClass.getSuperClass().getReferencedElement();
			if (referencedSuperClass instanceof hub.sam.dbl.Class) {
				hub.sam.dbl.Class superClass = (hub.sam.dbl.Class) referencedSuperClass;

				Collection<IdentifiedElement> identifiedAttributes = resolve(identifier, superClass.getAttributes());
				if (identifiedAttributes.isEmpty()) {
					identifiedAttributes.addAll(resolveInheritedAttributesRecursive(identifier, superClass));
				}
				
				return identifiedAttributes;
			}	
		}
		
		return new HashSet<>();
	}

}

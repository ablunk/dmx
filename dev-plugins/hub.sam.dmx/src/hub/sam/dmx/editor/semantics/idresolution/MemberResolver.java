package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.Collections;

import hub.sam.dbl.Class;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.TypedElement;

abstract public class MemberResolver extends HierarchicalResolver {

	protected Collection<IdentifiedElement> resolveFeaturesInNavigation(String identifier, IdExpr idExprContext) {
		IdExpr parentIdExpr = idExprContext.getParentIdExpr();
		NamedElement parentNamedElement = parentIdExpr.getReferencedElement();
		if (parentNamedElement != null) {
			if (parentNamedElement instanceof TypedElement) {
				TypedElement parentTypedElement = (TypedElement) parentNamedElement;
				IdExpr parentClassifierIdExpr = parentTypedElement.getClassifierType();
				if (parentClassifierIdExpr != null && parentClassifierIdExpr.getReferencedElement() != null
						&& parentClassifierIdExpr.getReferencedElement() instanceof Class) {
					Class referencedClassInParentClass = (Class) parentClassifierIdExpr.getReferencedElement();
					return resolvePlainMembers(identifier, idExprContext, referencedClassInParentClass);
				}
			} else if (parentNamedElement instanceof Class) {
				Class referencedClass = (Class) parentNamedElement;
				return resolvePlainMembers(identifier, idExprContext, referencedClass);
			}
		}
		return Collections.emptySet();
	}
	
	abstract protected Collection<IdentifiedElement> resolvePlainMembers(String identifier, IdExpr idExprContext, Class containerClass);
	
}

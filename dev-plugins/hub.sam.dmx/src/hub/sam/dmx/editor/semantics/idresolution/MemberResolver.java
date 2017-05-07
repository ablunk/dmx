package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.Collections;

import hub.sam.dbl.Classifier;
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
						&& parentClassifierIdExpr.getReferencedElement() instanceof Classifier) {
					Classifier referencedClassInParentClassifier = (Classifier) parentClassifierIdExpr.getReferencedElement();
					return resolvePlainMembers(identifier, idExprContext, referencedClassInParentClassifier);
				}
			} else if (parentNamedElement instanceof Classifier) {
				Classifier referencedClassifier = (Classifier) parentNamedElement;
				return resolvePlainMembers(identifier, idExprContext, referencedClassifier);
			}
		}
		return Collections.emptySet();
	}
	
	abstract protected Collection<IdentifiedElement> resolvePlainMembers(String identifier, IdExpr idExprContext, Classifier containerClassifier);
	
}

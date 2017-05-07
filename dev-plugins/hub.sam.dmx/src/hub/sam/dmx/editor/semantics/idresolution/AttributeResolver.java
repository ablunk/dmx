package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.HashSet;

import hub.sam.dbl.Class;
import hub.sam.dbl.Classifier;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.Interface;

public class AttributeResolver extends MemberResolver implements ElementResolver<IdExpr> {
	
	@Override
	public Collection<IdentifiedElement> resolve(String identifier, IdExpr idExprContext) {
		if (idExprContext.getCallPart() == null) {
			if (idExprContext.getParentIdExpr() == null) {
				return resolveInContainer(identifier, idExprContext, Classifier.class,
						(id, containerClass) -> resolvePlainAttributes(identifier, containerClass));
			} else {
				return resolveFeaturesInNavigation(identifier, idExprContext);
			}
		} else {
			return new HashSet<>();
		}
	}

	@Override
	protected Collection<IdentifiedElement> resolvePlainMembers(String identifier, IdExpr idExprContext, Classifier containerClassifier) {
		return resolvePlainAttributes(identifier, containerClassifier);
	}
	
	private Collection<IdentifiedElement> resolvePlainAttributes(String identifier, Classifier containerClassifier) {
		Collection<IdentifiedElement> attributes = new HashSet<>();
		
		attributes.addAll(resolveInElements(identifier, containerClassifier.getAttributes()));
		
		if (attributes.isEmpty()) {
			attributes.addAll(resolveInheritedAttributesRecursive(identifier, containerClassifier));
		}
		
		return attributes;
	}
	
	private Collection<IdentifiedElement> resolveInheritedAttributesRecursive(String identifier, Classifier classifier) {
		Collection<IdentifiedElement> attributes = new HashSet<>();

		if (classifier instanceof Class) {
			Class dblClass = (Class) classifier;
			Class superClass = dblClass.getSuperClass();
			if (superClass != null && attributes.isEmpty()) {
				attributes.addAll(resolveInElements(identifier, superClass.getAttributes()));
			}
		}
		
		for (Interface superInterface: classifier.getSuperInterfaces()) {
			if (attributes.isEmpty()) {
				attributes.addAll(resolveInElements(identifier, superInterface.getAttributes()));
			}
		}
		
		if (classifier instanceof Class) {
			Class dblClass = (Class) classifier;
			Class superClass = dblClass.getSuperClass();
			if (superClass != null && attributes.isEmpty()) {
				attributes.addAll(resolveInheritedAttributesRecursive(identifier, superClass));
			}
		}

		for (Interface superInterface: classifier.getSuperInterfaces()) {
			if (attributes.isEmpty()) {
				attributes.addAll(resolveInheritedAttributesRecursive(identifier, superInterface));
			}
		}		
		
		return attributes;
	}

}

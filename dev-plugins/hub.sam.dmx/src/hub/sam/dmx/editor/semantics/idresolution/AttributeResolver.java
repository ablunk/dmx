package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.HashSet;

import hub.sam.dbl.Class;
import hub.sam.dbl.IdExpr;

public class AttributeResolver extends MemberResolver implements ElementResolver<IdExpr> {
	
	@Override
	public Collection<IdentifiedElement> resolve(String identifier, IdExpr idExprContext) {
		if (idExprContext.getCallPart() == null) {
			if (idExprContext.getParentIdExpr() == null) {
				return resolveInContainer(identifier, idExprContext, Class.class,
						(id, containerClass) -> resolvePlainAttributes(identifier, containerClass));
			} else {
				return resolveFeaturesInNavigation(identifier, idExprContext);
			}
		} else {
			return new HashSet<>();
		}
	}

	protected Collection<IdentifiedElement> resolvePlainMembers(String identifier, IdExpr idExprContext, Class containerClass) {
		return resolvePlainAttributes(identifier, containerClass);
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

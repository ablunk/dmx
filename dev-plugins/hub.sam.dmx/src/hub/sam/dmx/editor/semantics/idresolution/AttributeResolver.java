package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.HashSet;

import hub.sam.dbl.Class;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;

public class AttributeResolver extends NamedElementResolver implements ElementResolver<IdExpr> {
	
	@Override
	public Collection<IdentifiedElement> resolvePossibleElements(String identifier, IdExpr idExprContext) {
		Collection<IdentifiedElement> identifiedAttributes = identifyInContainer(identifier, idExprContext, Class.class,
				DblPackage.Literals.CLASS__ATTRIBUTES);
		
		if (identifiedAttributes.isEmpty()) {
			identifiedAttributes.addAll(identifyInheritedAttributes(identifier, idExprContext));
		}
		
		return identifiedAttributes;
	}

	private Collection<IdentifiedElement> identifyInheritedAttributes(String identifier, IdExpr idExprContext) {
		return identifyInContainer(identifier, idExprContext, Class.class,
				(id, classContext) -> identifyInheritedAttributesRecursive(id, classContext));		
	}
	
	private Collection<IdentifiedElement> identifyInheritedAttributesRecursive(String identifier, Class dblClass) {
		if (dblClass.getSuperClass() != null && dblClass.getSuperClass().getReferencedElement() != null) {
			NamedElement referencedSuperClass = dblClass.getSuperClass().getReferencedElement();
			if (referencedSuperClass instanceof hub.sam.dbl.Class) {
				hub.sam.dbl.Class superClass = (hub.sam.dbl.Class) referencedSuperClass;

				Collection<IdentifiedElement> identifiedAttributes = identify(identifier, superClass.getAttributes());
				if (identifiedAttributes.isEmpty()) {
					identifiedAttributes.addAll(identifyInheritedAttributesRecursive(identifier, superClass));
				}
				
				return identifiedAttributes;
			}	
		}
		
		return new HashSet<>();
	}

}

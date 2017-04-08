package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.HashSet;

import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;

public class AttributeResolver extends NamedElementIdentifier implements ElementResolver<IdExpr> {
	
	private Collection<IdentifiedElement> identifiedAttributes = new HashSet<>();

	@Override
	public Collection<IdentifiedElement> resolvePossibleElements(NamedElement identifier, IdExpr idExprContext) {
		addDirectAttributesOfContextClass(identifier, idExprContext);
		
		if (noAttributesIdentified()) {
			addInheritedAttributesOfContextClass(identifier, idExprContext);
		}
		
		return identifiedAttributes;
	}
	
	private boolean noAttributesIdentified() {
		return identifiedAttributes.isEmpty();
	}

	private void addDirectAttributesOfContextClass(NamedElement identifier, IdExpr idExprContext) {
		Containment.getContainerObjectOfType(idExprContext, hub.sam.dbl.Class.class)
			.ifPresent(classContainer -> addDirectAttributesOfClass(classContainer, identifier));
	}

	private void addInheritedAttributesOfContextClass(NamedElement identifier, IdExpr idExprContext) {
		Containment.getContainerObjectOfType(idExprContext, hub.sam.dbl.Class.class)
		.ifPresent(classContainer -> addInheritedAttributesOfClass(classContainer, identifier));
	}

	private void addDirectAttributesOfClass(hub.sam.dbl.Class dblClass, NamedElement identifier) {
		dblClass.getAttributes().stream()
			.forEach(attribute -> addElementIfIdentifierIsMatching(identifiedAttributes, attribute, identifier));
	}

	private void addInheritedAttributesOfClass(hub.sam.dbl.Class dblClass, NamedElement identifier) {
		if (dblClass.getSuperClass() != null && dblClass.getSuperClass().getReferencedElement() != null) {
			NamedElement referencedSuperClass = dblClass.getSuperClass().getReferencedElement();
			if (referencedSuperClass instanceof hub.sam.dbl.Class) {
				hub.sam.dbl.Class superClass = (hub.sam.dbl.Class) referencedSuperClass;

				if (noAttributesIdentified()) {
					addDirectAttributesOfClass(superClass, identifier);
				}
				
				if (noAttributesIdentified()) {
					addInheritedAttributesOfClass(superClass, identifier);
				}
			}	
		}
	}

}

package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.HashSet;

import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;

public class AttributeResolver extends NamedElementIdentifier implements ElementResolver {
	
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
		dblClass.getSuperClasses().stream().forEach(superClassSpecification -> {			
			if (noAttributesIdentified()) {
				addDirectAttributesOfClass(superClassSpecification.getClass_(), identifier);
			}
		});

		dblClass.getSuperClasses().stream().forEach(superClassSpecification -> {
			if (noAttributesIdentified()) {
				addInheritedAttributesOfClass(superClassSpecification.getClass_(), identifier);
			}
		});
	}

}

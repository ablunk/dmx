package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;

import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;

public class AttributeResolver extends NamedElementIdentifier implements ElementResolver {
	
	@Override
	public void resolvePossibleElements(NamedElement identifier, IdExpr idExprContext,
			Collection<IdentifiedElement> identifiedElements) {
		
		Containment.getContainerObjectOfType(idExprContext, hub.sam.dbl.Class.class)
		.ifPresent(classContainer -> classContainer.getAttributes().stream()
				.forEach(attribute -> identify(identifier, attribute, identifiedElements)));
	}

}

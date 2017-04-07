package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;

import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;

public abstract class NamedElementIdentifier {
	
	protected void identify(NamedElement identifier, NamedElement possibleElement, Collection<IdentifiedElement> identifiedElements) {
		identify(identifier.getName(), possibleElement, identifiedElements);
	}

	private void identify(String identifier, NamedElement possibleElement, Collection<IdentifiedElement> identifiedElements) {
		final String possibleName = possibleElement.getName();
		if (possibleName != null && possibleName.equals(identifier)) {
			identifiedElements.add(new IdentifiedElement(possibleElement));
		}
	}
	
}

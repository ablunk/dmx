package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;

import hub.sam.dbl.NamedElement;

public abstract class NamedElementIdentifier {
	
	protected void addElementIfIdentifierIsMatching(Collection<IdentifiedElement> identifiedElements, NamedElement possibleElement, NamedElement identifier) {
		addElementIfIdentifierIsMatching(identifiedElements, possibleElement, identifier.getName());
	}

	private void addElementIfIdentifierIsMatching(Collection<IdentifiedElement> identifiedElements, NamedElement possibleElement, String identifier) {
		final String possibleName = possibleElement.getName();
		if (possibleName != null && possibleName.equals(identifier)) {
			identifiedElements.add(new IdentifiedElement(possibleElement));
		}
	}

}

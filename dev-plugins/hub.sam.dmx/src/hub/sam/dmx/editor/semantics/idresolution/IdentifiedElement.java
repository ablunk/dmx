package hub.sam.dmx.editor.semantics.idresolution;

import hub.sam.dbl.Model;
import hub.sam.dbl.NamedElement;

public class IdentifiedElement {
	
	private final NamedElement namedElement;
	
	public IdentifiedElement(NamedElement identifiedElement) {
		this.namedElement = identifiedElement;
	}

	public NamedElement getIdentifiedElement() {
		return namedElement;
	}

	public Object getIdentitiy(Model model) {
		return getQualifiedId(model);
	}
	
	private String getQualifiedId(Model model) {
		if (namedElement.eResource() == null || namedElement.eResource().getURI() == null || namedElement.eResource() == model.eResource()) {
			return namedElement.eResource().getURIFragment(namedElement);
		} else {
			return namedElement.eResource().getURI() + namedElement.eResource().getURIFragment(namedElement);
		}
	}
	
}

package hub.sam.dmx.editor.semantics.idresolution;

import java.util.logging.Logger;

import hub.sam.dbl.Model;
import hub.sam.dbl.NamedElement;

public class IdentifiedElement {
	
	private static final Logger LOGGER = Logger.getLogger(IdentifiedElement.class.getName());

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
		if (namedElement.eResource() == null) {
			LOGGER.warning("identified element is not contained in a resource.");
			return null;
		}
		
		if (namedElement.eResource() == null || namedElement.eResource().getURI() == null 
				|| model != null && namedElement.eResource() == model.eResource()) {
			return namedElement.eResource().getURIFragment(namedElement);
		} else {
			return namedElement.eResource().getURI() + namedElement.eResource().getURIFragment(namedElement);
		}
	}
	
	@Override
	public String toString() {
		return "IdentifiedElement [namedElement.name=" + namedElement.getName() + "]";
	}
	
}

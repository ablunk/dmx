package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.HashSet;

import hub.sam.dbl.IdExpr;
import hub.sam.dbl.Module;
import hub.sam.dbl.NamedElement;

public class TypeResolver extends NamedElementIdentifier implements ElementResolver<IdExpr> {

	private Collection<IdentifiedElement> identifiedTypes = new HashSet<>();

	@Override
	public Collection<IdentifiedElement> resolvePossibleElements(NamedElement identifier, IdExpr context) {
		
		Containment.getContainerObjectOfType(context, Module.class)
			.ifPresent(module -> addClasses(module, identifier));
	
		return identifiedTypes;
	}
	
	private void addClasses(Module module, NamedElement identifier) {
		module.getClasses().stream()
			.forEach(dblClass -> addElementIfIdentifierIsMatching(identifiedTypes, dblClass, identifier));
	}

}

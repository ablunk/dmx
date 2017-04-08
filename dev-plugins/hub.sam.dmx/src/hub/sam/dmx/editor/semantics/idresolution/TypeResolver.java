package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.Module;
import hub.sam.dbl.NamedElement;

public class TypeResolver extends NamedElementResolver implements ElementResolver<IdExpr> {

	@Override
	public Collection<IdentifiedElement> resolvePossibleElements(String identifier, IdExpr context) {
		Collection<IdentifiedElement> identifiedTypes = identifyInContainer(identifier, context, 
				Module.class, DblPackage.Literals.MODULE__CLASSES);
		identifiedTypes.addAll(identifyInContainer(identifier, context, 
				Module.class, DblPackage.Literals.MODULE__INTERFACES));
		return identifiedTypes;
	}
	
}

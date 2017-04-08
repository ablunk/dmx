package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.Module;
import hub.sam.dbl.NamedElement;

public class TypeResolver extends HierarchicalResolver implements ElementResolver<IdExpr> {

	@Override
	public Collection<IdentifiedElement> resolve(String identifier, IdExpr context) {
		Collection<IdentifiedElement> types = resolveInContainer(identifier, context, 
				Module.class, DblPackage.Literals.MODULE__CLASSES);
		types.addAll(resolveInContainer(identifier, context, 
				Module.class, DblPackage.Literals.MODULE__INTERFACES));
		return types;
	}
	
}

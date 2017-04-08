package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.Module;
import hub.sam.dbl.NamedElement;

public class GlobalVariableResolver extends NamedElementResolver implements ElementResolver<IdExpr> {
	
	@Override
	public Collection<IdentifiedElement> resolvePossibleElements(String identifier, IdExpr idExprContext) {
		return resolveInContainer(identifier, idExprContext, Module.class, DblPackage.Literals.MODULE__VARIABLES);
	}

}

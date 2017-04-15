package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.Module;

public class GlobalVariableResolver extends HierarchicalResolver implements ElementResolver<IdExpr> {
	
	@Override
	public Collection<IdentifiedElement> resolve(String identifier, IdExpr idExprContext) {
		return resolveInContainer(identifier, idExprContext, Module.class, DblPackage.Literals.MODULE__VARIABLES);
	}

}

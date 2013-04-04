package hub.sam.dmx;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.AbstractPropertySemantics;
import hub.sam.tef.semantics.IPropertyCreationSemantics;
import hub.sam.tef.tsl.CompositeBinding;

public class DblPropertyCreationSemantics extends
		AbstractPropertySemantics implements IPropertyCreationSemantics {

	@Override
	public void addValue(ParseTreeNode parseTreeNode, Object actual,
			Object value, IModelCreatingContext context,
			CompositeBinding binding) throws ModelCreatingException {
		System.out.println("addValue");
	}

}

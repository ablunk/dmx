package hub.sam.dmx.editor.semantics;

import hub.sam.dmx.editor.modelcreation.DblModelCreationContext;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.AbstractPropertySemantics;
import hub.sam.tef.semantics.Error;
import hub.sam.tef.semantics.IPropertyCreationSemantics;
import hub.sam.tef.tsl.CompositeBinding;

public class DblMetaModelReferenceSemantics extends
		AbstractPropertySemantics implements IPropertyCreationSemantics {

	@Override
	public void addValue(ParseTreeNode parseTreeNode, Object actual, Object value, IModelCreatingContext context, CompositeBinding binding)
			throws ModelCreatingException
	{
		if (!value.equals("")) {
			try {
				DblModelCreationContext.ecoreModelManager.ecoreModel.loadModel((String)value);
//				((IdResolution)actual).setMetaModelPlatformURI((String)value);
			}
			catch (Exception ex) {
				context.addError(new Error(parseTreeNode.getPosition(), "Cannot load ecore file: " + 
						ex.getLocalizedMessage()));
			}
		}
	}

}

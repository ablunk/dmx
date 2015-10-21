package hub.sam.dbl;

import org.eclipse.emf.ecore.impl.EObjectImpl;

public class DblEObjectImpl extends EObjectImpl implements DblEObject {

	@Override
	public void accept(DblElementVisitor visitor) {
		// nothing, accept not overriden by specific element
	}

}

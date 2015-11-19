package hub.sam.dbl;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;

public class DblEObjectImpl extends EObjectImpl implements DblEObject {

	@Override
	public void accept(DblElementVisitor visitor) {
		// nothing
	}

	@Override
	public String getURI() {
		Resource resource = this.eResource();
		if (resource != null) {
			return resource.getURIFragment(this);
		}
		throw new RuntimeException("Cannot return URI for EObject " + this + " because it is not contained in a Resource.");
	}

}

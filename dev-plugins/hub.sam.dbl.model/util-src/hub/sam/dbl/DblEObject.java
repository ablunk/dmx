package hub.sam.dbl;

import org.eclipse.emf.ecore.EObject;

public interface DblEObject extends EObject {
	void accept(DblElementVisitor visitor);
}

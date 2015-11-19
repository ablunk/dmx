package hub.sam.dmx.modelcreation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Position;

public interface IObjectPositionsContainer {
	Position getPosition(EObject eObject);
	void setPosition(EObject eObject, Position position);
}

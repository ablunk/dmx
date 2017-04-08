package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;

public class Containment {

	public static <T> Optional<T> getContainerObject(EObject object, java.lang.Class<T> type) {
		if (type.isAssignableFrom(object.getClass())) {
			return Optional.of((T) object);
		} else if (object.eContainer() == null) {
			return Optional.empty();
		} else {
			return getContainerObject(object.eContainer(), type);
		}
	}

}

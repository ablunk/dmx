package hub.sam.dmx.javasim.jist;

import jist.runtime.Controller;
import jist.runtime.Entity;

public class GlobalSimulationPrimitives {

	public static GenericEntity getActiveEntity() {
		Entity activeEntity = Controller.getActiveController().getEntity(Controller.getTHIS().getIndex());
		Object entityRef = activeEntity._jistMethod_Get__ref();
		return (GenericEntity) entityRef;
	}
	
}

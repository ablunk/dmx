import hub.sam.dmx.javasim.jist.GenericEntity;
import hub.sam.dmx.javasim.jist.IProcess;
import jist.runtime.JistAPI;
import jist.runtime.JistAPI.Timeless;
import hub.sam.dmx.javasim.jist.GlobalSimulationPrimitives;

public class Counter implements Timeless, IProcess {
	private GenericEntity _internal_entity;

	public GenericEntity getEntity() {
		return _internal_entity;
	}

	public GenericEntity getActiveEntity() {
		return _internal_entity;
	}

	public Counter() {
		this._internal_entity = new GenericEntity(this);
	}

	public void actions() {
		while ((Switch.count > 0L)) {
			Switch.count = (Switch.count - 1L);
			//Switch.log(("count = " + Switch.count));
			GlobalSimulationPrimitives.getActiveEntity().yield();
		}
	}
}

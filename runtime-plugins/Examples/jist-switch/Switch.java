//package hub.sam.dmx.extensions;
import hub.sam.dmx.javasim.jist.GenericEntity;
import hub.sam.dmx.javasim.jist.IProcess;
import jist.runtime.Controller;
import jist.runtime.JistAPI;
import jist.runtime.JistAPI.Timeless;
import hub.sam.dmx.javasim.jist.GlobalSimulationPrimitives;

public class Switch implements Timeless, IProcess {
	private GenericEntity _internal_entity;

	public Switch() {
		this._internal_entity = new GenericEntity(this);
	}

	public GenericEntity getEntity() {
		return _internal_entity;
	}

	public GenericEntity getActiveEntity() {
		return _internal_entity;
	}

	public static long count = 5L;

	public static void log(String msg) {
		System.out.print((((("pid-" + GlobalSimulationPrimitives
				.getActiveEntity()) + ": ") + msg) + "\n"));
	}

	public void actions() {
		Counter p = (new Counter());
		(p).getEntity().activate();
		System.out.print((("initial count = " + Switch.count) + "\n"));
		while ((Switch.count > 0L)) {
			Switch.count = (Switch.count - 1L);
			//Switch.log(("count = " + Switch.count));
			GlobalSimulationPrimitives.getActiveEntity().yield();
		}
		System.out.print((("final count = " + Switch.count) + "\n"));
		JistAPI.end();
	}

	public static void main(String[] args) {
		if (args.length > 0) {
			Switch.count = (new Long(args[0])).longValue();
		}
		Switch mainInstance = new Switch();
		mainInstance.getEntity().activate();
	}
}

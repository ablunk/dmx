import hub.sam.dmx.javasim.jist.GenericEntity;
import hub.sam.dmx.javasim.jist.IProcess;
import jist.runtime.Controller;
import jist.runtime.JistAPI;
import jist.runtime.JistAPI.Timeless;
import hub.sam.dmx.javasim.jist.GlobalSimulationPrimitives;

public class Tn_recursive implements Timeless, IProcess {
	private GenericEntity _internal_entity;

	public Tn_recursive() {
		this._internal_entity = new GenericEntity(this);
	}

	public GenericEntity getEntity() {
		return _internal_entity;
	}

	public GenericEntity getActiveEntity() {
		return _internal_entity;
	}

	public static long num = 5L;

	public static void log(String msg) {
		System.out.print((((("pid-" + GlobalSimulationPrimitives
				.getActiveEntity()) + ": ") + msg) + "\n"));
	}

	public static long tn(long n) {
		if ((n > 1L)) {
			//Tn_recursive.log(("n = " + n));
			return (n + Tn_recursive.tn((n - 1L)));
		} else {
			GlobalSimulationPrimitives.getActiveEntity().yield();
			return 1L;
		}
	}

	public void actions() {
		P p = (new P());
		(p).getEntity().activate();
		GlobalSimulationPrimitives.getActiveEntity().yield();
		//Tn_recursive.log("1st yield returns");
		GlobalSimulationPrimitives.getActiveEntity().yield();
		//Tn_recursive.log("2nd yield returns");
		JistAPI.end();
	}

	public static void main(String[] args) {
		if (args.length > 0) {
			Tn_recursive.num = (new Long(args[0])).longValue();
		}
		Tn_recursive mainInstance = new Tn_recursive();
		mainInstance.getEntity().activate();
	}
}

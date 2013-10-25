import hub.sam.dmx.javasim.jist.GenericEntity;
import hub.sam.dmx.javasim.jist.IProcess;
import jist.runtime.JistAPI;
import jist.runtime.JistAPI.Timeless;
import hub.sam.dmx.javasim.jist.GlobalSimulationPrimitives;

public class P implements Timeless, IProcess {
	private GenericEntity _internal_entity;

	public GenericEntity getEntity() {
		return _internal_entity;
	}

	public GenericEntity getActiveEntity() {
		return _internal_entity;
	}

	public P() {
		this._internal_entity = new GenericEntity(this);
	}

	public void actions() {
		long r = 0L;
		r = Tn_recursive.tn(Tn_recursive.num);
		System.out.print((((("tn(" + Tn_recursive.num) + ") = ") + r) + "\n"));
	}
}

package hub.sam.dmx.javasim.jist.example;

import hub.sam.dmx.javasim.jist.GenericEntity;
import hub.sam.dmx.javasim.jist.GlobalSimulationPrimitives;
import hub.sam.dmx.javasim.jist.IProcess;
import jist.runtime.Controller;
import jist.runtime.Entity;
import jist.runtime.JistAPI;
import jist.runtime.JistAPI.Timeless;

public class Counter implements Timeless, IProcess {

	private GenericEntity _internal_entity;	

	private int id;
	private int count = 0;
	private Counter otherCounter;
	private GenericEntity myEntity;
	
	public Counter(int id) {
		this._internal_entity = new GenericEntity(this);
		this.id = id;
	}
	
	private void log(String msg) {
		System.out.println(JistAPI.getTime() + ": (Counter-" + id + ") " + msg);
	}
	
	public void setOtherCounter(Counter otherCounter) {
		log("setOtherCounter");
		this.otherCounter = otherCounter;
	}
	
	public GenericEntity getEntity() {
		return _internal_entity;
	}
	
	public GenericEntity getMyEntity() {
		return myEntity;
	}
	
	public GenericEntity getActiveEntity() {
		return _internal_entity;
	}
	
	public void actions() {
		int limit = 6;
		while (count < limit) {
			count++;
			log("count=" + count);
			
			myEntity = _internal_entity; // equals "myEntity = ACTIVE;"
			Entity e = Controller.getActiveController().getEntity(Controller.getTHIS().getIndex());
			Object eref = e._jistMethod_Get__ref();
			GenericEntity ge = (GenericEntity) eref;
			myEntity = getActiveEntity();
			
			getEntity().advance(1); // equals "advance 1;"

			// reactivate other counter
			if (otherCounter != null) {
				log("reactivate other counter");
				otherCounter.getMyEntity().reactivate(); // equals "reactivate otherCounter;"
			}
			
			// wait
			log("wait");
			getEntity().simWait(); // equals "wait;"
			log("awakened, count="+count);
		}
	}

}

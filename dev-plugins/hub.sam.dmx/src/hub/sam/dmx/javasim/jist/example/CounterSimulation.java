package hub.sam.dmx.javasim.jist.example;

import jist.runtime.JistAPI;
import jist.runtime.JistAPI.Timeless;
import hub.sam.dmx.javasim.jist.GenericEntity;
import hub.sam.dmx.javasim.jist.GlobalSimulationPrimitives;
import hub.sam.dmx.javasim.jist.IProcess;

public class CounterSimulation implements Timeless, IProcess {
	
	private GenericEntity _internal_entity;
	
	public CounterSimulation() {
		this._internal_entity = new GenericEntity(this);
	}
	
	public GenericEntity getEntity() {
		return _internal_entity;
	}
	
	public GenericEntity getActiveEntity() {
		return _internal_entity;
	}
	
	public void actions() {
		Counter c1 = new Counter(1);
		Counter c2 = new Counter(2);
		
		c1.setOtherCounter(c2);
		c2.setOtherCounter(c1);
		
		c1.getEntity().activate(); // equals "activate c1;"
		c2.getEntity().activate();
		
		System.out.println(getActiveEntity());
		getActiveEntity().advance(3);
		System.out.println(JistAPI.getTime());
		
		JistAPI.end();
	}
	
	public static void main(String[] args) {
		CounterSimulation mainInstance = new CounterSimulation();
		//mainInstance.actions();
		mainInstance.getEntity().activate();
	}

}

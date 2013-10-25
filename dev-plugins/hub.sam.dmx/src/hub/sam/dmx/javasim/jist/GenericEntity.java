package hub.sam.dmx.javasim.jist;

import javax.management.RuntimeErrorException;

import jist.runtime.Controller;
import jist.runtime.Event;
import jist.runtime.JistAPI;
import jist.runtime.JistAPI.Continuation;
import jist.runtime.JistAPI.Entity;

public class GenericEntity implements Entity {
	
	private Event continuationEvent;
	private IProcess process;
	private final boolean logEnabled = false;
	
	public GenericEntity(IProcess process) {
		this.process = process;
	}
	
	private void log(String msg) {
		if (logEnabled) {
			System.out.println(JistAPI.getTime() + ": (" + process + ") " + msg);
		}
	}
	
	public void activate() {
		actions();
	}
	
	public void reactivate() {
		log("reactivate");
		
		if (continuationEvent != null && continuationEvent.waiting) {
			log("is waiting");

			if (continuationEvent.cont != null && continuationEvent.cont.caller != null) {
				log("cont present");
				Controller c = Controller.getActiveController();
				continuationEvent.time = c.getSimulationTime();
				continuationEvent.waiting = false;

				c.addEvent(continuationEvent.cont.caller);
				c.currentCaller = null;
				c.callbackState = null;
			}
		}
	}
	
	public void actions() {
		process.actions();
	}
	
	public void yield() throws Continuation {
		log("yield");
		
		Controller c = Controller.getActiveController();
		continuationEvent = c.getCurrentEvent();
		continuationEvent.time = c.getSimulationTime();
		continuationEvent.waiting = false;

		c.addEvent(continuationEvent.cont.caller);
		c.currentCaller = null;
		c.callbackState = null;
	}
	
	public void simWait() throws Continuation {
		log("simWait");
		Controller c = Controller.getActiveController();
		c.getCurrentEvent().waiting = true;
		continuationEvent = c.getCurrentEvent();
		JistAPI.sleepBlock(0);		
	}
	
	public void advance(long duration) throws Continuation {
		if ((long) duration != duration) {
			throw new RuntimeErrorException(new Error("Duration value '" + duration + "' is not supported. JiST can only be used with integer time steps."));
		}
		JistAPI.sleepBlock(duration);
	}

}

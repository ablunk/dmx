package hub.sam.dmx.javasim.desmoj.example;

import hub.sam.dmx.javasim.desmoj.DefaultSimulation;
import hub.sam.dmx.javasim.desmoj.SimulationProcess;

public class SimpleYield extends SimulationProcess {

	public SimpleYield() {
		super("SimpleProcess");
	}

	@Override
	public void base_actions() {
		System.out.println("time=" + base_time() + " -> " + base_active());
		DefaultSimulation.DEFAULT.getCurrentProcess().base_yield();
		System.out.println("time=" + base_time() + " -> " + base_active());
		base_advance(1);
		System.out.println("time=" + base_time() + " -> " + base_active());
	}

}

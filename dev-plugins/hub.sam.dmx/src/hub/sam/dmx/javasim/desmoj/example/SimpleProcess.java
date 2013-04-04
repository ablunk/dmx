package hub.sam.dmx.javasim.desmoj.example;

import hub.sam.dmx.javasim.desmoj.SimulationProcess;

public class SimpleProcess extends SimulationProcess {

	public SimpleProcess() {
		super("SimpleProcess");
	}

	@Override
	public void base_actions() {
		base_advance(1);
		System.out.println("time=" + base_time());
		System.out.println(base_active());
		SimpleProcess sp = new SimpleProcess();
		sp.base_activate();
	}

}

package hub.sam.dmx.javasim.desmoj;

import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.TimeSpan;

@SuppressWarnings("all")
public abstract class SimulationProcess extends SimProcess {
	
	public SimulationProcess(final String name) {
		this(DefaultSimulation.DEFAULT, name, DefaultSimulation.DEFAULT.showIntrace);
	}

	public SimulationProcess(final Model owner, final String name, final boolean showInTrace) {
		super(owner, name, showInTrace);
	}

	public void base_wait() {
		this.passivate();
	}

	public void base_reactivate() {
		TimeSpan _timeSpan = new TimeSpan(0);
		this.activate(_timeSpan);
	}

	public void base_activate() {
		this.base_reactivate();
	}

	public void base_advance(final double duration) {
		TimeSpan _timeSpan = new TimeSpan(duration);
		this.hold(_timeSpan);
	}

	public abstract void base_actions();

	public void lifeCycle() {
		base_actions();
	}

	public static double base_time() {
		return DefaultSimulation.DEFAULT.getPresentTime();
	}

	public static SimulationProcess base_active() {
		return DefaultSimulation.DEFAULT.getCurrentProcess();
	}

}

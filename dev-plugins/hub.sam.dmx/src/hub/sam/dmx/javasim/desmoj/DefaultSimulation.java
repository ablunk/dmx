package hub.sam.dmx.javasim.desmoj;

import java.util.Collection;
import java.util.HashSet;

import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.TimeInstant;

@SuppressWarnings("all")
public class DefaultSimulation extends Model {
	public static DefaultSimulation DEFAULT = new DefaultSimulation(false, false, false, false);

	public final boolean showInReport;
	public final boolean showIntrace;
	public final boolean showProgressBar;
	public final boolean writeHtmlOutputFiles;

	private final Experiment exp;
	private Collection<SimulationProcess> initialProcesses = new HashSet<SimulationProcess>();

	public DefaultSimulation(final boolean showInReport, final boolean showIntrace,
			final boolean showProgressBar, final boolean writeHtmlOutputFiles) {
		super(null, "DefaultSimulation", showInReport, showIntrace);
		this.showInReport = showInReport;
		this.showIntrace = showIntrace;
		this.showProgressBar = showProgressBar;
		this.writeHtmlOutputFiles = writeHtmlOutputFiles;
		Experiment _experiment = new Experiment("DefaultSimulation Experiment", writeHtmlOutputFiles);
		this.exp = _experiment;
		this.connectToExperiment(this.exp);
		this.exp.setShowProgressBar(showProgressBar);
	}
	
	public double getPresentTime() {
		return exp.getSimClock().getTime().getTimeAsDouble();
	}

	public String description() {
		return "DefaultSimulation";
	}

	public void doInitialSchedules() {
		for (SimulationProcess sp: initialProcesses) {
			sp.activate(new TimeInstant(0));
		}
	}
	
	public void addInitialProcess(SimulationProcess sp) {
		initialProcesses.add(sp);
	}
	
	public SimulationProcess getCurrentProcess() {
		return (SimulationProcess) exp.getScheduler().getCurrentSimProcess();
	}

	public void init() {
	}

	public void start(final int stopTime) {
		if (stopTime > 0) {
			TimeInstant _timeInstant = new TimeInstant(stopTime);
			TimeInstant stopTimeInstant = _timeInstant;
			TimeInstant _timeInstant_1 = new TimeInstant(0);
			this.exp.tracePeriod(_timeInstant_1, stopTimeInstant);
			this.exp.stop(stopTimeInstant);
		}
		this.exp.start();
		this.exp.report();
		this.exp.finish();
	}	

	public void start() {
		this.start(0);
	}
}

package desmo_j_sample;

import java.util.concurrent.TimeUnit;

import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.TimeInstant;

public class SampleModel extends Model {
	
	private SampleProcess sampleProcess;

	public SampleModel(boolean showInReport, boolean showIntrace) {
		super(null, "SampleModel", showInReport, showIntrace);
	}

	@Override
	public String description() {
		return "SampleModel Description";
	}

	// activate dynamic components
	@Override
	public void doInitialSchedules() {
		sampleProcess = new SampleProcess(getModel(), true);
		sampleProcess.activate(new TimeInstant(0));
	}

	// initialise static components
	@Override
	public void init() {
	}
	
	public static void main(String[] args) {
		// create model and experiment
		SampleModel sampleModel = new SampleModel(true, true);
		Experiment exp = new Experiment("SampleModel Experiment");
		sampleModel.connectToExperiment(exp);
	
		// set experiment parameters
		exp.setShowProgressBar(true);
//		TimeInstant stopTime = new TimeInstant(20, TimeUnit.MINUTES);
//		exp.tracePeriod(new TimeInstant(0), stopTime);
//		exp.stop(stopTime);

		// start experiment
		exp.start();

		// generate report and shut everything off
		exp.report();
		exp.finish();
	}

}

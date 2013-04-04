package desmo_j_sample;

import java.util.concurrent.TimeUnit;

import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.TimeSpan;

public class SampleProcess extends SimProcess {
	
	int count = 0;

	public SampleProcess(Model owner, boolean showInTrace) {
		super(owner, "SampleProcess", showInTrace);
	}
	
	@Override
	public void lifeCycle() {
		for (int i=0; i<5; i++) {
			hold(new TimeSpan(100, TimeUnit.SECONDS));
			System.out.println(getModel().presentTime() + ": count = " + i);
		}
	}

}

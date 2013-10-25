package hub.sam.dmx.javasim.desmoj.dist;

import hub.sam.dmx.javasim.desmoj.DefaultSimulation;

public class ExpDist extends desmoj.core.dist.ContDistExponential {

	public ExpDist(String name, double mean) {
		super(DefaultSimulation.DEFAULT, name, mean, DefaultSimulation.DEFAULT.showInReport,
				DefaultSimulation.DEFAULT.showIntrace);
	}

}

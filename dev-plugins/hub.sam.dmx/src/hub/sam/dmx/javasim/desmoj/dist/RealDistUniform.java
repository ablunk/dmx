package hub.sam.dmx.javasim.desmoj.dist;

import hub.sam.dmx.javasim.desmoj.DefaultSimulation;

public class RealDistUniform extends desmoj.core.dist.ContDistUniform {

	public RealDistUniform(String name, double lowerBorder, double upperBorder) {
		super(DefaultSimulation.DEFAULT, name, lowerBorder, upperBorder, DefaultSimulation.DEFAULT.showInReport,
				DefaultSimulation.DEFAULT.showIntrace);
	}

}

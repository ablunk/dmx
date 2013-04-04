package hub.sam.dmx.javasim.desmoj.dist;

import hub.sam.dmx.javasim.desmoj.DefaultSimulation;

public class IntDistUniform {
	
	private final desmoj.core.dist.IntDistUniform u;

	public IntDistUniform(String name, long minValue, long maxValue) {
		u = new desmoj.core.dist.IntDistUniform(DefaultSimulation.DEFAULT, name, minValue, maxValue, DefaultSimulation.DEFAULT.showInReport,
				DefaultSimulation.DEFAULT.showIntrace);
		
	}
	
	public long sample() {
		return u.sample();
	}

}

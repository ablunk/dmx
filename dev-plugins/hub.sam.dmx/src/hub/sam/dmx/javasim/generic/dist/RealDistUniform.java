package hub.sam.dmx.javasim.generic.dist;

import java.util.Random;

public class RealDistUniform {

	private final Random random = new Random();
	private final double min;
	private final double max;
	
	public RealDistUniform(String name, double min, double max) {
		this.min = min;
		this.max = max;
	}
	
	public double sample() {
		return (max - min) * random.nextDouble() + min;
	}
	
}

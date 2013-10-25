package hub.sam.dmx.javasim.generic.dist;

import java.util.Random;

public class ExpDist {

	private final Random random = new Random(979);
	private final double mean;
	
	public ExpDist(String name, double mean) {
		this.mean = mean;
	}
	
	public double sample() {
		return -java.lang.Math.log(1 - random.nextDouble()) * mean;
	}
	
}

package hub.sam.dmx.javasim.generic.dist;

import java.util.Random;

public class IntDistUniform {

	private final Random random = new Random();
	private final long min;
	private final long max;
	
	public IntDistUniform(String name, long min, long max) {
		this.min = min;
		this.max = max;
	}
	
	public long sample() {
		return random.nextInt((int) max - (int) min + 1) + min;
	}
	
}

package hub.sam.dmx.javasim.desmoj.example;

import hub.sam.dmx.javasim.desmoj.DefaultSimulation;

public class SimpleProcessSimulation {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		SimpleProcess sp = new SimpleProcess();
		DefaultSimulation.DEFAULT.addInitialProcess(sp);
		DefaultSimulation.DEFAULT.start(10);
		DefaultSimulation.DEFAULT.getExperiment().finish();
		long estimatedTime = System.nanoTime() - startTime;
		long ms = estimatedTime / (1000 * 1000);
		System.out.println("Execution time: " + ms / 1000.0 + " seconds");
	}

}

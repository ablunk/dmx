package hub.sam.dmx.javasim.desmoj.example;

import hub.sam.dmx.javasim.desmoj.DefaultSimulation;

public class SimpleYieldSimulation {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		SimpleYield sp1 = new SimpleYield();
		SimpleYield sp2 = new SimpleYield();
		DefaultSimulation.DEFAULT.addInitialProcess(sp1);
		DefaultSimulation.DEFAULT.addInitialProcess(sp2);
		DefaultSimulation.DEFAULT.start(10);
		DefaultSimulation.DEFAULT.getExperiment().finish();
		long estimatedTime = System.nanoTime() - startTime;
		long ms = estimatedTime / (1000 * 1000);
		System.out.println("Execution time: " + ms / 1000.0 + " seconds");
	}

}

package benchmarks.jistpro.contextswitch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaMainSwitch {
	public static void main(String[] args) {

		List<String> argsList = new ArrayList<String>();
		argsList.add(Switch.class.getName());
		argsList.addAll(Arrays.asList(args));

		hub.sam.dmx.javasim.jist.RunJistSimulation.main(argsList
				.toArray(new String[] {}));

		Runtime runtime = Runtime.getRuntime();
		long memory = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Memory Usage: " + memory / 1024.0 / 1024 + " MB");

		System.exit(0);
	}
}

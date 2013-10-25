import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



		//package hub.sam.dmx.extensions;

		public class JavaMainTnRecursive {
			public static void main(String[] args) {
				long startTime = System.nanoTime();
				


				List<String> argsList = new ArrayList<String>();
				argsList.add("Tn_recursive");
				argsList.addAll(Arrays.asList(args));

					hub.sam.dmx.javasim.jist.RunJistSimulation.main(argsList.toArray(new String[] {}));

				long estimatedTime = System.nanoTime() - startTime;
				long ms = estimatedTime / (1000 * 1000);
				System.out.println("Execution time: " + ms / 1000.0 + " seconds");

				Runtime runtime = Runtime.getRuntime();
				long memory = runtime.totalMemory() - runtime.freeMemory();
				System.out.println("Memory Usage: " +  memory/1024.0/1024 + " MB");

				System.exit(0);
			}
		}

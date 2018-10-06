package benchmarks.jistpro.contextswitch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import hub.sam.dmx.javasim.jist.GenericEntity;
import hub.sam.dmx.javasim.jist.IProcess;
import jist.runtime.Controller;
import jist.runtime.JistAPI;
import jist.runtime.JistAPI.Timeless;
import hub.sam.dmx.javasim.jist.GlobalSimulationPrimitives;

public class Switch implements Timeless, IProcess {
	private GenericEntity _internal_entity;

	public Switch() {
		this._internal_entity = new GenericEntity(this);
	}

	public GenericEntity getEntity() {
		return _internal_entity;
	}

	public GenericEntity getActiveEntity() {
		return _internal_entity;
	}

	public static int count = 5;

	public static void log(String msg) {
		System.out.print((((("pid-" + GlobalSimulationPrimitives
				.getActiveEntity()) + ": ") + msg) + "\n"));
	}

	public void actions() {
		Counter p = (new Counter());
		(p).getEntity().activate();
		
		int initialCount = Switch.count;
		System.out.print((("initial count: " + Switch.count) + "\n"));
		long startTime = System.nanoTime();
		while ((Switch.count > 0L)) {
			Switch.count = (Switch.count - 1);
			//Switch.log(("count = " + Switch.count));
			GlobalSimulationPrimitives.getActiveEntity().yield();
		}
		long endTime = System.nanoTime();		
		System.out.print((("final count: " + Switch.count) + "\n"));
		long estimatedTime = endTime - startTime;
		double s = estimatedTime / (1000.0 * 1000.0 * 1000.0);
		System.out.println("time [s]: " + s);

        try {
            File file = new File("output.log");
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write("initial count: " + initialCount + "\n");
            output.write("final count: " + Switch.count + "\n");
            output.write("time [s]: " + Double.toString(s) + "\n");
            output.close();
          }
          catch (IOException e) {
             e.printStackTrace();
          }

        JistAPI.end();
	}

	public static void main(String[] args) {
		if (args.length > 0) {
			Switch.count = (new Integer(args[0])).intValue();
		}
		Switch mainInstance = new Switch();
		mainInstance.getEntity().activate();
	}
}

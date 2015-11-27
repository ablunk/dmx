package hub.sam.dmx.debugger.debugmodel.example;

import hub.sam.dmx.debugger.ForeverTarget.MutableInteger;
import hub.sam.dmx.javasim.desmoj.DefaultSimulation;
import hub.sam.dmx.javasim.desmoj.SimulationProcess;
import desmoj.core.simulator.TimeSpan;

public class ForeverExample extends SimulationProcess {

	public ForeverExample(String name) {
		super(name);
	}
	
	@Override
	public void base_actions() {
		debug_startProcess("A", this);
		debug_startFrame("actions");
		while (true) {
			// forever-test.xmi#//@modules.0/@classes.0/@actionsBlock/@statements.0/@body/@statements.0
			
			debug_setCurrentPosition("../@actionsBlock/@statements.0/@body/@statements.0");
			debug_checkState();
			System.out.print(DefaultSimulation.DEFAULT.getPresentTime() + "\n");

			debug_setCurrentPosition("../@actionsBlock/@statements.0/@body/@statements.1");
			debug_checkState();
			hold(new TimeSpan(1));

			// bei einem step-into läuft das Programm immer bis zur nächsten Programmposition weiter
			debug_setCurrentPosition("../@actionsBlock/@statements.0/@body/@statements.2");
			debug_setCurrentAsReturnPosition();
			debug_setStepOverPositions(new String[] { "../@actionsBlock/@statements.0/@body/@statements.2/@trueCase" });
			debug_checkState();
			if (DefaultSimulation.DEFAULT.getPresentTime() > getEndTime()) {
				debug_setCurrentPosition("../@actionsBlock/@statements.0/@body/@statements.2/@trueCase");
				debug_checkState();
				break;
			}
		}
		debug_endFrame();
	}
	
	public int getEndTime() {
		debug_startFrame("getEndTime()");
		debug_setCurrentPosition("../@functions.0/@statements.0");
		debug_checkState();
		//int r = 3;
		MutableInteger r = new MutableInteger(3);
		debug_addFrameVariable("r", r, null);
		
		debug_setCurrentPosition("../@functions.0/@statements.1");
		debug_checkState();
		debug_removeFrameVariable("r");
		debug_endFrame();
		
		return r.getValue();
	}
	
}

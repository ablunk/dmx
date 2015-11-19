package hub.sam.dmx.debugger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import desmoj.core.simulator.TimeSpan;
import hub.sam.dmx.javasim.desmoj.DefaultSimulation;
import hub.sam.dmx.javasim.desmoj.SimulationProcess;

public class ForeverTarget {
	
	public static class DblProcess {
		public Thread thread; // optional mit einem Java-Thread verbunden
	}
	
	// Info zu laufenden Prozessen, als Key dient der eindeutig vergebene Thread-Name
	public static Map<String, DblProcess> processes = new HashMap<>();
	
	public static class A extends SimulationProcess {
		
		public A(String name) {
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
	
	// fügt im aktuellen Frame eine Variable hinzu, deren Wert mit Hilfe des Target-Debuggers erfragt wird
	static void debug_addFrameVariable(String name, Object value, String transformatorFunctionName) {
		// mit einer Transformator-Funktion kann der Wert auf Basis anderer Wert berechnet werden
	}

	static void debug_removeFrameVariable(String name) {
		
	}

	static void debug_startFrame(String label) {
		
	}

	static void debug_endFrame() {
		
	}

	static void debug_startProcess(String label, Object processObject) {
		
	}
	
	static void debug_setCurrentPosition(String eObjectUri_current) {
		// Positionen an Editor/Debugger übertragen
		// an dieser Stelle wird mit dem Zielsprachen-Debugger ein Breakpoint gesetzt
		// dann wird der Wert eObjectUri_current ausgelesen
	}

	static void debug_setStepOverPositions(String[] eObjectUris_stepOver) {
		// Positionen an Editor/Debugger übertragen
	}

	static void debug_setCurrentAsReturnPosition() {
		
	}
	
	static void debug_checkState() {
		// kommuniziere mit Eclipse Debugger, und entscheidet ob wirklich gehalten wird
	}
	
	public static class MutableInteger {
		private int value;
		public MutableInteger(int value) {
			this.value = value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		public String valueAsString() {
			return Integer.toString(value);
		}
	}
	
	public static void change(MutableInteger i) {
		i.setValue(i.getValue() + 1);
	}
	
	public static void main(String[] args) {
		MutableInteger i = new MutableInteger(1);
		change(i);
		System.out.println(i.getValue());
	}

}

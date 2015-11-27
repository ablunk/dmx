package hub.sam.dmx.debugger.debugmodel;

public class DblDebugger {
	
	public final static DblDebugger instance = new DblDebugger();
	
	// fügt im aktuellen Frame eine Variable hinzu, deren Wert mit Hilfe des Target-Debuggers erfragt wird
	void debug_addFrameVariable(String name, Object value, String transformatorFunctionName) {
		// mit einer Transformator-Funktion kann der Wert auf Basis anderer Wert berechnet werden
	}

	void debug_removeFrameVariable(String name) {
		
	}

	void debug_startFrame(String label) {
		
	}

	void debug_endFrame() {
		
	}

	void debug_startProcess(String label, Object processObject) {
		
	}
	
	void debug_setCurrentPosition(String eObjectUri_current) {
		// Positionen an Editor/Debugger übertragen
		// an dieser Stelle wird mit dem Zielsprachen-Debugger ein Breakpoint gesetzt
		// dann wird der Wert eObjectUri_current ausgelesen
	}

	void debug_setStepOverPositions(String[] eObjectUris_stepOver) {
		// Positionen an Editor/Debugger übertragen
	}

	void debug_setCurrentAsReturnPosition() {
		
	}
	
	void debug_checkState() {
		// kommuniziere mit Eclipse Debugger, und entscheidet ob wirklich gehalten wird
	}
}

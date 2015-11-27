package hub.sam.dmx.debugger.debugmodel;

import java.util.List;

public class ExecutionState extends NamedElement {
	private String kindName;
	private String currentPosition;

	private List<VariableState> visibleVariables;
	private List<ExecutionState> subStates;
	
	public ExecutionState(String name) {
		setName(name);
	}
	
	public ExecutionState addSubState(String name) {
		ExecutionState s = new ExecutionState(name);
		subStates.add(s);
		return s;
	}
	
	public void removeSubState(ExecutionState s) {
		subStates.remove(s);
	}
	
	public void setPosition(String position) {
		
	}
}

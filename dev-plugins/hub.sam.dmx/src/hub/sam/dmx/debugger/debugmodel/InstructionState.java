package hub.sam.dmx.debugger.debugmodel;

import java.util.List;

public class InstructionState extends NamedElement {
	private List<VariableState> variables;
	private String currentInstructionId;
	private List<InstructionState> ownedStates;
}

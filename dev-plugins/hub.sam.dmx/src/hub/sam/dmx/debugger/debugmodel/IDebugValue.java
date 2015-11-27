package hub.sam.dmx.debugger.debugmodel;

import java.util.List;

public interface IDebugValue {
	String valueAsString();
	List<VariableState> getVisibleChildVariables();
}

package hub.sam.dmx.debugger.debugmodel;

import java.util.List;

public class MutableInt implements IMutablePrimitive {
	
	private int value;
	
	public MutableInt(int value) {
		this.value = value;
	}

	@Override
	public String valueAsString() {
		return Integer.toString(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public List<VariableState> getVisibleChildVariables() {
		return null;
	}

}

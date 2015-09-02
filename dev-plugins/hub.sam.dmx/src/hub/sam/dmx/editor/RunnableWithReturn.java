package hub.sam.dmx.editor;

public class RunnableWithReturn<V> implements Runnable {

	private V result;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
	
	protected void setResult(V value) {
		result = value;
	}
	
	public V getResult() {
		return result;
	}

}

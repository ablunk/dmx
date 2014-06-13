package hub.sam.dmx.javasim;

public class DblComparable implements Comparable<Object> {

	@Override
	public int compareTo(Object arg0) {
		return (int) dblCompareTo(arg0);
	}

	public long dblCompareTo(Object arg0) {
		return -2;
	}

}

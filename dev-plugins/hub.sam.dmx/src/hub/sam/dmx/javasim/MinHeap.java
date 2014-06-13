package hub.sam.dmx.javasim;

import java.util.PriorityQueue;

public class MinHeap {
	private PriorityQueue<Object> pq = new PriorityQueue<Object>();
	
	public void insert(Object o) {
		pq.add(o);
	}
	
	public Object pick() {
		return pq.poll();
	}
	
	public int size() {
		return pq.size();
	}
	
	public void clear() {
		pq.clear();
	}
	
}

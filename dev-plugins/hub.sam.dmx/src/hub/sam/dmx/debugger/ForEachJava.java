package hub.sam.dmx.debugger;

import java.util.ArrayList;
import java.util.List;

public class ForEachJava {
	
	public static class _debugHide_TargetProcess {
		
	}
	
	public static class A extends _debugHide_TargetProcess {
		int i;
		static int _debugHide_internalOffset = 4;
		
		public A(int i) {
			this.i = i + _debugHide_internalOffset;
		}
		
		public String _debug_get_i() {
			return "i: " + Integer.toString(i);
		}
		
	}

	public static List as = new ArrayList();
	
	public static void main(String[] args) {
		as.add(new A(1));
		as.add(new A(2));
		as.add(new A(3));
		
		for (Object o: as) {
			A a = (A) o;
			System.out.print(a.i + "\n");
		}
	}

}

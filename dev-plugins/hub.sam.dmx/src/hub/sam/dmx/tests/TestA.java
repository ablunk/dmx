package hub.sam.dmx.tests;

public class TestA {

		public static class A {
			static int count=0;
			int id;
			public A() {
				count++;
				id=count;
			}
			
			public void p() {
				System.out.println(id);
			}
		}
		
		public static class Class {
			public Class(int i) {}
			int _class;
		}
		
		public static void main(String[] args) {
			for (int i=0; i<3; i++) {
				A a = new A();
				a.p();
			}
		}
}

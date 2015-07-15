package hub.sam.dmx.tests;

public class TestR {

	public static class A {
		public int i = 1;
	}

	public static class B extends A {
		public int i = 2;

		void m() {
			System.out.println(i);
			System.out.println(super.i);
			A a = this;
			System.out.println(a.i);
		}
	}

	public static void main(String[] args) {
		B b = new B();
		b.m();
	}

}

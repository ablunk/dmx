

public class Example {

	public static class StateMachine {
		protected State currentState;
		
		public State processEvent(int event) {
			currentState = currentState.nextState(event);
			return currentState;
		}

		public abstract class State {
			public abstract State nextState(int event);
		}
	}
	
	public static void main(String[] args) {
		Counter counter = new Counter();
		counter.processEvent(Counter.START_EVENT);
		counter.processEvent(Counter.TICK_EVENT);
		counter.processEvent(Counter.TICK_EVENT);
	}
	
	public static class Counter extends StateMachine {

		public static final int START_EVENT = 1;
		public static final int PAUSE_EVENT = 2;
		public static final int RESUME_EVENT = 3;
		public static final int TICK_EVENT = 4;
		
		private A a = new A();
		private B b = new B();
		
		int i;
		
		public Counter() {
			currentState = a;
		}
		
		public class A extends State {
			public State nextState(int event) {
				switch (event) {
				case START_EVENT:
					i = 0;
					return b;
				case RESUME_EVENT:
					return b;
				default:
					throw new IllegalArgumentException("Event unknown.");
				}
			}
		}

		public class B extends State {
			public State nextState(int event) {
				switch (event) {
				case TICK_EVENT:
					i++;
					System.out.println("Tick " + i);
					if (i >= 10) return null;
					else return b;
				case PAUSE_EVENT:
					return a;
				default:
					throw new IllegalArgumentException("Event unknown.");
				}
			}
		}

	}
	
	
}

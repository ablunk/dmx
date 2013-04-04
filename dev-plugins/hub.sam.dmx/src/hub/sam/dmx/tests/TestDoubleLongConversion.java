package hub.sam.dmx.tests;

public class TestDoubleLongConversion {

	public static void main(String[] args) {
		double[] ds = {1.0/4, 1, 2, 0.75, 1.0/3};
		
		for (double x: ds) {
			Double d = new Double(x);
			Double dl = new Double(d.longValue());
			System.out.println(x);
			System.out.println((long) x == x);
			System.out.println("------");
		}
	}

}

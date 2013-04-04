package hub.sam.dmx;

public class ExprTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 0;
		
		System.out.println( i == 1 ? true : (false ? 1 : 0));
		
		i=0;
		System.out.println(i + 2*(i++ + i));

		if (true) {
			int j=0;
		}
	}

}

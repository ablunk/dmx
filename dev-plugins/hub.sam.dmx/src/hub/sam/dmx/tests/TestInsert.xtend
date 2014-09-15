package hub.sam.dmx.tests

class TestInsert {
	
	def public static void main(String[] args) {
		val sb = new StringBuffer("e1 e2 e3")
		
		val start = 0 + 2;
		sb.insert(start,"eX")
		print(sb.toString)
	}
}
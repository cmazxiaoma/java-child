public class TestFinal {
	final Aclass aclass = new Aclass();

	public static void main(String[] args) {
		TestFinal test = new TestFinal();
		test.aclass.setA(6666);
		System.out.println(test.aclass.getA());

	}

	class Aclass {
		private int a;

		public Aclass() {
			a = 100;
		}

		public void setA(int a) {
			this.a = a;
		}

		public int getA() {
			return a;
		}
	}
}

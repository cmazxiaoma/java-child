
public class test {
	static String message = "xiaoma";

	public static void main(String[] args) {
		test te = new test();
		te.startThread();

	}

	public void startThread() {
		TestThread t = new TestThread(message);
		t.start();
	}

}

class TestThread extends Thread {
	String message = "xiaoma";

	public TestThread(String message) {
		this.message = message;

	}

	public void run() {

		for (int i = 0; i < 6; i++) {

			if (message.equals("xiaoma1")) {
				System.out.println("xx");
			}
			System.out.println(i);
		}

		System.out.println("循环结束");

		/*
		 * while(true){ if(message.equals("xiaoma")){ for(int i=0;i<7;i++){
		 * 
		 * if(i==5){ System.out.println("五月天"); return; }
		 * 
		 * System.out.println("xixi1");
		 * 
		 * } System.out.println("xixi2"); } System.out.println("xixi3"); }
		 */
	}

}
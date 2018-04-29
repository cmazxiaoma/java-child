
public class ThreadState {
	public static void main(String[] args) {
		TestThreadState test = new TestThreadState();
		new Thread(test).start();
	}

}

class TestThreadState implements Runnable {
	public void run() {
		for (int i = 0; i < 30; i++) {
			if (i != 0 && i % 10 == 0) {
				try {
					System.out.println("Before sleeping:" + Thread.currentThread().isAlive());
					Thread.sleep(2000);
					System.out.println("After sleeping:" + Thread.currentThread().isAlive());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("No." + i);
		}
	}
}

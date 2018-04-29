
public class RunnableThread implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Count:" + i);
		}
	}

	public static void main(String[] args) {
		RunnableThread rt = new RunnableThread();
		Thread thread = new Thread(rt);
		thread.start();
	}

}


public class TestSafeStack {
	public static void main(String[] args) {
		SafeStack s = new SafeStack();
		new Thread(new PushThread(s)).start();
		new Thread(new PopThread(s)).start();
	}
}

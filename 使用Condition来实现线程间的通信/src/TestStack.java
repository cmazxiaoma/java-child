import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestStack {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition con = lock.newCondition();
		SafeStack s = new SafeStack(lock, con);
		new Thread(new PushThread(s)).start();
		new Thread(new PopThread(s)).start();

	}

}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest1 {

	public static void main(String[] args) {
		// 创建并发访问的信用卡账户
		CreditCardAccount myCard = new CreditCardAccount("6217-0028-7002-9811-211", 0);
		// 创建一个锁对象
		Lock lock = new ReentrantLock();
		// 创建一个线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		Operation1 o1 = new Operation1("atm001", myCard, -4000, lock, 2);
		Operation1 o2 = new Operation1("atm002", myCard, 6000, lock, 1);
		Operation1 o3 = new Operation1("atm003", myCard, 800, lock, 1);
		Operation1 o4 = new Operation1("atm003", myCard, 800, lock, 1);
		Operation1 o5 = new Operation1("atm003", myCard, 0, lock, 3);
		pool.execute(o1);
		pool.execute(o2);
		pool.execute(o3);
		pool.execute(o4);
		pool.execute(o5);
		pool.shutdown();
	}

}

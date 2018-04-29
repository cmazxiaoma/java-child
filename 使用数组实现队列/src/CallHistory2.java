
public class CallHistory2 {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue(20);
		queue.enqueue("xiaoma 17:50");
		queue.enqueue("wutao  19:50");
		queue.enqueue("mayday 23:30");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}

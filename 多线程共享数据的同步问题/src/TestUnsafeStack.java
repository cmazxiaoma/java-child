
public class TestUnsafeStack {
	public static void main(String[] args){
		UnsafeStack s=new UnsafeStack();
		s.push(1);
		s.push(2);
		new Thread(new PushThread(s),"PushThread").start();
		new Thread(new PopThread(s),"PopThread").start();
	}
}

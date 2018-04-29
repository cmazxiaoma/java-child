
public class PopThread implements Runnable{
	private StackInterface s;
	
	public PopThread(StackInterface s){
		this.s=s;
	}
	
	public void run(){
		s.pop();       
	}
}

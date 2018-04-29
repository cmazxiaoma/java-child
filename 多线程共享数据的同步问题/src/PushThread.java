
public class PushThread implements Runnable{
	private StackInterface s;
	public PushThread(StackInterface s){
		this.s=s;
	}
	
	public void run(){
		for(int i=0;i<3;i++){
			System.out.println(".");
		}
		
		int k=15;
		s.push(k);
	}

}

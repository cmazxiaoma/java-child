
public class MultiThread {
	public static void main(String[] args){
		RunningObject ro=new RunningObject();
		new Thread(ro,"thread1").start();
		new Thread(ro,"thread2").start();
	}

}

class RunningObject implements Runnable{
	public void run(){
		for(int i=0;i<20;i++){
			String name=Thread.currentThread().getName();
			Long id=Thread.currentThread().getId();
			System.out.println("name="+name+",id="+id+", i="+i);
		}
	}
}

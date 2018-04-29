import java.util.Timer;
import java.util.TimerTask;


public class TimerWork{
	public static void main(String[] args){
		Timer tmr=new Timer();
		tmr.schedule(new TimerPrinter(),0,2000);
	}

}

class TimerPrinter extends TimerTask{
	int i=0;
	public void run(){
		System.out.println("No. "+i++);
	}
}

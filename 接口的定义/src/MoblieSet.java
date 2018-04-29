
public class MoblieSet implements Setting{
	private int brightness;
	private int volume;
	
	public MoblieSet(){
		this.brightness=DEFAULT_BRIGHTNESS;
		this.volume=DEFAULT_VOLUME;
	}
	
	//实现ScreenBrightness中的方法
	public void brightUp(){
		this.brightness++;
		System.out.println("brightness="+this.brightness);
	} 
	
	public void brightDown(){
		this.brightness--;
	}

	
	//实现Volume中的方法
	public void volumeUp(){
		this.volume++;
		System.out.println("volume="+this.volume);
		
	}
	
	public void volumeDown(){
		this.volume--;
	}
	
	
	//实现Setting中的方法
	public void showData(){
		System.out.println("接口的扩展，用于显示数据");
	}
	
	public static void main(String[] args){
		MoblieSet mb=new MoblieSet();
		mb.brightUp();
		mb.volumeUp();
		mb.showData();
	}
}

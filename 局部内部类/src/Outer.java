
public class Outer {
	public void test(int i){
		class LocalClass{
			public void localTest(){
				System.out.println("局部内部类的方法被调用");
			}
		}
		
		LocalClass lc=new LocalClass();
		lc.localTest();
	}
	
	public static void main(String[] args){
		Outer o=new Outer();
		o.test(6666);
	}
 
}

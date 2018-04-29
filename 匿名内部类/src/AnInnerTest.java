
public class AnInnerTest {
	
	
	//我们首先定义一个接口
	interface AnInfc{
		public void printInfo();
	}

	
	public AnInfc testAn(){
		return new AnInfc(){
			public void printInfo(){
				System.out.println("实现接口的匿名类");
			}
		};
	}
	
	public static void main(String[] args){
		AnInnerTest a=new AnInnerTest();
		AnInfc af=a.testAn();
		af.printInfo();
	}
}

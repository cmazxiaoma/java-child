public class test {
	
	public static void main(String[] args){
		A a=new A();
		a.f(new Show(){
			public void show(){
				System.out.println("这是实现了接口的匿名类");
			}
		});
	}

}

interface Show{
	public void show();
}

class A{
    public void f(Show s){
	s.show();
    }
}
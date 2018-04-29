public class Outer {
	private int a=5;
	//定义一个内部类,名为"Inner"
	private  class Inner{
		//内部类可以有私有属性
		private int i=1;
		
		public void innerMethod(){
			System.out.println("a="+a+", i="+i);
		}
	}
	
	public static void main(String args[]){
		Outer.Inner in=new Outer().new Inner();
		in.innerMethod();
		
	}
}
	


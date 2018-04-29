public class test2 {
	interface AnInfc{
		public void printInfo();
	}

	
	public static void main(String args[]){
		//p是匿名类的上转型对象                                                                                                
		Person p=new Person("xiaoma"){ //new Person()就是匿名类
			public void printInfo(){
				System.out.println("name:"+this.getName());
			}
		};
		
		//调用该抽象方法
		p.printInfo();
		
	}
}


abstract class Person{
	private String name;
	public Person(String name){
		this.name=name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String  getName(){
		return name;
	}
	
	public abstract void printInfo();
}

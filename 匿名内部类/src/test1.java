
public class test1 {
	public static void main(String[] args){
		Teachter t=new Teachter();
		t.look(new Student(){
			public void speak(){
				System.out.println("匿名类实现了抽象父类中的抽象方法");
			}
		});
	}

}

abstract class Student{
	public abstract void speak();
}

class Teachter{
	void look(Student s){
		
		//执行匿名类实现 (抽象父类)中的抽象方法
		s.speak();
	}
}



/*与继承有关的多态性是指父类的某个实列方法被其子类重写时,可以各自产生自己的功能行为
 * 是指同一个操作被不同类型的对象调用时可以产生不同的行为
 * **/

class Animal{
	void cry(){};
}

class Dog extends Animal{
	void cry(){
		System.out.println("wang,wang,wang");
	}
}

class cat extends Animal{
	void cry(){
		System.out.println("miao,miao,miao");
	}
}
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Dog().cry();
		new cat().cry();

	}

}

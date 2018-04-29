class A{
	double n;
	int m;
	void f(){
		System.out.printf("子类继承方法f(),n=%f,m=%d\n",n,m);
	}
	void g(){
		System.out.printf("您好,n=%f,m=%d\n",n,m);
	}
}

class B extends A{
	int n=12;
	void g(){
		System.out.printf("子类重写方法g(),n=%d,m=%d\n",n,m);
	}
	void cry(){
		System.out.printf("子类新增的方法,n=%d,m=%d\n",n,m);
	}
}


public class test {
	public static void main(String args[]){
		A a;
		a=new B();//a是子类对象的上转型对象
		a.n=0.88;
		a.m=200;
		a.f();
		a.g();
		//a.cry();是违法的
		B b=(B)a;
		b.cry();
		
	}

}



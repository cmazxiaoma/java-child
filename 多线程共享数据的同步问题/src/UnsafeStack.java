
public class UnsafeStack implements StackInterface{
	private  int top=0;
	private  int[] values=new int[10];
	
	public void push(int n){
		synchronized(this){
			System.out.println(Thread.currentThread().getName());
			values[top]=n;
			System.out.println("压入数字"+n+"步骤1完成");
			top++;
			System.out.println("压入数字完成");
		}
	}
	
	
	public void pop(){
		synchronized(this){
			System.out.println(Thread.currentThread().getName());
			System.out.println("弹出");
			top--;
			System.out.println("出栈成功  下标="+top+",数字="+values[top]);
		}
	}
}

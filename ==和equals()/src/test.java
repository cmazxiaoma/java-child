
public class test {
	public static void main(String args[]){
		String string3=new String("aaa");
		String string4=new String("aaa");
		if(string3==string4){
			System.out.println("string3==string4 true");
		}else{
			System.out.println("string3==string4 false");
		}
		
		if(string3.equals(string4)){
			System.out.println("string3.equals(string4) true");
		}else{
			System.out.println("string3.equals(string4) false");
		}
	}
}

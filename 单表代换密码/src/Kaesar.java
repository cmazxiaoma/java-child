
public abstract class Kaesar implements ICaesar{
	public String table="";

	public Kaesar(String table) {
		this.table = table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	@Override
	public String encrypt(String text,int num) {
		// TODO Auto-generated method stub
		return encryptText(text,num);
	}

	@Override
	public String decrypt(String text,int num) {
		// TODO Auto-generated method stub
		num=table.length()-(num%table.length());
		return encryptText(text,num);
	}
	
	
	@Override
	public String crack(String text) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=26;i++){
			System.out.println("进行了这一步");
			sb.append(encryptText(text,i));
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public abstract String encryptText(String text,int num);
	
}

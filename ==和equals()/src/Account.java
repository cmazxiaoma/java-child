
class Account {
	private  String  id;
	
	public Account(String id){
	this.id=id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public String getId(){
		return this.id;
	}
	
	public boolean equals(Account a){
		//首先判断需要比较的Object是否为空
		if(a==null){
			return false;
		}
		
		if(this==a){
			return true;
		}
		
		if(this.getClass()!=a.getClass()){
			return false;
		}
		
		return id.equals(a.id);
			
	}
	
	
	public static void main(String[] args){
		Account a1=new Account("xiaoma");
		Account a2=new Account("xiaoma");
		System.out.println(a1.equals(a2));
	}

}

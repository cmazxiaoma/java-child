
public class test{
	
	private static int nums[]={13,43,2323,4321,31,0,321,314,32};
	
	
	public void swap(int min,int max){
		int temp=nums[max];
		nums[max]=nums[min];
		nums[min]=temp;
	}
	
	public void sort(){
		for(int i=1;i<nums.length;i++){
			for(int j=1;j<nums.length-i+1;j++){
				if(nums[j-1]>nums[j]){
					swap(j-1,j);
				}
			}
		}
	}
	
	public void print(){
		for(int n:nums){
			System.out.println(n);
		}
	}
	
	public static void main(String[] args){
		test t=new test();
		t.sort();
		t.print();
	}
}

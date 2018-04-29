
public class test {
	
	public static void main(String[] args){
		test t=new test();
		int numbers[]={6,3,8,2,9,1};
		t.sort(numbers,0,numbers.length-1);
		t.print(numbers);
	}
	
	public void print(int[]nums){
		for(int n:nums){
			System.out.println(n);
		}
	}
	
	public void sort(int[] nums,int left,int right){
		if(right>left){
			int i=left,j=right;
			int x=nums[left];
			while(j>i){
				while(j>i&&nums[j]>x){
					j--;
				}
				if(j>i){
					nums[i++]=nums[j];
				}
				while(j>i&&nums[i]<x){
					i++;
				}
				if(j>i){
					nums[j--]=nums[i];
				}
			}
			nums[i]=x;
			sort(nums,left,i-1);
			sort(nums,i+1,right);
		}
	}
}

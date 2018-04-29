public class QuickSort {
	public static void sort(int[] number){
		sort(number,0,number.length-1);
	}
	
	
	private static void sort(int[] number, int left, int right) {
		// TODO Auto-generated method stub
		if(left<right){
			int i=left,j=right;
			int x=number[left];
			while(i<j){
				//死循环， 只有比x小的元素才能跳出循环 从右到左
				while(i<j&&number[j]>=x){
					j--;
				}
				if(i<j){
					number[i++]=number[j];
				}
				//大于x的元素才能跳出循环
				while(i<j&&number[i]<=x){
					i++;
				}
				if(i<j){
					number[j--]=number[i];
				}
			}
			//如果i==j的话就会跳出循环， 然后以i为分界线，左边比i小，右边比i大
			//然后我们把左边的元素和右边的元素递归调用，重复以上操作
			number[i]=x;
			sort(number,left,i-1);
			sort(number,i+1,right);
		}
	}


	public static void main(String[]args){
		int[] num={34,1,23,345,12,546,131,54,78,6543,321,85,1234,7,76,234};
		sort(num);
		for(int i=0;i<num.length;i++){
			System.out.println(num[i]);
		}
	}
}

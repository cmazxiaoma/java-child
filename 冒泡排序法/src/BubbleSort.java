
public class BubbleSort {
	static String sortArray(int[] array){
		String result="";
		for(int i=0;i<array.length;i++){
			result+=array[i]+" ";
		}
		return result;
	}
	
	private static int[] bubbleSort(int[] array) {
		// TODO Auto-generated method stub
		for(int i=0;i<array.length-1;i++){
			for(int j=0;j<array.length-1-i;j++){
				if(array[j]>array[j+1]){
					swap(array,j,j+1);
				}
			}
		}
		
		return array;
	}
	
	private static void swap(int[] array, int j, int j_1) {
		// TODO Auto-generated method stub
		int t=array[j];
		array[j]=array[j_1];
		array[j_1]=t;
		
	}

	public static void main(String args[]){
		int a[]={12,43,23,56,8,22,65,87};
		System.out.println("Before sorting="+sortArray(a));
		a=bubbleSort(a);
		System.out.println("After sorting="+sortArray(a));
	}
	
}

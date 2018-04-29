
public class test {

	private int[] nums = { 312, 126, 126, -272, -272, 226, 28, 165, 123, -1 };

	public void sort() {
		for (int i = 0; i < nums.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[min]) {
					min = j;
				}
			}
			// 如果待排序的数据队列里面最小数据的下标 等于数组最后一个数据的下标 那么就不用交换了
			if (min != i) {
				swap(i, min);
			}
		}
	}

	public void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void print() {
		for (int n : nums) {
			System.out.println(n);
		}
	}

	public static void main(String[] args) {
		test t = new test();
		t.sort();
		t.print();
	}

}

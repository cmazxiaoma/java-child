package 最大公约数和最小公倍数;

public class test {

	public static void main(String[] args) {
		test t = new test();
		System.out.println("10,30最大公约数:" + t.cal_Max_gongyueshu(132, 34320));
		System.out.println("10,30最小公倍数:" + t.cal_Min_gongbeishu(132, 34320));
	}

	// 必须保证max 大于min
	public int cal_Max_gongyueshu(int min, int max) {
		if (min > max) {
			int temp = min;
			min = max;
			max = temp;
		}
		if (max % min == 0) {
			return min;
		} else {
			return cal_Max_gongyueshu(max % min, max);
		}
	}

	public int cal_Min_gongbeishu(int min, int max) {
		return max * min / cal_Max_gongyueshu(min, max);
	}
}

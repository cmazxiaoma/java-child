/**
 * 
 */
/**
 * @author Administrator
 * 1-2+3-4……n 求和
 *
 */
package 求和;

public class package_info {

	public static void main(String args[]) {
		package_info p = new package_info();
		p.cal(10);
	}

	public void cal(int n) {
		int a = 0, b = 0;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				a = a + i;
			} else {
				b = b + i;
			}
		}
		System.out.println("b=" + b + ",a=" + a + "和=" + (b - a));
	}
}
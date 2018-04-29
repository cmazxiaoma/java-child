
public class IconCircle extends IconShape {
	private double radius;
	public static final double PI = 3.14;

	public IconCircle() {
		this.radius = 0.0;
	}

	public IconCircle(double r) {
		this.radius = r;
	}

	// 实现父类的抽象方法
	public double iconArea() {
		return PI * radius * radius;
	}

	public String getType() {
		return "圆";
	}

	public static void main(String args[]) {
		IconCircle ic = new IconCircle(5);
		System.out.println("Type=" + ic.getType());
		System.out.println("Area=" + ic.iconArea());

	}

}


public abstract class IconSquare extends IconShape {
	private double a, b;

	public IconSquare() {
		this.a = 0.0;
		this.b = 0.0;
	}

	public IconSquare(double i, double j) {
		this.a = i;
		this.b = j;
	}

	// 实现父类的抽象方法
	public double iconArea() {
		return a * b;
	}

	// 子类必须重写所有抽象方法才能被实例化，否则这个子类还是个抽象类
	// 所以这个类还是抽象类

}

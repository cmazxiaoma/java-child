
public abstract class LoanAccount {
	// 利息
	private double interest;
	// 本金
	private double fund;

	public double calculateInterest() {
		// 用于计算利息的算法，本金*利率
		// 但是利率的算法实现并没有在这个类中实现
		interest = getFund() * getInterestRate();
		System.out.println("利息=" + interest);
		return interest;

	}

	public void setFund(double fund) {
		this.fund = fund;
	}

	public double getFund() {
		return this.fund;
	}

	// 不同的存款类型有不同的利率，因此不在这个父类中实现利率的计算方法，而将它放到子类中实现
	protected abstract double getInterestRate();

}


public class CreditCardAccount {
	private String cid;
	private int money;

	public CreditCardAccount(String cid, int money) {
		this.cid = cid;
		this.money = money;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "[cid=" + cid + "]";
	}

}

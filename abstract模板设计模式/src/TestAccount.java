
public class TestAccount {
	public static void main(String args[]) {
		AccountA account = new AccountA();
		account.setFund(6666);
		account.calculateInterest();
		System.out.println(account.getFund());
	}
}

// Steven Rebelo 2314787

package cop2251.fall18.week1.rebelo;

public class CheckingAccount extends Account {
	
	private int numOfChecks = 1;
	
	// 1-arg Constructor calls 2-args constructor
	public CheckingAccount(String accNum) {
		
		this(accNum, 0);
	}
	
	// 2-args Constructor calling super to initialize account
	public CheckingAccount (String accNum, double balance) {
		
		super(accNum, balance);
		
	}
	
	// Overriden method to withdraw balance
	@Override
	public void withdraw (double balance) {
		
		// if num of checks is more then 3 charge an extra 3
		if (numOfChecks  >  3) {
			super.withdraw(balance + 3);
			numOfChecks++;
		}
		
		// else only withdraw value
		else {
			super.withdraw(balance);
			numOfChecks++;
		}
		
	}
}
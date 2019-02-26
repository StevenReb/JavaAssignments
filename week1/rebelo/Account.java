// Steven Rebelo 2314787

package cop2251.fall18.week1.rebelo;

// Account class
public class Account {
	
	// Private variables
	private	double balance;
	private String accountNumber;
	private final static double interestRate = 0.02;
	
	// Constructor with 2-args
	public Account (String accNum, double balance) {
		
		this.accountNumber = accNum;
		this.balance = balance;
	}
	
	// Deposit method adding val to the balance
	public void deposit(double val) {
		
		this.balance += val;
	}
	
	// Withdraw method subtracting val from the balance
	public void withdraw (double val) {
		
		if (val <= this.balance) {
			this.balance -= val;
		}
	}
	
	// Get balance method returns balance
	public double getBalance () {
		return this.balance;
	}
	
	// Add interest method
	public void addInterest () {
		
		this.balance += this.balance * interestRate;
	}
}
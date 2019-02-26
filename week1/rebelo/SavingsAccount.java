// Steven Rebelo 2314787

package cop2251.fall18.week1.rebelo;

public class SavingsAccount extends Account {
	
	private double minBalance  = 100.0;
	
	// 1-arg constructor calls 2-args constructor
	public SavingsAccount (String accNum) {
		
		this(accNum, 0);
	}
	
	// 2-args constructor
	public SavingsAccount (String accNum, double balance) {
		
		super (accNum, balance);
	}
	
	//
	@Override
	public void addInterest () {
		
		if (this.getBalance () >= minBalance) {
			super.addInterest();
		}
	}
}
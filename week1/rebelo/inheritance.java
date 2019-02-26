// Steven Rebelo 2314787

package cop2251.fall18.week1.rebelo;


public class inheritance {
	
	public static void main (String [] args) {
		
		// creating 3 accounts 1 of each
		Account account1 = new Account ("123", 100.0);
		
		CheckingAccount ckAccount1 = new CheckingAccount ("4556", 95.0);
		
		SavingsAccount svAccount1 = new SavingsAccount ("535", 50.0);
		
		// displaying the accounts
		System.out.println("    Account  "  + "\tChecking" + "\tSaving");
		System.out.printf("#1 | %-10s | %-10s | %-10s\n", account1.getBalance(), ckAccount1.getBalance(), svAccount1.getBalance() );
	
		// Depositing money in each account
		System.out.println("depositing...");
		account1.deposit(25);
		ckAccount1.deposit(5);
		svAccount1.deposit(40);
		
		
		System.out.printf("#2 | %-10s | %-10s | %-10s\n", account1.getBalance(), ckAccount1.getBalance(), svAccount1.getBalance() );
	
		// Withdrawing from accounts. Adds one to the 3 withdraw limit of checking
		System.out.println("withdarwing...");
		account1.withdraw(20);
		ckAccount1.withdraw(5);
		svAccount1.withdraw(20);
		
		
		System.out.printf("#3 | %-10s | %-10s | %-10s\n", account1.getBalance(), ckAccount1.getBalance(), svAccount1.getBalance() );
		
		// Trying to add interest. Works on account1 because there is no minimum requirement. svAccount doesn't add
		// 		because minimum requirement is not met. Also adding another withdraw to the checking limit
		System.out.println("withdarwing...");
		System.out.println("adding interest...");
		account1.addInterest();
		ckAccount1.withdraw(5);
		svAccount1.addInterest();
		
		
		System.out.printf("#4 | %-10s | %-10s | %-10s\n", account1.getBalance(), ckAccount1.getBalance(), svAccount1.getBalance() );		
		
		// add one more to checking withdraw limit. Depositing on svAccount to reach 100 minimum requirement
		System.out.println("depositing...");
		System.out.println("withdarwing...");
		ckAccount1.withdraw(5);
		svAccount1.deposit(30);
		
		
		System.out.printf("#5 | %-10s | %-10s | %-10s\n", account1.getBalance(), ckAccount1.getBalance(), svAccount1.getBalance() );		
		
		// Trying to add interest on svAccount. Now checking accounts is getting a $3 fee because it reached the limit
		System.out.println("withdarwing... $3 fee");
		ckAccount1.withdraw(5);
		svAccount1.addInterest();
		
		
		System.out.printf("#6 | %-10s | %-10s | %-10s\n", account1.getBalance(), ckAccount1.getBalance(), svAccount1.getBalance() );		
		
		//Trying to withdraw more than the balance. Silent error
		System.out.println("withdarwing...");
		account1.withdraw(200);
		
		
		System.out.printf("#7 | %-10s | %-10s | %-10s\n", account1.getBalance(), ckAccount1.getBalance(), svAccount1.getBalance() );		
		
		// Withdrawing exact amount of all accounts. Checking account needs to withdraw less to compensate for $3 fee.
		System.out.println("withdarwing...");
		account1.withdraw(107.1);
		ckAccount1.withdraw(74);
		svAccount1.withdraw(102);
		
		System.out.printf("#8 | %-10s | %-10s | %-10s\n", account1.getBalance(), ckAccount1.getBalance(), svAccount1.getBalance() );	}
}
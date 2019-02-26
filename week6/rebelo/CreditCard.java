

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditCard implements Comparable<CreditCard> {
	
	private String lastName;
	private String firstName;
	private String PAN;
	private Date expDate;
	
	// Constructor
	public CreditCard(String firstName, String lastName, String PAN, String expDate) throws ParseException {
		this.lastName = lastName;
		this.firstName = firstName;
		this.PAN = PAN;
		// Parsing the Date String to a Date object
		SimpleDateFormat format = new SimpleDateFormat("MM/yy");
		this.expDate = format.parse(expDate);
	}
	
	// Getters
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getPAN() {
		return this.PAN;
	}
	
	public Date getExpDate() {
		return this.expDate;
	}
	
	@Override
	public String toString() {
		// Setting a pattern for the date and making data to string
		String pattern = "MM/yy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String newExpDate = simpleDateFormat.format(expDate);
		
		// Returning formatted output
		String output = String.format("%10s | %10s | %10s | %10s", lastName, firstName, PAN, newExpDate);
		System.out.println();
		return output;
	}
	
	// Sorting the PAN
	@Override
	public int compareTo(CreditCard card) {
		return	this.getPAN().compareTo(card.getPAN());
	}
	
	
}// END OF CREDITCARD

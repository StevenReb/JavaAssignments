package cop2251.fall18.week6.rebelo;

// Imports
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Class
public class CreditPayments {
	
		// CreditCard list called paymentList
		private List <CreditCard> paymentList = new ArrayList<CreditCard>();
		
		
		// adding card to list
		public void add(CreditCard card) {
			paymentList.add(card);
		}
		
		// clear list
		public void reset() {
			paymentList.clear();
		}
		
		// Sorts by PAN
		public ArrayList<CreditCard> printByPAN() {
			
			Collections.sort(paymentList);
			
			// Formatting the output
			System.out.println();
			System.out.printf("%10s | %10s | %5s      | %10s", "Last Name", "First Name", "PAN", "Exp Date");
			System.out.println();
			System.out.print("-------------------------------------------------");
			
			// Displaying each card in the paymentList
			for(CreditCard card : paymentList) {
				System.out.printf(card.toString());
				}
			
			System.out.println();
			
			return (ArrayList<CreditCard>) paymentList;
		}
		
		// Sorts by Name
		public ArrayList<CreditCard> printByName() {
			
			// Sorting the paymentList using compareName comparator
			Collections.sort(paymentList, new compareName());
			
			// Formatting the output
			System.out.println();
			System.out.printf("%10s | %10s | %5s      | %10s", "Last Name", "First Name", "PAN", "Exp Date");
			System.out.println();
			System.out.print("-------------------------------------------------");
			
			// Displaying each card in paymentList
			for(CreditCard card : paymentList) {
				System.out.printf(card.toString());
				}
			
			System.out.println();
			
			return (ArrayList<CreditCard>) paymentList;
		}
		
		// Sorts by Experation Date
			public ArrayList<CreditCard> printByDate() {
				
				// Sorting paymentList using compareDate comparator
				Collections.sort(paymentList, new compareDate());
				
				// Formatting output
				System.out.println();
				System.out.printf("%10s | %10s | %5s      | %10s", "Last Name", "First Name", "PAN", "Exp Date");
				System.out.println();
				System.out.print("-------------------------------------------------");
				
				// Displaying each card in paymentList
				for(CreditCard card : paymentList) {
					System.out.printf(card.toString());
					}
				System.out.println();
					
				return (ArrayList<CreditCard>) paymentList;
			}
			
			// Name Comparator
			public class compareName implements Comparator<CreditCard> {

				@Override
				public int compare(CreditCard o1, CreditCard o2) {
					
					// Comapring the last name of both cards
					int result = o1.getLastName().compareTo(o2.getLastName());
					
					// If the result is equal sort by firsr name
					if(result == 0) {
						result = o1.getFirstName().compareTo(o2.getFirstName());
					}
					
					return result;
				}		
			} 
		
			// Date Comparator
			public class compareDate implements Comparator<CreditCard> {

				@Override
				public int compare(CreditCard o1, CreditCard o2) {
					
					// Changing the Date object to a String and than sorting them
					DateFormat dateFormat = new SimpleDateFormat("MM/yy");
					String date1 = dateFormat.format(o1.getExpDate());
					String date2 = dateFormat.format(o2.getExpDate());
				
					return date1.compareTo(date2);
				}		
			} 
			
			
			
}



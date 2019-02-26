package cop2251.fall18.week6.rebelo;

import java.util.ArrayList;
import java.util.List;


// PaymentBatchProcessor
public class PaymentBatchProcessor <T extends Payment> {
	
		List <T> listOfPayments = new ArrayList<>();
		
		
		// add method
		public void add(T payment) {
			this.listOfPayments.add(payment);
		}
		
		// getMax method
		public double getMax () {
			// Placeholder
			double maxAmount = 0.0;
			
			for( T payment : listOfPayments) {
				// If current payment is more then current maxAmount
				//		assign new highest amount
				if(payment.getAmount() > maxAmount) {
					maxAmount = payment.getAmount();
				}
			}
			// Return highest amount
			return maxAmount;	
		}// END OF getMax()
		
		
		// getTotal method
		public double getTotal() {
			
			// Accumulator
			double total = 0.0;
			
			// Add each payment amount to total
			for( T payment : listOfPayments) {
				total +=  payment.getAmount();
			}
			
			return total;
		}// END OF getTotal()
		
		// getSize method
		public int getSize() {
			// Return size of list
			return listOfPayments.size();
		}

}// END OF PAYMENTBATCHPROCESSOR
	
	
	
	


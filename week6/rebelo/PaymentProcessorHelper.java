

import java.util.ArrayList;
import java.util.List;


// PaymentBatchProcessor
public class PaymentProcessorHelper <T extends Payment> {
		
	public static <T> double getMax(ArrayList <T> listOfPayments) {
					
		// Placeholder
		double maxAmount = 0.0;
					
		for( T payment : listOfPayments) {
			// If current payment is more then current maxAmount
			//		assign new highest amount
			if(((Payment) payment).getAmount() > maxAmount) {
						maxAmount = ((Payment) payment).getAmount();
				}
			}
		// Return highest amount
		return maxAmount;	
	}// END OF getTotal

	public static <T> double getSum(ArrayList <T> listOfPayments) {
		// Accumulator
		double sum = 0.0;
		
		// Add each payment amount to total
				for( T payment : listOfPayments) {
					sum +=  ((Payment) payment).getAmount();
				}
		
		
		return sum;
	}// END OF getSum
	
	
	
}// END OF PAYMENTPROCESSORHELPER
	
	
	
	


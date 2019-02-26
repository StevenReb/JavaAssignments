

//Interface
	public interface Payment {
		public  double getAmount();
		public void setAmount(double amount);
	}// END OF INTERFACE
	
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	// Check class
	class Check implements Payment{
		// Variable
		private double amount;
		
		// Constructor
		public Check (double amount) {
			this.amount = amount;
		}
		
		// Getter and Setter
		public double getAmount() {
			return this.amount;
		}
		
		public void setAmount(double amount) {
			this.amount = amount;
		}
	}// END OF CHECK
		
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	class IOU implements Payment {
		// Variable
		private double amount;
				
		// Constructor
		public IOU (double amount) {
			this.amount = amount;
		}
		
		// Getter and Setter
		public double getAmount() {
			return this.amount;
		}
				
		public void setAmount(double amount) {
			this.amount = amount;
		}
	}// END OF IOU

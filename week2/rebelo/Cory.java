package cop2251.fall18.week2.rebelo;

public class Cory extends Fish {
	
	// Default Constructor calling super constructor
	public Cory () {
		super(2);
	}
		
	// Defining oxygen consumption for Cory fish
	public int getOxygenConsumption() {
		return 18;
	}
		
	// Defining swim for Cory fish
	public String swim() {
		return "Cory just hanging out.";
	}
}

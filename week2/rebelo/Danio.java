
public class Danio extends Fish {

	// Default Constructor calling super constructor
	public Danio () {
		super(1);
	}
	
	// Defining oxygen consumption for Danio fish
	public int getOxygenConsumption() {
		return 12;
	}
	
	// Defining swim for Danio fish
	public String swim() {
		return "Danio darting.";
	}
}

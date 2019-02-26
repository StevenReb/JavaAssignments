

public class Tetra extends Fish {

	// Default Constructor calling super constructor
	public Tetra () {
		super(3);
	}
			
	// Defining oxygen consumption for Tetra fish
	public int getOxygenConsumption() {
		return 10;
	}
			
	// Defining swim for Tetra fish
	public String swim() {
		return "Tetra gliding.";
	}
}

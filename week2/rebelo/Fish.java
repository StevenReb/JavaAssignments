// Steven Rebelo 2314787

package cop2251.fall18.week2.rebelo;

public abstract class Fish implements Comparable <Fish> {
	// Variable
	private int zone;
	
	// 1-arg Constructor
	public Fish (int zone) {
		this.zone = zone;
	}
	
	// Getter for zone
	public int getZone() {
		return this.zone;
	}
	
	// Abstract getter for Oxygen consumption and swim
	public abstract int getOxygenConsumption();
	
	public abstract String swim();
	
	// Compare method
	public int compareTo(Fish o) {
		if(getZone() > o.getZone()) return 1;
		else if (getZone() < o.getZone()) return -1;
		else return 0;
	}
}

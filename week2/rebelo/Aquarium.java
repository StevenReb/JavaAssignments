// Steven Rebelo 2314787

package cop2251.fall18.week2.rebelo;

import java.util.ArrayList;
import java.util.Collections;

public class Aquarium  {

	// Variables
	private ArrayList<Fish> life = new ArrayList <Fish>();
	private int capacity;
	
	// Default constructor calculating surface area
	public Aquarium (int width, int length) {
		this.capacity = width * length;
	}

	// Method to add fish if possible
	public boolean add(Fish fish) {
		/* If the fish being added uses less or equal of oxygen then is
		 *  in the tank the fish is added and returns true.
		 *  Else returns false 
		 */
		
		if(fish.getOxygenConsumption() <= capacity) {
			life.add(fish);
			capacity -= fish.getOxygenConsumption();
			return true;
		}
		return false;
	}
	
	// Getter for ArrayList
	public ArrayList<Fish> getFish() {
		return life;
	}
	
	// returns capacity = oxygen
	public int getCapacity() {
		return capacity;
	}
	
	// Returns number of fish in array
	public int getNumberOfFish() {
		return life.size();	
	}
	
	// Empties Array of fish and restores capacity
	public void empty() {
		for (Fish fish : life) {
			this.capacity += fish.getOxygenConsumption();
		}
		life.clear();
	}
	
	// Sorts and displays what fishes are doing
	public void watch() {
		
		// Sorting ArrayList
		Collections.sort(life);
		
		// Displaying using for each loop
		for (Fish fish : life) {
			System.out.println(fish.swim());
		}
	}
	
}
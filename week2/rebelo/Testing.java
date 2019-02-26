package cop2251.fall18.week2.rebelo;


public class Testing {

	public static void main (String [] args) {
		
		Aquarium aq = new Aquarium(10, 10);
		
		Fish fish3 = new Cory();
		Fish fish2 = new Tetra();
		Fish fish1 = new Danio();
		Fish fish4 = new Tetra();
		Fish fish5 = new Danio();
		Fish fish6 = new Cory();
		
		System.out.print("Aquarium Capacity: " + aq.getCapacity());
		System.out.println();
		
		aq.add(fish3);
		aq.add(fish2);
		aq.add(fish1);
		aq.add(fish4);
		aq.add(fish5);
		aq.add(fish6);
		

		System.out.print("Aquarium Capacity: " + aq.getCapacity());
		System.out.println();
		System.out.print("Aquarium Number: " + aq.getNumberOfFish());
		System.out.println();
		
		
		aq.watch();
		
		Aquarium aq2 = aq;
		
		
		
		System.out.print("Aquarium Capacity: " + aq.getFish());
		System.out.println();
		
		System.out.print("Aquarium Capacity: " + aq2.getFish().size());
		System.out.println();
		
	}
}

// Steven 2314787
package cop2251.fall18.week7.rebelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NameHelper {

	// Maps for storing the data and an inner map each to store inside of the maps
	Map<String, HashMap<String, Integer>> girlsByYear = new HashMap<>();
	HashMap<String, Integer> girlsInnerMap = new HashMap<String, Integer>();  
	
	Map<String, HashMap<String, Integer>> boysByYear = new HashMap<>();
	HashMap<String, Integer> boysInnerMap = new HashMap<String, Integer>();
	

	public boolean isNamePresent(String name, String gender) {
		
		// Accounting for different inputs
		String newName = name.toUpperCase();
		String newGender = gender.toUpperCase();
	
		// switch case to determine if Female or Male
		switch(newGender) {
		
			// If Female
			case "F":
				// Using Entry set to go through the map
				for(Entry<String, HashMap<String, Integer>> entry : girlsByYear.entrySet()) {
					// Entry point of girls by year
			        HashMap girlsByYear = entry.getValue(); 
			        
			        // If name is in map return true
			        if (girlsByYear.containsKey(newName)) { 
			            return true;
			        } 
				}	
				
			// If Male
			case "M":
				// Using Entry set to go through the map
				for(Entry<String, HashMap<String, Integer>> entry : boysByYear.entrySet()) {
					// Entry point of boys by year
			        HashMap boysByYear = entry.getValue(); 
			        
			        // If name is in map return true
			        if (boysByYear.containsKey(newName)) { 
			            return true; 
			        } 
				}
			
			// If nothing is found
			default: System.out.println("Name not found! Try again!");
						return false;
		}
	} // END OF isNamePresent()
	
	
	public Set<String> getYears() {
		// Return sorted TreeSet
		return new TreeSet<>(girlsByYear.keySet());

	} // END OF getYears()
	
	
	public int getRank(String year, String name, String gender){
        
		// Accounting for name being 0 
		int result = 0;
       
		// Accounting for different inputs
        String newName = name.toUpperCase();
        String newGender = gender.toUpperCase();
        
        switch(newGender) {
		
			// If Female
			case "F":
				return result = girlsByYear.get(year).get(newName);
		          
		    // If Male
			case "M":
	            return result = boysByYear.get(year).get(newName);
	           
	        // If no match Input is incorrect
        	default:
        		System.out.println("Wrong Input! Try Again! Year, Name, M/F");
        		return result;
        }
        
    } // END OF getRank()
	
	
	public void load() throws FileNotFoundException {
		
		File dir = new File("src/data");
        File [] files = dir.listFiles();
        
        // for each file in the directory...
        for (File f : files) {
        	
        	// Scanner for input of file f
        	Scanner input = new Scanner(f);
        	
        	// while input has more lines
        	while (input.hasNext()) {

        	      String line = input.next();
        	      
        	      // Splitting the input by the commas for processing
        	      String [] details = line.split(",");
        	      
        	      // Setting name and gender to upper case
        	      String name = details[0].toUpperCase();
        	      String gender = details[1].toUpperCase();
        	      
        	      // setting value to integer value of the string
        	      int value = Integer.valueOf(details[2]);
        	      
        	      // using the path to get the year by getting the substring fomat: src\data\yob1952.txt
        	      // that contains the year and storing it in year variable
        	      String path = f.toString();
        	      String year = path.substring(12, 16);
       
        	      
        	     // If the gender is Female
        	      if("F".equals(gender)) {
        	    	 
        	    	  // If girlsByYear does not contain that year
        	    	  //	put the year in the map with a new HashMap
        	    	 if(!girlsByYear.containsKey(year)) {
        	    		 girlsByYear.put(year, new HashMap<>());
        	    	 }
        	    	 
        	    	 // If it contains the year just put the name and value into that year
        	    	 girlsByYear.get(year).put(name, value);
        	      }
        	      
        	      // If gender is Male
        	      if("M".equals(gender)) {
        	    	  
        	    	// If boysByYear does not contain that year
        	    	  //	put the year in the map with a new HashMap
         	    	 if(!boysByYear.containsKey(year)) {
         	    		 boysByYear.put(year, new HashMap<>());
         	    	 }
         	    	 
         	    	 // If it contains the year just put the name and value into that year
         	    	 boysByYear.get(year).put(name, value);
         	      }
        	      
        		}
        		// Close input to prevent errors/corruption
             	input.close();
        }  
	} // END OF load()


} // END OF NameHelper


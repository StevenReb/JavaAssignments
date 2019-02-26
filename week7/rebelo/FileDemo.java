

import java.io.File;
import java.io.FileNotFoundException;

public class FileDemo {
   public static void main(String[] args) throws FileNotFoundException {      
     
	   NameHelper newhelper = new NameHelper();
	   
	   newhelper.load();
	   
	   boolean present = newhelper.isNamePresent("noah", "m");
	   System.out.println(newhelper.getRank("2015", "noah", "m"));

	   
	   System.out.println(present);
   }
}

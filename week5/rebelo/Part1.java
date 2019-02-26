
import java.io.*;
import javax.swing.JFileChooser;

public class Part1 {
  public static void main(String[] args) throws IOException {
	  
	  JFileChooser fc = new JFileChooser();
	    int returnVal = fc.showOpenDialog(null);

	    if (returnVal == JFileChooser.APPROVE_OPTION) {
	        File file = fc.getSelectedFile();
	        System.out.println("File contents: " + file.getAbsolutePath());
	        System.out.println();
	        showContents(file);
	    } 
  }
  
  // showContents method
  public static void showContents(File file){
      try {
    	  // load file into fileInput
          FileInputStream fileInput = new FileInputStream(file);   
         
          // While true
          while(true){
        	  // Creating byte array
              byte bArray [] = new byte[10];
              
              int tenBytes = 0;
              
              // Reading in 10 bytes
              tenBytes = fileInput.read(bArray, 0, 10);
              
              // If file is at the end it returns -1 which will break the while loop
              if (tenBytes == -1) { break; }
              
              // Foreach loop set the byte as Integer number
              for (byte myByte : bArray){
                  // Display hex value
                  System.out.print(String.format("%02x ", myByte));
              }
              
              System.out.print(" ");
              
              // Second foreach loop
              for (byte myByte : bArray){
            	  // Cast each byte as char
                  char ch = (char) myByte;
                  // If ch is a digit or letter print it else print "."
                  if (Character.isDigit(ch) || Character.isLetter(ch)) {
                      System.out.print(ch);
                  }
                  else
                      System.out.print(".");
              }
              // After every line printed start new one
              System.out.println();
              // Close file to prevent corruption
          }  fileInput.close();
      } catch (Exception e) {}
  
  }
}

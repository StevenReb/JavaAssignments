// Steven Rebelo 2314787
package cop2251.fall18.week5.rebelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Part2 extends Application {
	
	// Tshirt object
	TShirt tshirt = new TShirt();
	
	@Override
	  public void start(Stage primaryStage) throws ClassNotFoundException, IOException {
		// Gridpane to organize my rows
		GridPane gridPane = new GridPane();
		
		// First Row of GUI includes a label and textfield
		Label text = new Label("Text: ");
		TextField textField = new TextField();
		HBox hBox1 = new HBox();
		hBox1.getChildren().addAll(text, textField);

		// Second Row of GUI includes 3 radio buttons that are grouped
		HBox hBox2 = new HBox(10);
		hBox2.prefHeight(20);
		RadioButton small = new RadioButton("Small");
		RadioButton medium = new RadioButton("Medium");
		RadioButton large = new RadioButton("Large");
		ToggleGroup group = new ToggleGroup();
		small.setToggleGroup(group);
		medium.setToggleGroup(group);
		large.setToggleGroup(group);
		hBox2.getChildren().addAll(small, medium, large);
		
		// Third Row of GUI is only the checkbox for if the shirt is a gift
		CheckBox gift = new CheckBox("Gift?");
		gift.setIndeterminate(false);
		
		// Fourth Row of GUI includes save and close button
		HBox hBox4 = new HBox(10);
		Button save = new Button("Save");
		Button close = new Button("Close");
		hBox4.getChildren().addAll(save, close);
		hBox4.setAlignment(Pos.BOTTOM_LEFT);
		
		VBox vBox = new VBox();
		vBox.setSpacing(5);
		vBox.getChildren().addAll(hBox1, hBox2, gift, hBox4);
		
		// Organizing the gridpane with my 4 rows
//		gridPane.add(text, 0, 0);
//		gridPane.add(textField, 1, 0);
//		gridPane.add(hBox2, 1, 1);
//		gridPane.add(gift, 0, 2);
//		gridPane.add(hBox4, 1, 3);
		
	    // Events
	    // Saving Event
	    save.setOnAction(e -> {
	    	// Setting text
	    	tshirt.setText(textField.getText());
	    	
	    	// Deciding which size
	    	if(small.isSelected()) {
	    		tshirt.setSize("small");
	    		}
	    	else if(medium.isSelected()) {
	    		tshirt.setSize("medium");
	    		}
	    	else if(large.isSelected()) {
	    		tshirt.setSize("large");
	    		}
	    	
	    	// If t-shirt is a gift
	    	if(gift.isSelected()) { 
	    		tshirt.setGift(true);
	    		} 
	    	else {
	    		tshirt.setGift(false);
	    		} 

	    	// Saving the object
	    	try {
	    		FileOutputStream fos = new FileOutputStream("tshirt.dat");
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(tshirt);
	            oos.close();
	            fos.close();
	    	} catch (IOException ioe) {ioe.printStackTrace(); }	
	    });
	    
	    // Closing window
	   close.setOnAction(e -> {
	    	Stage stage = (Stage) close.getScene().getWindow();
	    	stage.close();

	    });
	   
	// Loading Form from saved object
			try {
	            FileInputStream fis = new FileInputStream("tshirt.dat");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            
	            // loading the object into tshirt
	            tshirt = (TShirt) ois.readObject();
	           
	            // Setting textfield
	            textField.setText(tshirt.getText());
	            
	            // Setting size
	    		switch(tshirt.getSize()) {
	    			case "small": small.setSelected(true); break;
	    			case "medium": medium.setSelected(true); break;
	    			case "large": large.setSelected(true); break;
	    		}
	    		
	    		// Setting the gift checkbox
	    		gift.setSelected(tshirt.isGift());
	            
	    		// Closing the ois and fis to prevent corruption
	            ois.close();
	            fis.close();
	        } 
			// Catching errors
	        catch (IOException ioe) { ioe.printStackTrace(); }
	        catch (ClassNotFoundException c) { c.printStackTrace(); }

	    
	    // Create a scene and place it in the stage
	    Scene scene = new Scene(vBox, 250, 100);
	    primaryStage.setTitle("T-Shirt Order");
	    primaryStage.setScene(scene);
	    primaryStage.show();
//	    primaryStage.setMaxWidth(270);
//	    primaryStage.setMinWidth(270);
//	    primaryStage.setMinHeight(150);
//	    primaryStage.setMaxHeight(150);

	  } 

	  public static void main(String[] args) {
	    launch(args);
	  }
	  
}

// Steven Rebelo 2314787
package cop2251.fall18.week3.rebelo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;


public class ThreeShapes extends Application {
	@Override // Override the start method in the Application class
	  public void start(Stage primaryStage) {       
	    
		 GridPane pane = new GridPane();
		 pane.setAlignment(Pos.CENTER);
		 pane.setPadding(new Insets(10));
		 pane.setHgap(5);
		 pane.setVgap(5);
		
		// Create rectangles 
	    Rectangle rect = new Rectangle(80, 75);
	    rect.setStroke(Color.GREEN);
	    rect.setFill(Color.BLUE);
	    rect.setStrokeWidth(5);
	    // Create Circle
	    
	    Circle circ = new Circle(40);
	    circ.setStroke(Color.RED);
	    circ.setFill(Color.BLACK);
	    circ.setStrokeWidth(5);
	    
	    // Create Cross
	    Line line1 = new Line(10, 35,   60,   35);
	    line1.setStroke(Color.GREEN);
	    line1.setStrokeWidth(5);
	    Line line2 = new Line(35, 10, 35, 100);
	    line2.setStroke(Color.GREEN);
	    line2.setStrokeWidth(5);
	    // Add lines to a group
	    Group grp = new Group(line1, line2);
	  
	    // Add shapes to pane
	    pane.add(rect, 0, 0);
	    pane.add(circ, 1, 1);
	    pane.add(grp, 2, 2);
	   
	    
	    // Create a scene and place it in the stage
	    Scene scene = new Scene((pane), 300, 300);
	    primaryStage.setTitle("ThreeShapes"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	  }
	
	  public static void main(String[] args) {
	    launch(args);
	  }
	}
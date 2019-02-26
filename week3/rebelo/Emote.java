// Steven Rebelo 2314787
package cop2251.fall18.week3.rebelo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.layout.StackPane;


public class Emote extends Application {
	
	@Override // Override the start method in the Application class
	  public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
			
		// Circle for head
			 Circle head = new Circle(80);
			 head.setStroke(Color.BLACK);
			 head.setFill(Color.YELLOW);
			 head.setStrokeWidth(5);
			 
		// Arc for mouth
			 Arc mouth = new Arc(0, 20, 45, 50, 180, 180);
			 mouth.setType(ArcType.ROUND);
			 mouth.setFill(Color.WHITE);
			 mouth.setStroke(Color.BLACK);
			 mouth.setStrokeWidth(3);
			 
		// Arc for left eye
			 Arc leftEye = new Arc(-30, -10, 20, 35, 0, 180);
			 leftEye.setType(ArcType.ROUND);
			 leftEye.setFill(Color.WHITE);
			 leftEye.setStroke(Color.BLACK);
			 leftEye.setStrokeWidth(3);
		
		// Arc for left pupil
			 Arc leftPupil = new Arc(-30, -10, 10, 20, 0, 180);
			 leftPupil.setType(ArcType.ROUND);
			 leftPupil.setFill(Color.BLACK);

		// Arc for right eye
			 Arc rightEye = new Arc(30, -10, 20, 35, 0, 180);
			 rightEye.setType(ArcType.ROUND);
			 rightEye.setFill(Color.WHITE);
			 rightEye.setStroke(Color.BLACK);
			 rightEye.setStrokeWidth(3);
			 
		// Arc for right pupil
			 Arc rightPupil = new Arc(30, -10, 10, 20, 0, 180);
			 rightPupil.setType(ArcType.ROUND);
			 rightPupil.setFill(Color.BLACK);
		
		// Grouping the face together
			 Group face = new Group(head, mouth, leftEye, rightEye, leftPupil, rightPupil);
			 
		// Adding face to pane
			 pane.getChildren().add(face);
			 
		// Create a scene and place it in the stage
			 Scene scene = new Scene((pane), 300, 300);
			 primaryStage.setTitle("Emote"); 
			 primaryStage.setScene(scene); 
			 primaryStage.show();
	
	}
	
	 public static void main(String[] args) {
		    launch(args);
		  }
}

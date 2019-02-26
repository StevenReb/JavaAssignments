

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

 /* 
 * (Move the Ball) Write a program that moves the ball in a pane. 
 * You should define a pane class for displaying the ball and 
 * provide the methods for moving the ball left, right, up, and down.
 * Check the boundary to prevent the ball from moving out of sight completely.
 */

public class BallPane extends Pane {
	// Create circle
	private Circle circle = new Circle(250, 250, 25);

  
	  // Constructor making red ball with black outline 
	  public BallPane() {
	    circle.setFill(Color.RED);
	    circle.setStroke(Color.BLACK);
	    getChildren().add(circle);
	  }
	  
	  // Method to to getCords to display circles center cords
	  public String getCords() {
		  return "X: " + circle.getCenterX() + "\tY: " + circle.getCenterY();
		  
	  };
	  
	  // Four Methods to move ball in each direction and display cords
	  public void goUp() {
		  if (this.circle.getCenterY() > circle.getRadius()) {
			  circle.setCenterY(circle.getCenterY() - circle.getRadius());
			  System.out.println(getCords());
		  };
	  }
	  
	  public void goDown(double height) {
		  if (this.circle.getCenterY() + 10 < getHeight() - circle.getRadius()) {
			  circle.setCenterY(circle.getCenterY() + circle.getRadius());
			  System.out.println(getCords());
		  };
	  }
	  
	  public void goLeft() {
		  if (this.circle.getCenterX() > circle.getRadius()) {
			  circle.setCenterX(circle.getCenterX() - circle.getRadius());
			  System.out.println(getCords());
		  };
	  }
	  
	  public void goRight() {
		  if (this.circle.getCenterX() < getWidth() - circle.getRadius()) {
			  circle.setCenterX(circle.getCenterX() + circle.getRadius());
			  System.out.println(getCords());
		  };
	  }
}

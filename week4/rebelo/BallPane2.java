
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

 /* 
 * (Move the Ball) Write a program that moves the ball in a pane. 
 * You should define a pane class for displaying the ball and 
 * provide the methods for moving the ball left, right, up, and down.
 * Check the boundary to prevent the ball from moving out of sight completely.
 */

public class BallPane2 extends Pane {
	
	// Create and set circle, radius, x, y
	private Circle circle = new Circle(250, 250, 25);
	private double radius = circle.getRadius()*1.5;
	private double x = circle.getCenterX();
	private double y = circle.getCenterY();


	  // Constructor making red ball with black outline 
	  public BallPane2() {
	    circle.setFill(Color.RED);
	    circle.setStroke(Color.BLACK);
	    getChildren().add(circle);
	  }
 

	  // Four Methods to move ball in each direction and display cords
	  public void moveLeft() {					
		  						// The first line of each movement checks 
		  						//  	if the ball will be out of bounds
		  						if(x > radius) {x -= radius;}
		  					   	circle.setCenterX(x);
	  							}	  							
							    
	  public void moveUp() { 
		  						if(y > radius) {y -= radius;}
						    	circle.setCenterY(y);
			    				}
			    	
	  public void moveRight() { 
		  						if(x < getWidth() - radius) {x += radius;}
						    	circle.setCenterX(x);
			    				}
			    	
	  public void moveDown() { 
		  						if(y < getHeight() - radius) {y += radius;}
						    	circle.setCenterY(y);
								}
		    
	}


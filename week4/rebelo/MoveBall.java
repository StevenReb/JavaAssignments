// Steven Rebelo 2314787
package cop2251.fall18.week4.rebelo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/* 
 * (Move the Ball) Write a program that moves the ball in a pane. 
 * You should define a pane class for displaying the ball and 
 * provide the methods for moving the ball left, right, up, and down.
 * Check the boundary to prevent the ball from moving out of sight completely.
 */

public class MoveBall extends Application {
@Override
  public void start(Stage primaryStage) {
	// Creating panes to organize scene
	BorderPane border = new BorderPane();
	BallPane ballPane = new BallPane();
    
	// Create and format HBOX
    HBox hBox = new HBox();
    hBox.setSpacing(20);
    hBox.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    
    //  Creating and formating text for instruction
    Text controls = new Text("To Control Press Arrows on Keyboard: ");
    Text left = new Text("LEFT");
    Text up = new Text("UP");
    Text right = new Text("RIGHT");
    Text down = new Text("DOWN");
    left.setFill(Color.RED);
    up.setFill(Color.RED);
    right.setFill(Color.RED);
    down.setFill(Color.RED);
    // Adding instructions to hbox
    hBox.getChildren().addAll(controls, left, up, right, down);
    
    // Adding panes to borderpane
    border.setCenter(ballPane);
    border.setBottom(hBox);
    
    
    // Making the ball move and change color of button used   
    ballPane.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.UP) {
    	  ballPane.goUp();
    	  up.setFill(Color.GREEN);
      } 
      else if (e.getCode() == KeyCode.DOWN) {
    	  ballPane.goDown(hBox.getHeight());
    	  down.setFill(Color.GREEN);
      }
      else if (e.getCode() == KeyCode.LEFT) {
    	  ballPane.goLeft();
    	  left.setFill(Color.GREEN);
      }
      else if (e.getCode() == KeyCode.RIGHT) {
    	  ballPane.goRight();
    	  right.setFill(Color.GREEN);
      }
    });
    
    // Changing color of text back !!! This is not working as intended I tried a few thing, any suggestions?
      up.setOnKeyReleased( e -> {
      if (e.getCode() == KeyCode.UP) {
    	  up.setFill(Color.RED);
      	}});
   
      up.setOnKeyReleased( e -> {
      if (e.getCode() == KeyCode.DOWN) {
    	  down.setFill(Color.RED);
      }});
      
      up.setOnKeyReleased( e -> {
      if (e.getCode() == KeyCode.LEFT) {
    	  left.setFill(Color.RED);
      }});
      
      up.setOnKeyReleased( e -> {
      if (e.getCode() == KeyCode.RIGHT) {
    	  right.setFill(Color.RED);
      }});

      
    // Create a scene and place it in the stage
    Scene scene = new Scene(border, 500, 500);
    primaryStage.setTitle("Move Ball");
    primaryStage.setScene(scene);
    primaryStage.show();
    System.out.println(scene.getHeight());
    ballPane.requestFocus();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

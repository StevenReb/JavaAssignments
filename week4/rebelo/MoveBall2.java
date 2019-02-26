
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/* 
 * (Move the Ball) Write a program that moves the ball in a pane. 
 * You should define a pane class for displaying the ball and 
 * provide the methods for moving the ball left, right, up, and down.
 * Check the boundary to prevent the ball from moving out of sight completely.
 */

public class MoveBall2 extends Application {
@Override
  public void start(Stage primaryStage) {
	// Creating panes to organize scene
	BorderPane border = new BorderPane();
	BallPane2 ballPane = new BallPane2();
    
	// Create and format HBOX
    HBox hBox = new HBox();
    hBox.setSpacing(5);

    //  Creating and formating buttons for instruction
    Text controls = new Text("Click Buttons -> ");
    Button btLeft = new Button("LEFT");
    Button btUp = new Button("UP");
    Button btRight = new Button("RIGHT");
    Button btDown = new Button("DOWN");
    
    // Adding instructions to hbox
    hBox.getChildren().addAll(controls, btLeft, btUp, btRight, btDown);
    hBox.setAlignment(Pos.CENTER);
    
    // Adding panes to borderpane
    border.setCenter(ballPane);
    border.setBottom(hBox);
    
    
    // Making the ball move according to which button was clicked   
    btLeft.setOnAction(e -> {
    	ballPane.moveLeft();
      });
    
    btUp.setOnAction(e -> {
  	  	ballPane.moveUp();
    });
    
    btRight.setOnAction(e -> {
    	ballPane.moveRight();
    });
    
    btDown.setOnAction(e -> {
    	ballPane.moveDown();
    });
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(border, 500, 500);
    primaryStage.setTitle("Move Ball");
    primaryStage.setScene(scene);
    primaryStage.show();
    System.out.println(scene.getHeight());
  }

  public static void main(String[] args) {
    launch(args);
  }
}

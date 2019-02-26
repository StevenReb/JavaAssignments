

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DynamicQueriesGUI extends Application {

	// Global fields/variables
	TextField cityInput = new TextField();
	TextField nameInput = new TextField();
	RadioButton radioName = new RadioButton("Name");
	RadioButton radioCity = new RadioButton("City");
	RadioButton radioZip = new RadioButton("Zip");
	TextArea output = new TextArea();
	private Statement stmt;	
	
		@Override
		  public void start(Stage primaryStage) throws ClassNotFoundException, IOException {
			
			// Initializing the Database
			initializeDB();
			
			// First Row
			// Pane Setup
			GridPane g1 = new GridPane();
			HBox firstRow = new HBox();
			firstRow.setPadding(new Insets(10));
			// Label setup
			Label name = new Label("Name: ");
			name.setPrefWidth(50);
			nameInput.setPrefWidth(200);
			// Adding Label to grid pane and then to hbox
			g1.add(name, 0, 0);
			g1.add(nameInput, 1, 0);
			firstRow.getChildren().addAll(g1);
			
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
			// Second Row
			// Pane setup
			GridPane g2 = new GridPane();
			HBox secondRow = new HBox();
			secondRow.setPadding(new Insets(10));
			// Label setup
			Label city = new Label("City: ");
			city.setPrefWidth(50);
			cityInput.setPrefWidth(200);
			// Adding label to grid pane then to hbox
			g2.add(city, 0, 0);
			g2.add(cityInput, 1, 0);
			secondRow.getChildren().addAll(g2);
			
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
			// Third Row
			// Pane setup
			HBox thirdRow = new HBox();
			thirdRow.setSpacing(20);
			thirdRow.setPadding(new Insets(5));
			
			// Label setup
			Label order = new Label("Order By:");
			// Radio button setup
			ToggleGroup group = new ToggleGroup();
			radioName.setToggleGroup(group);
			radioName.setSelected(true);
			radioCity.setToggleGroup(group);
			radioZip.setToggleGroup(group);
			// Adding nodes to hbox
			thirdRow.getChildren().addAll(order, radioName, radioCity, radioZip);
			
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
			// Fourth Row
			// Pane setup
			HBox fourthRow = new HBox();
			fourthRow.setPadding(new Insets(5));
			fourthRow.setAlignment(Pos.BASELINE_RIGHT);
			HBox spacer = new HBox();
			spacer.setPrefWidth(220);
			// Button
			Button search = new Button("Search");
			
			// Adding button and a spacer hbox to hbox
			fourthRow.getChildren().addAll(search, spacer);
			
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			

			// Fifth Row
			// Pane setup
			HBox fifthRow = new HBox();
			fifthRow.setPadding(new Insets(15));
			// Setting up output text area
		    output.setStyle("-fx-font-family: monospace");
		    output.setPrefColumnCount(60);
			// Adding global text area to hbox
			fifthRow.getChildren().add(output);

			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

			// Adding everything to vbox container
			VBox container = new VBox();
			container.getChildren().addAll(firstRow, secondRow, thirdRow, fourthRow, fifthRow);
			
			
			// Events
			// When search button is clicked call searchDB() method
			search.setOnAction(e -> searchDB());

			// Scene setup and display
		    Scene scene = new Scene(container, 500, 400);
		    primaryStage.setTitle("Customer DB Query");
		    primaryStage.setMinHeight(350);
		    primaryStage.setMinWidth(500);
		    primaryStage.setMaxWidth(500);
		    primaryStage.setScene(scene);
		    primaryStage.show();
		   
		  } 

		  public static void main(String[] args) {
		    launch(args);
		  }
		  
		  private void initializeDB() {
			    try {
			      
			      // Load the JDBC driver
			      //Class.forName("com.mysql.jdbc.Driver");
			      //Class.forName("oracle.jdbc.driver.OracleDriver");
			      //System.out.println("Driver loaded");

			      // Establish a connection
			      Connection connection = DriverManager.getConnection
			        ("jdbc:mysql://localhost/java", "root", "2712");
			      // display successful connection in text area and console log
			      System.out.println("Database connected");
			      output.setText("Database connection successful");
			      // Create a statement
			      stmt = connection.createStatement();
			    }
			    catch (Exception ex) {
			      // If and error happens display stack trace, and message to text area and console log
			      ex.printStackTrace();
			      output.setText("Database connection failed");
			      System.out.println("Failed to set up connection to Database. See StackTrace above for more information.");
			    }
			  }
		  
		  private void searchDB() {
			    
			    try {
			      // Resetting text area
			      output.setText("");
			    	
			      // Query string for general search of all customers
			      String queryString = "SELECT * FROM customers";
			      
			      // boolean variable for processing input
			      boolean nameText = nameInput.getText().isEmpty();
			      boolean cityText = cityInput.getText().isEmpty();
			      
			      // if both name and city text fields have content use this sql statement
			      if(!nameText && !cityText) {
			    	  queryString += " WHERE name LIKE '" + nameInput.getText() + "%' AND city LIKE '" 
			    			  			+ cityInput.getText() + "%'";
			      }
			      // if only the name text field has content use this sql statement
			      else if(!nameText) {
			    	  queryString += " WHERE name LIKE '" + nameInput.getText() + "%'";
			      }
			      // if only the city text field has content use this sql statement
			      else if(!cityText) {
			    	  queryString += " WHERE city LIKE '" + cityInput.getText() + "%'";
			      }
			      
			      // sort by selected radio button
			      if(radioName.isSelected()) {
			    	  queryString += " ORDER BY name";
			      }
			      else if(radioCity.isSelected()) {
			    	  queryString += " ORDER BY city";
			      }
			      else if(radioZip.isSelected()) {
			    	  queryString += " ORDER BY zip";
			      }
			      
			      // Console logs sql statement used and result
			      System.out.println();
			      System.out.println(queryString);
			      System.out.println();
			      System.out.println(String.format("%-15s %-20s %-10s %-8s %-5s\n", "Name", "Address", "City", "State", "Zip"));
			      output.appendText(String.format("%-15s %-20s %-10s %-8s %-5s\n", "Name", "Address", "City", "State", "Zip"));
			      
			      // Execute query using queryString
			      ResultSet rset = stmt.executeQuery(queryString);
			      
			      // While rset has more content
			      while(rset.next()) {
			    	
			    	// Assigning values from database to variables
			        String name = rset.getString(2);
			        String address = rset.getString(3);
			        String city = rset.getString(4);
			        String state = rset.getString(5);
			        String zip = rset.getString(6);
			        
			        // Displaying query result in console
			        System.out.println(String.format("%-15s %-20s %-20s %-2s %-5s", name, address, city, state, zip));
			        
			        // Display result in text area
			        output.appendText(String.format("%-15s %-15s %-15s %-8s %-5s", name, address, city, state, zip) + "\n");
			        
			     // if output how no content after query set text to "No Entry Found"
			     if(output.getText().isEmpty()) {
			    	 output.setText("No Entry Found");
			     }
			     
			    }
			     }
			    // if error display stack trace
			    catch (SQLException ex) {
			      ex.printStackTrace();
			      output.setText("See Stack Trace for more information");
			    }
			  }
		  
}


package cop2251.fall18.week4.rebelo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/*
 * (Create an investment-value calculator) Write a program that 
 * calculates the future value of an investment at a given interest rate
 * for a specified number of years. The formula is: 
 * futureValue = investmentAmount * (1 + montlyInterestRate)^years*12)
 */

public class InvestmentCalculator extends Application {
	  // Creating Global textfields
	  private TextField tfInvestmentAmount = new TextField();
	  private TextField tfNumberOfYears = new TextField();
	  private TextField tfAnnualInterestRate = new TextField();
	  private TextField tfFutureValue = new TextField();
	  private Button btCalculate = new Button("Calculate");
	  
	  @Override
	  public void start(Stage primaryStage) {
	    // Creating gridpane and placing textfields accordingly
	    GridPane gridPane = new GridPane();
	    gridPane.setHgap(5);
	    gridPane.setVgap(5);
	    gridPane.add(new Label("Investment Amount:"), 0, 0);
	    gridPane.add(tfInvestmentAmount, 1, 0);
	    gridPane.add(new Label("Number of Years:"), 0, 1);
	    gridPane.add(tfNumberOfYears, 1, 1);
	    gridPane.add(new Label("Annual Interest Rate:"), 0, 2);
	    gridPane.add(tfAnnualInterestRate, 1, 2);
	    gridPane.add(new Label("Future Value:"), 0, 3);
	    gridPane.add(tfFutureValue, 1, 3);
	    gridPane.add(btCalculate, 1, 5);

	    // Formatting 
	    gridPane.setAlignment(Pos.CENTER);
	    tfInvestmentAmount.setAlignment(Pos.BOTTOM_RIGHT);
	    tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
	    tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
	    tfFutureValue.setAlignment(Pos.BOTTOM_RIGHT);
	    tfFutureValue.setEditable(false);
	    GridPane.setHalignment(btCalculate, HPos.RIGHT);

	    // Calculate future value on bt click
	    btCalculate.setOnAction(e -> calculateInvestment());

	    // Create a scene and place it in the stage
	    Scene scene = new Scene(gridPane, 400, 250);
	    primaryStage.setTitle("Investment Calculator");
	    primaryStage.setScene(scene); 
	    primaryStage.show(); 
	  }
	  
	  private void calculateInvestment() {
		  double investmentAmount = Double.parseDouble(tfInvestmentAmount.getText());
		  double numberOfYears = Double.parseDouble(tfNumberOfYears.getText());
		  double annualInterestRate = Double.parseDouble(tfAnnualInterestRate.getText());
		  double futureValue = investmentAmount * (Math.pow((1 + annualInterestRate / 100), numberOfYears));
		  
		// Display monthly payment and total payment
		  tfFutureValue.setText(String.format("$%.2f", futureValue));
	    
	  }
	  
	  public static void main(String[] args) {
	    launch(args);
	  }
}


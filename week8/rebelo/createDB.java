package cop2251.fall18.week8.rebelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class createDB 
{
	public static void main(String[] args) throws SQLException
	{
        //String dbURL = "jdbc:mysql://localhost/java", "root", "2712" ; "create=true";
        
        
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "2712");
        if (connection != null) 
        {
            System.out.println("Connected to database...");
        }
        else
        {
        	System.out.println("Oh Oh");
        }
        
        
        Statement statement = connection.createStatement(); 
        
        try
        {
        	statement.executeUpdate("DROP TABLE customers");
        }
        catch (SQLException e)
        {
        	System.out.println("table drop failed -- most likely because it already existed: " + e);
        }
        
        // -----------------------------
        // create the table
        // -----------------------------
        System.out.println("creating customers table");
        
        String sql = "CREATE TABLE customers ( " +
        		  "custid INTEGER NOT NULL,"+
        		  "name VARCHAR(20) NOT NULL,"+
        		  "address VARCHAR(20) NOT NULL,"+
        		  "city VARCHAR(16) NOT NULL,"+
        		  "state VARCHAR(2) NOT NULL,"+
        		  "zip VARCHAR(5) NOT NULL)";

        statement.executeUpdate(sql);
   
        // -----------------------------
        // insert some data into table
        // -----------------------------
        System.out.println("inserting data into customers table");
        
        statement.executeUpdate("INSERT INTO Customers VALUES" + 
                "(1, 'Smith, Tim', '12 Elm St', 'Tampa', 'FL', '34567')," +
                "(2, 'Jones, Tom', '435 Oak Dr', 'Dunedin', 'FL', '33245')," +
                "(3, 'Avery, Bill', '623 Ash Ave', 'Clearwater', 'FL', '33655'),"+
                "(4, 'Kerr, Debra', '1573 Yew Crt', 'Clearwater', 'FL', '33442'),"+
                "(5, 'Mattik, Otto', '15 Fir Ct','Oldsmar', 'FL','34567'),"+
                "(6, 'Nate, Mary', '22 54th St', 'St. Petersburg', 'FL', '33711'),"+
                "(7, 'Tater, Dick', '77 Gunn Hwy', 'Tampa', 'FL', '39844'),"+
        		"(8, 'Forth, Sally', '555 Pine St', 'Tampa', 'FL', '39812')" );
        
        // -----------------------------
        // query the table and display results
        // -----------------------------
        ResultSet result = statement.executeQuery("SELECT * FROM customers");
        
        System.out.println("List of Addresses: "); 
        
        while (result.next())
        {
        	System.out.println(
        			"  "+result.getInt("custid")
        			+ ", "+result.getString("name")
        			+ ", "+result.getString("address"));
        }
        
        // -----------------------------
        // clean up
        // -----------------------------
        result.close();
        connection.close();
	}

}

import java.sql.*;

/* 
Execute the below statements in the 'mysql' database before running this example:

	DELIMITER |
	CREATE FUNCTION CAL_AVERAGE (n1 INT, n2 INT, n3 INT)
	  RETURNS INT
	   DETERMINISTIC
	    BEGIN
	     DECLARE avg INT;
	     SET avg = (n1+n2+n3)/3;
	     RETURN avg;
	    END

	SELECT CAL_AVERAGE(70,65,65)	
 */

// Using CallableStatement to call a database function.  

public class CallableStatementDemo2 {

	public static void main(String[  ] args) {

		// Step1 : Register or load the driver (type 4 driver is used here) 
		try {
			Class.forName("com.mysql.jdbc.Driver");  // OR DriverManager.registerDriver(new com.mysql.jdbc.Driver( ));
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}   

		// Step2 : Create the connection object
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdemo","root","Gupta_256420"); ) {

			CallableStatement cstmt = con.prepareCall("{ ?  = call cal_average(?,?,?)}");
			cstmt.registerOutParameter(1,Types.INTEGER);
			cstmt.setInt(2,70);
			cstmt.setInt(3,65);
			cstmt.setInt(4,65);			
			cstmt.execute();
			//cstmt.executeUpdate();
			System.out.println("The average of 3 number is "+cstmt.getInt(1));			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

import java.sql.*;
import java.util.*;

/*
Execute the below PL/SQL statements in the 'mysql' database before running this example:

DELIMITER $$

CREATE PROCEDURE AGE
   (IN  START_DATE  DATE,
    IN  END_DATE    DATE,
    OUT YEARS       INTEGER,
    OUT MONTHS      INTEGER,
    OUT DAYS        INTEGER)
BEGIN
   DECLARE NEXT_DATE, PREVIOUS_DATE DATE;
   SET YEARS = 0;
   SET PREVIOUS_DATE = START_DATE;
   SET NEXT_DATE = START_DATE + INTERVAL 1 YEAR;
   WHILE NEXT_DATE < END_DATE DO
      SET YEARS = YEARS + 1;
      SET PREVIOUS_DATE = NEXT_DATE;
      SET NEXT_DATE = NEXT_DATE + INTERVAL 1 YEAR;
   END WHILE;
   SET MONTHS = 0;
   SET NEXT_DATE = PREVIOUS_DATE + INTERVAL 1 MONTH;
   WHILE NEXT_DATE < END_DATE DO
      SET MONTHS = MONTHS + 1;
      SET PREVIOUS_DATE = NEXT_DATE;
      SET NEXT_DATE = NEXT_DATE + INTERVAL 1 MONTH;
   END WHILE;
   SET DAYS = 0;
   SET NEXT_DATE = PREVIOUS_DATE + INTERVAL 1 DAY;
   WHILE NEXT_DATE <= END_DATE DO
      SET DAYS = DAYS + 1;
      SET PREVIOUS_DATE = NEXT_DATE;
      SET NEXT_DATE = NEXT_DATE + INTERVAL 1 DAY;
   END WHILE;
END$$

DELIMITER ;

SET @START = '1993-03-03';
SET @END = '2017-05-13';
CALL AGE (@START, @END, @YEAR, @MONTH, @DAY);
SELECT @START, @END, @YEAR, @MONTH, @DAY;

 */

// Using CallableStatement to call a database stored procedure. 

public class CallableStatementDemo1 {

	public static void main(String[  ] args) {

		// Step1 : Register or load the driver (type 4 driver is used here) 
		try {
			Class.forName("com.mysql.jdbc.Driver");  // OR DriverManager.registerDriver(new com.mysql.jdbc.Driver( ));
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}   

		// Step2 : Create the connection object
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdemo","root","Gupta_256420"); ) {

			CallableStatement cstmt = con.prepareCall("call age(?,?,?,?,?)");

			//Set the calendar to your date of birth 
			Calendar cal = Calendar.getInstance();
			cal.set(2000,0,1);

			java.sql.Date dob = new java.sql.Date(cal.getTimeInMillis());
			java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
			//java.sql.Date now = new java.sql.Date(new java.util.Date( ).getTime());

			cstmt.setDate(1,dob);
			cstmt.setDate(2, now);
								
			cstmt.registerOutParameter(3,Types.INTEGER);
			cstmt.registerOutParameter(4,Types.INTEGER);  
			cstmt.registerOutParameter(5,Types.INTEGER);
									
			cstmt.execute( );			

			System.out.println("Years: "+ cstmt.getInt(3));    
			System.out.println("Months:" + cstmt.getInt(4));
			System.out.println("Days: "+cstmt.getInt(5));						
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
}

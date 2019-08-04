/* 
Execute the below statements in the 'mysql' database before running this example:

create table AccountDetails
(
accountnumber long,
accountbalance double
);

insert into AccountDetails value(101,10000);
insert into AccountDetails value(102,5000);
 */

import java.sql.*;

public class TransactionManagement {

	public static void main(String[ ] args) {

		Connection connection = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");  			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdemo","root","Gupta_256420");
			//connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);				
						
			connection.setAutoCommit(false);  
			
			//In jdbc a new transaction begins when you establish a connection to the database and also after a every call to 
			//either commit or rollback.

			Statement stmt=connection.createStatement();  
			stmt.executeUpdate("update AccountDetails set accountbalance = accountbalance - 2000 where accountnumber=101");  
			stmt.executeUpdate("update AccountDetails set accountbalance = accountbalance + 2000 where accountnumber=102");						

		    connection.commit(); 
		    System.out.println("Money transferred");
		}
		catch(Exception e) {

			System.out.println("Exception occured rolling back transaction"+e.getMessage());

			try {
				connection.rollback();
			}
			catch(SQLException x) {
				System.out.println("Roll back failed"+x.getMessage());
			}
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}               
		}
	}
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Step1 : Register or load the driver (type 4 driver is used here) 
		try {
			Class.forName("com.mysql.jdbc.Driver");  // OR DriverManager.registerDriver(new com.mysql.jdbc.Driver( ));
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}   

		// Step2 : Create the connection object
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdemo","root","Gupta_256420"); ) {

			// Step3 : Create or prepare SQL statement. 
			Statement stmt = con.createStatement( );

			stmt.executeUpdate("insert into students values(6,'Raj kumar',1234599999)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("done");
				
	}
}

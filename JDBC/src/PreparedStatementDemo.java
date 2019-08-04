import java.io.*;
import java.sql.*;

public class PreparedStatementDemo {

	public static void main(String[  ] args) {

		// Step1 : Register or load the driver (type 4 driver is used here) 
		try {
			Class.forName("com.mysql.jdbc.Driver");  // OR DriverManager.registerDriver(new com.mysql.jdbc.Driver( ));
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}   

		// Step2 : Create the connection object
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdemo","root","Gupta_256420"); ) {

			BufferedReader d = new BufferedReader(new InputStreamReader(System.in));

			while(true) {
				System.out.println("Enter student roll number");
				long roll_number = Long.parseLong(d.readLine());
				System.out.println("Enter student name");
				String name = d.readLine();
				System.out.println("Enter student mobile number");
				long mobile = Long.parseLong(d.readLine());

				PreparedStatement pstmt = con.prepareStatement("insert into students values(?,?,?)");						
				pstmt.setLong(1,roll_number);
				pstmt.setString(2,name);
				pstmt.setLong(3,mobile);
																				
				pstmt.executeUpdate( );    //returns the number of database rows affected.				

				System.out.println("Student record added successfully check in database");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

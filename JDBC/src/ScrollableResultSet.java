import java.sql.*;

public class ScrollableResultSet {

	public static void main(String args[  ]) {

		Connection connection = null;

		try { 

			Class.forName("com.mysql.jdbc.Driver");  			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdemo","root","Gupta_256420");

			Statement stmt = connection.createStatement();			
			ResultSet students = stmt.executeQuery("select * from students");

			System.out.println("All student records in reverse order \n");

			//Move the cursor to the after last record 
			students.afterLast();   			

			while(students.previous()) {
				System.out.println("Rollnumber:"+students.getLong(1)+"  Name:"+students.getString(2)+"  Mobile:"+students.getLong(3));			    
			}
						
			//Move the cursor to the before first record			
			students.beforeFirst();

			//Move the cursor to the 2nd row 
			students.absolute(2);
			System.out.println("\nPrinting 2nd row");
			System.out.println("Rollnumber:"+students.getLong(1)+"  Name:"+students.getString(2)+"  Mobile:"+students.getLong(3));

			//Move the cursor 2 rows forward from current position(2nd row)
			students.relative(2);
			System.out.println("\nPrinting 4th row");
			System.out.println("Rollnumber:"+students.getLong(1)+"  Name:"+students.getString(2)+"  Mobile:"+students.getLong(3));
						
			//students.first(); - Moves the cursor to the first row 
			//students.last(); - Moves the cursor to the last row 
		}
		catch(Exception e) {
			e.printStackTrace();			
		}
	}
}

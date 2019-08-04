/* Which Driver should be used when ? 
		
1. If you are accessing one type of database, such as Oracle, Sybase, or IBM, the preferred driver type is 4.

2. If your Java application is accessing multiple types of databases at the same time, type 3 is the preferred driver.

3. Type 2 drivers are useful in situations, where a type 4 driver is not available yet for your database.

4. The type 1 driver is not considered a deployment-level driver, and is typically used for development and testing purposes only.
*/

import java.io.*;
import java.sql.*;

public class Type1Driver {

	public static void main(String[  ] args) {

		Connection connection = null;

		try {
						
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver( ));
			
			//Control Panel\System and Security\Administrative Tools
			connection = DriverManager.getConnection("jdbc:odbc:testdsn");

			BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the student roll number that you want to delete");
			long roll_number = Long.parseLong(d.readLine());

			PreparedStatement pstmt = connection.prepareStatement("delete from students where Rollnumber = ?");						
			pstmt.setLong(1,roll_number);			
			pstmt.executeUpdate( );    

			System.out.println("Student record deleted successfully");  			 			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{				
				connection.close();
			}
			catch(Exception e) {
				e.printStackTrace();				
			}
		}				
	}
}

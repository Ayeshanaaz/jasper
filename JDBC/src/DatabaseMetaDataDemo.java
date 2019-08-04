import java.sql.*;

// DatabaseMetaData is used to find information about database. 

class DatabaseMetaDataDemo {

	public static void main(String args[  ]) {

		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");  			
			con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdemo","root","Gupta_256420");

			//get the information about the database into DatabaseMetaData
			DatabaseMetaData dbmd=con.getMetaData();  

			//display information about the database 
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());
			System.out.println("Driver major version: "+dbmd.getDriverMajorVersion());
			System.out.println("Driver minor version: "+dbmd.getDriverMinorVersion());  			 
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
			System.out.println("URL of database: "+dbmd.getURL());
			System.out.println("Current user name:"+dbmd.getUserName());
			System.out.println("Date time functions "+dbmd.getTimeDateFunctions());

			System.out.println("\n==========TABLES=============");
			String types[ ] = {"TABLE"};
			ResultSet rs = dbmd.getTables(null, null, null,types);
			while(rs.next()) {
				System.out.println(rs.getString("TABLE_NAME"));
			}

			System.out.println("\n==========VIEWS =============");
			String types2[ ] = {"VIEW"};
			ResultSet r = dbmd.getTables(null, null, null,types2);
			while(r.next()) {
				System.out.println(r.getString("TABLE_NAME"));
			}
		}		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}  
	}  
}

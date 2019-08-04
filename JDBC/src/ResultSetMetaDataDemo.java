import java.sql.*;

// ResultSetMetaData is used to find information about result set 

class ResultSetMetaDataDemo {

	public static void main(String args[ ]) {

		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");  			
			con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdemo","root","Gupta_256420");

			PreparedStatement ps = con.prepareStatement("select RollNumber,Mobile from students");
			ResultSet rs=ps.executeQuery();  

			ResultSetMetaData rsmd=rs.getMetaData();

			System.out.println("Total columns: "+rsmd.getColumnCount());

			for(int i =1;i<=rsmd.getColumnCount();i++) {
				System.out.println("\nColumn number: "+i);
				System.out.println("========================");
				System.out.println("Column name = "+rsmd.getColumnName(i));
				System.out.println("Column type = "+rsmd.getColumnTypeName(i));
				System.out.println("Column width ="+rsmd.getColumnDisplaySize(i));				
				System.out.println("Is currency ="+rsmd.isCurrency(i));
				System.out.println("Is read only = "+rsmd.isReadOnly(i));
				System.out.println("Is searchable ="+rsmd.isSearchable(i));
				System.out.println("Is signed ="+rsmd.isSigned(i));				
			}			
		}
		catch(Exception e) { 		
			e.printStackTrace();			
		}  
		finally {
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}  
}

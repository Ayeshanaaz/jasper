import java.sql.*;

public class UpdatableResultSet {

	public static void main(String args[  ]) {

		Connection connection = null;

		try { 

			Class.forName("com.mysql.jdbc.Driver");  			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdemo","root","Gupta_256420");

			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);					
			ResultSet students = stmt.executeQuery("select * from students");

			//INSERT a new record 
			students.moveToInsertRow();
			students.updateLong(1,305644);
			students.updateString(2,"Bharath");
			students.updateLong(3,1234567890L);
			students.insertRow();

			students.moveToCurrentRow();

			//UPDATE 1st record
			students.absolute(1);
			students.updateLong(3,9052249176L);
			students.updateRow();

			//DELETE 4th record
			students.absolute(4);
			students.deleteRow();
			
			students.beforeFirst();
			
			while(students.next()) {
				System.out.println("Rollnumber:"+students.getLong(1)+"  Name:"+students.getString(2)+"  Mobile:"+students.getLong(3));						
			}	
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

import java.sql.*;
import javax.sql.rowset.*;

public class CachedRowSetExample {

	public static void main(String[ ] args) {

		Connection conn = null;
		CachedRowSet crs = null;

		try {

			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Gupta_256420");

			//Creating and Executing RowSet  
			crs = RowSetProvider.newFactory().createCachedRowSet();
			crs.setUrl("jdbc:postgresql://localhost:5432/postgres");  
			crs.setUsername("postgres");  
			crs.setPassword("Gupta_256420");  

			conn.setAutoCommit(false);  // Need to disable auto-commit for CachedRowSet

			crs.setCommand("SELECT * FROM students");
			int[ ] keys = {1};  // Set column 1 as the key column in the RowSet
			crs.setKeyColumns(keys);
			crs.execute(conn);  // execute on the Connection

			// Update a row
			crs.first();
			crs.updateLong(3,777777777L);
			crs.updateRow();  // update the row	

			crs.moveToInsertRow();
			crs.updateLong(1,11);
			crs.updateString(2,"Pratap");
			crs.updateLong(3,9999988888L);

			crs.insertRow();

			// need to move away from insert row before apply changes
			crs.moveToCurrentRow();

			// Reconnect to database to apply changes			
			crs.acceptChanges(conn);
			System.out.println("Done");

		} 
		catch(Exception ex) {
			ex.printStackTrace();
		} 

		finally {

			try {
				crs.close();
				conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}

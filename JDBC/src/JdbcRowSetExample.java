import javax.sql.*;  
import javax.sql.rowset.*;

/*Advantages of RowSet 
1.It is easy and flexible to use
2.It is scrollable and updatable by default
3.It supports events
4.CachedRowSet can work in disconnected environment to avoid database network traffic.   
*/

public class JdbcRowSetExample {

	public static void main(String[  ] args) throws Exception {

		Class.forName("org.postgresql.Driver");  

		//Creating and Executing RowSet  
		JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();  
		rowSet.setUrl("jdbc:postgresql://localhost:5432/postgres");  
		rowSet.setUsername("postgres");  
		rowSet.setPassword("Gupta_256420");  

		rowSet.setCommand("select * from students");   //insert,update,delete statements are not allowed, only select is allowed.  
		rowSet.execute();  
		 
		rowSet.addRowSetListener(new MyListener());  

		while (rowSet.next()) {  			
			System.out.println("Id: " + rowSet.getString(1));  
			System.out.println("Name: " + rowSet.getString(2));  
			System.out.println("Salary: " + rowSet.getString(3));  
		}
		
		rowSet.absolute(1);
		rowSet.updateLong(3,1234567890L);
		rowSet.updateRow();		
		
		rowSet.setCommand("select * from AccountDetails where accountnumber = ?");  
		rowSet.setInt(1,103);
		rowSet.execute();  
        rowSet.next();
        System.out.println("Account holder name is "+rowSet.getString(1));
                		
	}  
}  

class MyListener implements RowSetListener {  

	public void cursorMoved(RowSetEvent event) {  
		System.out.println("Cursor Moved...");  
	}  
	public void rowChanged(RowSetEvent event) {  
		System.out.println("Row Changed...");  
	}  
	public void rowSetChanged(RowSetEvent event) {  
		System.out.println("RowSet changed...");  
	}

}  

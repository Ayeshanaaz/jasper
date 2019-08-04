//Batch processing using Statement.

import java.sql.*;

class BatchProcessing {

	public static void main(String args[ ])throws Exception {

		Connection con = null;

		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Gupta_256420");
		con.setAutoCommit(false);  

		Statement stmt = con.createStatement();  
		stmt.addBatch("insert into students values(1,'Rajesh',123456)");  
		stmt.addBatch("insert into students values(2,'umesh',789012)");
		stmt.addBatch("insert into students values(3,'umesh',4567733)"); 
		stmt.addBatch("insert into students values(4,'umesh',8777777)"); 

		stmt.executeBatch();
        System.out.println("Done");
		con.commit();  
		con.close();  
	}
}  

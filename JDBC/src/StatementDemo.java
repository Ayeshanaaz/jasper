import java.sql.*;
import java.lang.System;

/* 
Execute the below statements in the 'mysql' database before running this example:

create database jdbcdemo;

use jdbcdemo;

create table students 
(
Rollnumber bigint primary key,
Name varchar(100) not null,
Mobile bigint
);

insert into students values(1,'Vimal',1234512345);
insert into students values(2,'Kishore',5432112345);
insert into students values(3,'Karthik',5555555);
insert into students values(4,'Naveen',984412345);
insert into students values(5,'Nithin',908864791);
 */

public class StatementDemo {

	public static void main(String[  ] args) {
	
		// Step1 : Register or load the driver (type 4 driver is used here) 
		try {
			Class.forName("com.mysql.jdbc.Driver");  // OR DriverManager.registerDriver(new com.mysql.jdbc.Driver( ));
		} catch (ClassNotFoundException e1) {			
			e1.printStackTrace();
		}   
				
		// Step2 : Create the connection object
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdemo","root","root"); ) {

			// Step3 : Create or prepare SQL statement. 
			Statement stmt = con.createStatement( );

			// Step4 : Execute the sql statement
			ResultSet rs = stmt.executeQuery("select * from students");
																																								
			//System.out.println(students.getLong(1));

			//Fetch 20 rows each time from database. 
			rs.setFetchSize(20);
			
			//rs.getLong(1); //sqlexception

			System.out.println("All students");
						
			// Step5 : Retrieve the results. 
			while(rs.next()) {
				System.out.println("Rollnumber:"+rs.getLong(1)+"  Name:"+rs.getString(2)+"  Mobile:"+rs.getLong(3));						
			}						
		}
		catch(SQLException e) {			
			e.printStackTrace();
		}		
	}		
}

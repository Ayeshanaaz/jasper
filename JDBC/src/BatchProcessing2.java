//Batch processing using prepared statement

import java.sql.*;  
import java.io.*; 

class BatchProcessing2 {

	public static void main(String args[]) {

		try{  

			Connection con = null;

			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Gupta_256420");

			PreparedStatement ps=con.prepareStatement("insert into students values(?,?,?)");  

			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			while(true){  

				System.out.println("Enter roll number");  
				String s1=br.readLine();  
				int id=Integer.parseInt(s1);  

				System.out.println("Enter name");  
				String name=br.readLine();  

				System.out.println("Enter mobile number");  
				String s3=br.readLine();  
				int mobile=Integer.parseInt(s3);  

				ps.setInt(1,id);  
				ps.setString(2,name);  
				ps.setInt(3,mobile);  

				ps.addBatch();  
				System.out.println("Want to add more records y/n");  
				String ans=br.readLine();  
				if(ans.equals("n")){  
					break;  
				}  

			}  
			ps.executeBatch();  

			System.out.println("Record(s) successfully saved");  

			con.close();

		}
		catch(Exception e) { System.out.println(e); }  

	}
}  

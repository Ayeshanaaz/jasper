import java.io.*;
import java.sql.*;

/* 
Execute the below statements in the 'mysql' database before running this example:

create table StoreFiles
(
file LONGTEXT,
no int
);
*/

public class SavingFiles {

	public static void main(String[ ] args) {

		Connection connection = null;

		try {			 
			Class.forName("com.mysql.jdbc.Driver");   			 
			connection = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdemo","root","Gupta_256420");

			PreparedStatement stmt = connection.prepareStatement("insert into StoreFiles values(?,1)");

			//load the file into File object
			File f = new File("myfile.txt");

			//connect the file to file reader for reading
			FileReader fr = new FileReader(f);

			//store the file into column1 as character stream
			stmt.setCharacterStream(1, fr, (int)f.length());

			stmt.executeUpdate();
			System.out.println("File saved successfully to database");

			Statement s = connection.createStatement();

			//read table rows into ResultSet
			ResultSet rs = s.executeQuery("select * from StoreFiles");

			//go to first row
			rs.next( );

			//read data from column1
			Clob c = rs.getClob(1);

			//read file data from c and store into Reader object
			Reader r = c.getCharacterStream();

			//read data from Reader and write into newfile.txt
			int ch;
			FileWriter fw = new FileWriter("C:\\jdbctest\\sample.txt");
			while((ch = r.read()) != -1) {
				fw.write((char)ch);
			}			
			System.out.println("File retrieved from database and stored in C:\\sample.txt");
			fw.close( );			
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
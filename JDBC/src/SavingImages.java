/* 
Execute the below statements in the 'mysql' database before running this example:

create table StoreImages
(
photo longblob,
no int
);
*/

import java.sql.*;
import java.io.*;

public class SavingImages {

	public static void main(String[ ] args) {

		Connection connection = null;

		try {			 
			Class.forName("com.mysql.jdbc.Driver");   			 
			connection = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdemo","root","Gupta_256420");

			PreparedStatement stmt = connection.prepareStatement("insert into StoreImages values(?,4566)");

			//Load the image into a file object
			File image = new File("Penguins.jpg");

			//Attach the file to FileInputStream for reading the image
			FileInputStream fis = new FileInputStream(image);

			//Write the file contents into the table 
			stmt.setBinaryStream(1,fis,(int)image.length( ));			

			stmt.executeUpdate();

			System.out.println("Imaged saved successfully into the database");

			Statement s = connection.createStatement();			
			ResultSet rs = s.executeQuery("select * from StoreImages");
			rs.next();

			//get the image from the table into Blob object 			
			Blob b = rs.getBlob(1);

			//store the blob object into the byte array 
			byte b1[ ] = b.getBytes(1, (int)b.length());

			//Write this byte array into a file: output.jpg
			FileOutputStream fos = new FileOutputStream("C:\\jdbctest\\output.jpg");
			fos.write(b1);			
			System.out.println("Image retrived from database and stored in C:\\output.jpg");
			fos.close();
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

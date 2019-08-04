package com.virtusa.zomato.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.virtusa.zomato.exception.ZomatoException;

public class ConnectionUtil {
	public ConnectionUtil() {
		
	}
	
	private static Logger logger=Logger.getLogger("ConnectionUtil");
	
	public static Connection getConnection() throws ZomatoException{

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error("driver error", e);
		 throw new ZomatoException("Driver is not available ");		
		}
       Connection connection=null;;
try {
	connection = DriverManager.getConnection("jdbc:mysql://localhost/zomato", "root", "root");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	logger.error("SQL  error", e);
	throw new ZomatoException("Connection is not avaialble ");
}	
		return connection;
			
	}
	
	
	
	

}

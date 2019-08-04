package com.virtusa.payroll.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.virtusa.payroll.exception.PayrollException;




public class ConnectionUtil {

	public ConnectionUtil() {
		// TODO Auto-generated constructor stub
	}
	private static Logger logger=Logger.getLogger("ConnectionUtil");
	public static Connection getConnection() throws PayrollException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			logger.info("driver error",e);
			throw new PayrollException("Driver is not available ");		
		}
		Connection connection=null;
	   	try {
	   		connection = DriverManager.getConnection("jdbc:mysql://localhost/payrolldb", "root", "root");
	   	}
	   	catch (SQLException e) {
	   		logger.info("conection error",e);
	   		throw new PayrollException("Connection is not avaialble ");
	   	}	
		return connection;
	}
}

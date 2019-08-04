package com.virtusa.payroll.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.virtusa.payroll.exception.PayrollException;




public class ConnectionUtil {
private ConnectionUtil(){
	
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
	public static void closeConnection(PreparedStatement preparedStatement,ResultSet resultSet,Connection connection) throws  PayrollException{
		if(preparedStatement!=null){
			try {
				preparedStatement.close();
			} catch (SQLException e) {

					throw new PayrollException();
			}
		}
		if(resultSet!=null){
			try {
				resultSet.close();
			}catch (SQLException e) {

				throw new PayrollException();
			}
		}
		if(connection!=null){
			try {
				connection.close();
			}  catch (SQLException e) {

				throw new PayrollException();
			}
		}
		
		
	}
	public static void closeConnection(PreparedStatement preparedStatement,Connection connection) throws PayrollException{
		
		if(preparedStatement!=null){
			try {
				preparedStatement.close();
			} catch (SQLException e) {

					throw new PayrollException();
			}
		}
		
		if(connection!=null){
			try {
				connection.close();
			}  catch (SQLException e) {

				throw new PayrollException();
			}
		}
		
		
		
	}
	
	
}

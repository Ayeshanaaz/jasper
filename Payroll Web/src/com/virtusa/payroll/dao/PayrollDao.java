package com.virtusa.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.virtusa.payroll.exception.PayrollException;
import com.virtusa.payroll.model.BenefitDetail;
import com.virtusa.payroll.model.Employee;
import com.virtusa.payroll.model.Investment;
import com.virtusa.payroll.model.LoginDetail;
import com.virtusa.payroll.model.PayrollData;
import com.virtusa.payroll.model.Reimbursement;
import com.virtusa.payroll.model.Salary;
import com.virtusa.payroll.model.Security;

import com.virtusa.payroll.service.IPayroll;
import com.virtusa.payroll.util.ConnectionUtil;

public class PayrollDao implements IPayroll {
String l="Some internal error contact to admin";
	public PayrollDao() {
		//payrollDao
	}
	Logger logger=Logger.getLogger("PayrollDao");
	@Override
	public int doLoginCheck(LoginDetail loginDetail) throws PayrollException {
		int flag = 0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;
		try {
			
			preparedStatement = connection.prepareStatement("select emp_id,emp_password from employee where emp_id=? and emp_password=?");
			preparedStatement.setString(1, loginDetail.getUsername());
			preparedStatement.setString(2, loginDetail.getPassword());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				flag = 1;
			}
		} catch (SQLException e) {
			throw new PayrollException(l);
		}
		finally{
		logger.info("closed");
			ConnectionUtil.closeConnection(preparedStatement,resultSet, connection);
		}
		return flag;
	}

	@Override
	public int doFirstUserCheck(int employeeId) throws PayrollException {
		int flag = 0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;
		try {
			preparedStatement = connection.prepareStatement("select sec_id from security where sec_id=" + employeeId);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				flag = 1;
			}
		} catch (SQLException e) {
			throw new PayrollException(l);
		}
		finally{
			ConnectionUtil.closeConnection(preparedStatement,resultSet, connection);
		}
		return flag;
	}

	@Override
	public int createSecurityCheck(Security securityDetail) throws PayrollException {

		int flag = 0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			logger.info(connection);
			preparedStatement = connection.prepareStatement("insert into security values(?,?,?)");

			preparedStatement.setInt(1, securityDetail.getsecId());
			preparedStatement.setString(2, securityDetail.getsecQuestion());
			preparedStatement.setString(3, securityDetail.getsecAns());
			flag=preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			throw new PayrollException();
		}
		finally{
			ConnectionUtil.closeConnection(preparedStatement, connection);
		}

		return flag;
	}

	@Override
	public int doSecurityCheck(Security securityDetail) throws PayrollException {
		int flag = 0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;
		try {
			preparedStatement = connection.prepareStatement("select sec_ans from security where sec_id=? and sec_ans=?");
			preparedStatement.setInt(1, securityDetail.getsecId());
			preparedStatement.setString(2, securityDetail.getsecAns());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				flag = 1;
			}
		} catch (SQLException e) {
			throw new PayrollException(l);
		}
		finally{
			ConnectionUtil.closeConnection(preparedStatement,resultSet, connection);
		}
		
		return flag;
	}

	@Override
	public int updatePassword(LoginDetail loginDetail) throws PayrollException {
		int flag = 0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			logger.info(connection);
			preparedStatement = connection.prepareStatement("update employee set empPassword=? where empId=?");

			preparedStatement.setString(1, loginDetail.getPassword());
			preparedStatement.setString(2, loginDetail.getUsername());

			flag=preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			throw new PayrollException();
		}
		finally{
			ConnectionUtil.closeConnection(preparedStatement, connection);
		}
		return flag;

	}

	@Override
	public String retrieveResult(int empId) throws PayrollException {
		String question = "";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
	
		try {
			preparedStatement = connection.prepareStatement("select sec_question from security where sec_id=?");
			preparedStatement.setInt(1, empId);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				question = resultSet.getString("sec_question");
			}
		} catch (SQLException e) {
			throw new PayrollException(l);
		}
		finally{
			ConnectionUtil.closeConnection(preparedStatement, connection);
		}
		return question;

	}

	@Override
	public int checkEmployeeId(int empId) throws PayrollException {
		int flag = 0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;
		try {
			preparedStatement = connection.prepareStatement("select secId from security where secId=?");
			preparedStatement.setInt(1, empId);

			 resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				flag = 1;
			}
		} catch (SQLException e) {
			throw new PayrollException(l);
		}
		finally{
			ConnectionUtil.closeConnection(preparedStatement,resultSet, connection);
		}
		
		return flag;
	}

	@Override
	public Employee viewDetails(int empid) throws PayrollException 
	{
		ResultSet resultSet=null;

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		Employee employeeDetails=new Employee();
			
			try {
				logger.info(connection);
				preparedStatement = connection.prepareStatement("select * from employee where empId="+empid);
				resultSet= preparedStatement.executeQuery();
				if (resultSet.next()) 
				{		
					logger.info("found");
					employeeDetails.setempName(resultSet.getString("empName"));
					employeeDetails.setempGender(resultSet.getString("empGender"));
					
					employeeDetails.setempAddress(resultSet.getString("empAddress"));
					
					employeeDetails.setempContact(resultSet.getInt("empContact"));
					employeeDetails.setempPan(resultSet.getString("empPan"));
					employeeDetails.setempEmail(resultSet.getString("empMail"));
					
				}



			} 
			catch (SQLException e)
			{
				

				throw new PayrollException(e.getMessage());
			}
			finally{
				ConnectionUtil.closeConnection(preparedStatement,resultSet, connection);
			}
			
			return employeeDetails;
		}

	@Override
	public int updateDetails(Employee employeeDetails1) throws PayrollException {
		int flag=0;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		logger.info(employeeDetails1);
		try{
			logger.info(connection);
			preparedStatement = connection.prepareStatement(
					"update employee set empName=?,empGender=?,empAddress=?,empContact=?,empPan=?,empMail=? where empId=?"	);
			preparedStatement.setInt(7, employeeDetails1.getempId());

			preparedStatement.setString(1, employeeDetails1.getempName());
			preparedStatement.setString(2, employeeDetails1.getempGender());
			
			preparedStatement.setString(3, employeeDetails1.getempAddress());
			preparedStatement.setInt(4, employeeDetails1.getempContact());
			preparedStatement.setString(5, employeeDetails1.getempPan());
			preparedStatement.setString(6, employeeDetails1.getempEmail());
			flag=preparedStatement.executeUpdate();
			logger.info(flag);

		}catch (SQLException e) {
			

			throw new PayrollException(e.getMessage());
		} 
		finally{
			ConnectionUtil.closeConnection(preparedStatement, connection);
		}
		return flag;

	}

	@Override
	public String viewPayslip(PayrollData payrollData) throws PayrollException {
		String path = "";
		ResultSet resultSet = null;

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			logger.info(connection);
			preparedStatement = connection.prepareStatement(
					"select pay_details from payroll_data where pay_emp_fk=? and pay_month=? and pay_year=?");
			logger.info(payrollData.getEmployee().getempId());
			logger.info(payrollData.getpayMonth());
			logger.info(payrollData.getpayYear());
			preparedStatement.setInt(1, payrollData.getEmployee().getempId());
			preparedStatement.setString(2, payrollData.getpayMonth());
			preparedStatement.setInt(3, payrollData.getpayYear());
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				
				path = resultSet.getString("pay_details");
				logger.info("path is " + path);
			}

		} catch (SQLException e) {
			throw new PayrollException();
		}
		finally{
			ConnectionUtil.closeConnection(preparedStatement,resultSet, connection);
		}

		return path;
	}

	@Override
	public Salary viewCtc(int employeeId) throws PayrollException {
		

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Salary salaryDetail = new Salary();
		try {
			logger.info(connection);
			preparedStatement = connection.prepareStatement(
					"select s.* from Salary s join Employee e on  s.sal_id=e.emp_sal_fk where e.emp_id=" + employeeId);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				salaryDetail.setsalpackage(resultSet.getInt(2));
				salaryDetail.setsalBasic(resultSet.getFloat(3));
				salaryDetail.setsalHra(resultSet.getFloat(4));
				salaryDetail.setsalBonus(resultSet.getFloat(5));
				salaryDetail.setsalAllowance(resultSet.getFloat(6));
			
			}

		} catch (SQLException e) {
			throw new PayrollException();
		}
		finally{
			ConnectionUtil.closeConnection(preparedStatement,resultSet, connection);
		}
		return salaryDetail;

	}

	@Override
	public int doInvestmentDeclaration(int empId, Investment investment) throws PayrollException {
		int flag = 0;
		ResultSet resultSet=null;
		Connection connection = ConnectionUtil.getConnection();
		Connection connection2= ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement retrieveStatement = null;
		try {
			logger.info(connection);
			logger.info(connection2);
				retrieveStatement=connection2.prepareStatement("select * from investment where inv_emp_fk="+empId);
				resultSet=retrieveStatement.executeQuery();
				
			
			
			
			
			preparedStatement = connection.prepareStatement(
					"update investment set inv_insurance=?,inv_eduloan=?,inv_ppf=?,inv_loan=? where inv_emp_fk=?");
			if(resultSet.next()){
				if(investment.getinvInsurance()!=null){
					preparedStatement.setString(1, investment.getinvInsurance());
				}
				else{
					preparedStatement.setString(1, resultSet.getString(3));
				}
				if(investment.getinvEduloan()!=null){
					preparedStatement.setString(2, investment.getinvEduloan());
				}
				else{
					preparedStatement.setString(2, resultSet.getString(4));
				}
				if(investment.getinvPpf()!=null){
					preparedStatement.setString(3, investment.getinvPpf());
				}
				else{
					preparedStatement.setString(3, resultSet.getString(5));
				}
				if(investment.getinvLoan()!=null){
					preparedStatement.setString(4, investment.getinvLoan());
				}
				else{
					preparedStatement.setString(4,resultSet.getString(6));
				}
				preparedStatement.setInt(5, empId);
			}
			flag = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			throw new PayrollException();
		}
		finally{
			ConnectionUtil.closeConnection(preparedStatement, connection);
			ConnectionUtil.closeConnection(retrieveStatement,resultSet, connection2);
		}
		return flag;

	}

	@Override
	public int claimReimbursement(int empId,Reimbursement reimbursement) throws PayrollException {
		int flag = 0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			logger.info(connection);
			preparedStatement = connection
					.prepareStatement("insert into reimbursement(re_emp_fk,re_type,re_amount,re_path) values(?,?,?,?)");

			
			preparedStatement.setString(2, reimbursement.getreType());
			preparedStatement.setFloat(3, reimbursement.getreAmount());
			preparedStatement.setString(4, reimbursement.getrePath());
			preparedStatement.setInt(1, empId);
		
			flag=preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			throw new PayrollException();
		}
		finally{
			ConnectionUtil.closeConnection(preparedStatement, connection);
		}

		return flag;

	}
	@Override
	public BenefitDetail getBenefitDetails(int employeeId) throws PayrollException {
		ResultSet resultSet = null;

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;

		BenefitDetail employeeBenefitDetails = new BenefitDetail();
		try {
			logger.info(connection);
			preparedStatement = connection.prepareStatement("select * from benefits where ben_emp_fk=" + employeeId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employeeBenefitDetails.setbenLta(resultSet.getFloat(3));
				employeeBenefitDetails.setbenPhone(resultSet.getFloat(4));
				employeeBenefitDetails.setbenChildfee(resultSet.getFloat(5));
				employeeBenefitDetails.setbenFood(resultSet.getFloat(6));
			}

		} catch (SQLException e) {
			throw new PayrollException();
		}
		finally{
			ConnectionUtil.closeConnection(preparedStatement,resultSet, connection);
		}
		return employeeBenefitDetails;
	}

	@Override
	public int changeBenefitDetail(BenefitDetail benefits) throws PayrollException {

		int flag = 0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			logger.info(connection);
			preparedStatement = connection.prepareStatement(
					"update Benefits set ben_lta=?,ben_phone=?,ben_childfee=?,ben_food=? where ben_emp_fk="
							+ benefits.getEmployee().getempId());

			logger.info("Statement");
			preparedStatement.setFloat(1, benefits.getbenLta());
			preparedStatement.setFloat(2, benefits.getbenPhone());
			preparedStatement.setFloat(3, benefits.getbenChildfee());
			preparedStatement.setFloat(4, benefits.getbenFood());
			flag=preparedStatement.executeUpdate();
		
		} catch (SQLException e) {
			throw new PayrollException();
		}
		finally{
			ConnectionUtil.closeConnection(preparedStatement, connection);
		}
		return flag;

	}

}

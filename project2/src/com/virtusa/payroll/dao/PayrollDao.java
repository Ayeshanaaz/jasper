package com.virtusa.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import com.virtusa.payroll.exception.PayrollException;
import com.virtusa.payroll.model.BenefitDetail;
import com.virtusa.payroll.model.Employee;
import com.virtusa.payroll.model.Investment;
import com.virtusa.payroll.model.LoginDetail;
import com.virtusa.payroll.model.PayrollData;
import com.virtusa.payroll.model.Reimbursement;
import com.virtusa.payroll.model.Salary;
import com.virtusa.payroll.model.Security;
import com.virtusa.payroll.model.SecurityDetail;
import com.virtusa.payroll.service.IPayroll;
import com.virtusa.payroll.util.ConnectionUtil;

public class PayrollDao implements IPayroll {

	public PayrollDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int doLoginCheck(LoginDetail loginDetail) throws PayrollException {
		int flag=0;
		Connection connection =ConnectionUtil.getConnection();
		PreparedStatement preparedStatement=null;
		try{
			preparedStatement=connection.prepareStatement("select emp_id,emp_password from employee where emp_id=? and emp_password=?");
			preparedStatement.setString(1, loginDetail.getUsername());
			preparedStatement.setString(2,loginDetail.getPassword());
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				flag=1;
			}
		}
		catch(SQLException e){
			throw new PayrollException("Some internal error contact to admin");
		}
		return flag;
	}
	
	
	@Override
	public int doFirstUserCheck(int employeeId) throws PayrollException {
		int flag=0;
		Connection connection =ConnectionUtil.getConnection();
		PreparedStatement preparedStatement=null;
		try{
			preparedStatement=connection.prepareStatement("select sec_id from security where sec_id="+employeeId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				flag=1;
			}
		}
		catch(SQLException e){
			throw new PayrollException("Some internal error contact to admin");
		}
		return flag;
	}
	
	@Override
	public int createSecurityCheck(Security securityDetail) throws PayrollException {
		
		int flag=0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try{
			System.out.println(connection);
			preparedStatement = connection.prepareStatement(
					"insert into security values(?,?,?)"
			);
			
			preparedStatement.setInt(1, securityDetail.getSec_id());
			preparedStatement.setString(2, securityDetail.getSec_question());
			preparedStatement.setString(3, securityDetail.getSec_ans());
			preparedStatement.executeUpdate();
			flag=1;
		}
		catch(SQLException e){
			throw new PayrollException();
		}
		
		
		return flag;
	}

	@Override
	public int doSecurityCheck(SecurityDetail securityDetail) throws PayrollException {
		int flag=0;
		Connection connection =ConnectionUtil.getConnection();
		PreparedStatement preparedStatement=null;
		try{
			preparedStatement=connection.prepareStatement("select sec_question,sec_ans from security where sec_question=? and sec_ans=?");
			preparedStatement.setString(1, securityDetail.getQuestion());
			preparedStatement.setString(2,securityDetail.getPassword());
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				flag=1;
			}
		}
		catch(SQLException e){
			throw new PayrollException("Some internal error contact to admin");
		}
		return flag;
	}

	@Override
	public int updatePassword(LoginDetail loginDetail) throws PayrollException {
		int flag=0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try{
			System.out.println(connection);
			preparedStatement = connection.prepareStatement(
					"update employee set emp_password=? where emp_id=?"
			);
			
			preparedStatement.setString(1, loginDetail.getPassword());
			preparedStatement.setString(2, loginDetail.getUsername());
			
			preparedStatement.executeUpdate();
			flag=1;
		}
		catch(SQLException e){
			throw new PayrollException();
		}
		
		
		return flag;
		
	}

	@Override
	public Employee viewDetails(int employeeId) throws PayrollException {
		ResultSet resultSet=null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		Employee employeeDetails=new Employee();
		try{
			System.out.println(connection);
			preparedStatement = connection.prepareStatement("select * from employee where emp_id="+employeeId);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				employeeDetails.setEmp_name(resultSet.getString(1));
				employeeDetails.setEmp_pan(resultSet.getString(2));
			}
			
		}
		catch(SQLException e){
			throw new PayrollException();
		}
		
		
		return employeeDetails;
	}

	@Override
	public int updateDetails(Employee employee) throws PayrollException {
		int flag=0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try{
			System.out.println(connection);
			preparedStatement = connection.prepareStatement(
					"update employee set emp_password=?,emp_pan=? where emp_id=?"
			);
			
			
			preparedStatement.setString(1, employee.getEmp_password());
			preparedStatement.setString(2, employee.getEmp_pan());
			preparedStatement.setInt(3, employee.getEmp_id());
			preparedStatement.executeUpdate();
			flag=1;
		}
		catch(SQLException e){
			throw new PayrollException();
		}
		
		
		return flag;
		
	}

	@Override
	public String viewPayslip(PayrollData payrollData) throws PayrollException {
		String path="";
		ResultSet resultSet=null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		
		try{
			System.out.println(connection);
			preparedStatement = connection.prepareStatement("select pay_details from payroll_data where pay_emp_fk=? and pay_month=? and pay_year=?");
			System.out.println(payrollData.getEmployee().getEmp_id());
			System.out.println(payrollData.getPay_month());
			System.out.println(payrollData.getPay_year());
			preparedStatement.setInt(1, payrollData.getEmployee().getEmp_id());
			preparedStatement.setString(2,payrollData.getPay_month());
			preparedStatement.setInt(3,payrollData.getPay_year());
			resultSet=preparedStatement.executeQuery();
			System.out.println("hai");
			if(resultSet.next()){
				System.out.println("hai");
				path=resultSet.getString("pay_details");
			}
			
		}
		catch(SQLException e){
			throw new PayrollException();
		}
		
		return path;
	}

	@Override
	public Salary viewCtc(int employeeId) throws PayrollException {
		// TODO Auto-generated method stub
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;
		Salary salaryDetail=new Salary();
		try{
			System.out.println(connection);
			preparedStatement = connection.prepareStatement(
					"select s.* from Salary s join Employee e on  s.sal_id=e.emp_sal_fk where e.emp_id="+employeeId
			);
			
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				salaryDetail.setSal_package(resultSet.getInt(2));
				salaryDetail.setSal_basic(resultSet.getFloat(3));
				//employeeDetails.setEmp_pan(resultSet.getString(2));
			}
			
			
		}
		catch(SQLException e){
			throw new PayrollException();
		}
		
		
		return salaryDetail;

		
		//return 0;
	}

	@Override
	public int doInvestmentDeclaration(int emp_id,Investment investment) throws PayrollException {
		int flag=0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try{
			System.out.println(connection);
			preparedStatement = connection.prepareStatement(
					"update investment set inv_insurance=?,inv_eduloan=?,inv_ppf=?,inv_loan=? where inv_emp_fk=?"
			);
			
			
			preparedStatement.setString(1, investment.getInv_insurance());
			preparedStatement.setString(2, investment.getInv_eduloan());
			preparedStatement.setString(3, investment.getInv_ppf());
			preparedStatement.setString(4, investment.getInv_loan());
			preparedStatement.setInt(5, emp_id);
			preparedStatement.executeUpdate();
			flag=1;
			
		}
		catch(SQLException e){
			throw new PayrollException();
		}
		
		return flag;
		
	
	}

	@Override
	public int claimReimbursement(Reimbursement reimbursement) throws PayrollException {
		int flag=0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try{
			System.out.println(connection);
			preparedStatement = connection.prepareStatement(
					"insert into reimbursement(re_emp_fk,re_type,re_amount,re_path) values(?,?,?,?)"
			);
			
			
			preparedStatement.setInt(1, reimbursement.getEmployee().getEmp_id());
			preparedStatement.setString(2, reimbursement.getRe_type());
			preparedStatement.setFloat(3, reimbursement.getRe_amount());
			preparedStatement.setString(4, reimbursement.getRe_path());
			
			preparedStatement.executeUpdate();
			flag=1;
		}
		catch(SQLException e){
			throw new PayrollException();
		}
		
		
		return flag;
	
	}

	@Override
	public int changeBenefitDetail(BenefitDetail benefits) throws PayrollException {
		// TODO Auto-generated method stub
		int flag=0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try{
			System.out.println(connection);
			preparedStatement = connection.prepareStatement(
					"update Benefits set ben_lta=?,ben_phone=?,ben_childfee=?,ben_food=? where ben_emp_fk="+benefits.getEmployee().getEmp_id()
			);
			
			System.out.println("Statement");
			preparedStatement.setFloat(1,benefits.getBen_lta()); 
			preparedStatement.setFloat(2,benefits.getBen_phone() );
			preparedStatement.setFloat(3, benefits.getBen_childfee());
			preparedStatement.setFloat(4, benefits.getBen_food());
			preparedStatement.executeUpdate();
			flag=1;
		}
		catch(SQLException e){
			throw new PayrollException();
		}
		
		
		return flag;

		
	}

	

	

}

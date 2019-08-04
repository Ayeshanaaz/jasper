package com.virtusa.payroll.service;

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

public interface IPayroll {
	public int doLoginCheck(LoginDetail loginDetail) throws PayrollException;
	
	public int doFirstUserCheck(int employeeId) throws PayrollException;
	
	public int createSecurityCheck(Security securityDetail) throws PayrollException;
	public int doSecurityCheck(SecurityDetail securityDetail) throws PayrollException;
	public int updatePassword(LoginDetail loginDetail) throws PayrollException;
	
	public Employee viewDetails(int employeeId) throws PayrollException;
	public int updateDetails(Employee employee) throws PayrollException;
	public String viewPayslip(PayrollData payrollData) throws PayrollException;
	public Salary viewCtc(int employeeId) throws PayrollException;
	
	
	public int doInvestmentDeclaration(int emp_id,Investment investment) throws PayrollException;
	public int claimReimbursement(Reimbursement reimbursement) throws PayrollException;
	public int changeBenefitDetail(BenefitDetail benefits) throws PayrollException;
	
	
}

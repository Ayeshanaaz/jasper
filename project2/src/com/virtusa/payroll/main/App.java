package com.virtusa.payroll.main;

import com.virtusa.payroll.dao.PayrollDao;
import com.virtusa.payroll.exception.PayrollException;
import com.virtusa.payroll.model.BenefitDetail;
import com.virtusa.payroll.model.Employee;
import com.virtusa.payroll.model.Investment;
import com.virtusa.payroll.model.LoginDetail;
import com.virtusa.payroll.model.PayrollData;
import com.virtusa.payroll.model.Reimbursement;
import com.virtusa.payroll.model.Salary;
import com.virtusa.payroll.model.SecurityDetail;
import com.virtusa.payroll.model.Security;

public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		int flag=0;
		int id=8001;
		
		
		
		PayrollDao dao=new PayrollDao();
		
		
		Employee employee=new Employee();
		employee.setEmp_id(id);
		PayrollData payrollData=new PayrollData();
		payrollData.setEmployee(employee);
		payrollData.setPay_month("07");
		payrollData.setPay_year(2019);
		try {
			String path=dao.viewPayslip(payrollData);
			System.out.println("path is "+path);
		} catch (PayrollException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		/*
		Employee employee=new Employee();
		employee.setEmp_id(id);
		
		Reimbursement reimbursement=new Reimbursement();
		reimbursement.setEmployee(employee);
		reimbursement.setRe_type("food");
		reimbursement.setRe_amount(200);
		reimbursement.setRe_path("xx");
		try {
			flag=dao.claimReimbursement(reimbursement);
			if(flag==1){
				System.out.println("reimbursement declaration successful");
			}
			else{
				System.out.println("reimbursement declaration not successful");
			}
		} catch (PayrollException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Investment investment=new Investment();
		investment.setInv_eduloan("eduloan");
		investment.setInv_insurance("inv_insurance");
		investment.setInv_loan("inv_loan");
		investment.setInv_ppf("inv_ppf");
		try {
			flag=dao.doInvestmentDeclaration(id, investment);
			if(flag==1){
				System.out.println("investment declaration successful");
			}
			else{
				System.out.println("investment declaration not successful");
			}
		} catch (PayrollException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Employee employee=new Employee();
		employee.setEmp_id(8001);
		BenefitDetail benefitDetail=new BenefitDetail();
		benefitDetail.setEmployee(employee);
		benefitDetail.setBen_childfee(500);
		benefitDetail.setBen_food(2000);
		benefitDetail.setBen_lta(100);
		benefitDetail.setBen_phone(300);
		try {
			flag=dao.changeBenefitDetail(benefitDetail);
			if(flag==1){
				System.out.println("update benefit detail completed");
			}
			else{
				System.out.println("update benefit detail not completed");
			}
			
		} catch (PayrollException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			Salary salaryDetail=dao.viewCtc(8001);
			System.out.println("salary package is "+salaryDetail.getSal_package());
			System.out.println("salary basic is "+salaryDetail.getSal_basic());
			
		} catch (PayrollException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Employee updateEmployee=new Employee();
		updateEmployee.setEmp_password("Guru");
		updateEmployee.setEmp_pan("Glvps001");
		updateEmployee.setEmp_id(8001);
		
		try {
			flag=dao.updateDetails(updateEmployee);
			if(flag==1){
				System.out.println("Employee detailsUpdated");
			}
			else{
				System.out.println("Employee details not Updated");
			}
		} catch (PayrollException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			Employee emp=dao.viewDetails(8001);
			System.out.println("emp name is "+emp.getEmo_name());
			System.out.println("emp pan is "+emp.getEmp_pan());
		} catch (PayrollException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		LoginDetail loginDetail=new LoginDetail("8001","8002");
		try {
			flag=dao.updatePassword(loginDetail);
			if(flag==1){
				System.out.println("change pass success");
				
			}
			else{
				System.out.println("change pass failed");
			}
		} catch (PayrollException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		SecurityDetail securityDetail=new SecurityDetail("What is your favourite sport?","FootBall");
		try {
			flag=dao.doSecurityCheck(securityDetail);
			if(flag==1){
				System.out.println("do security check success");
			}
		} catch (PayrollException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Security securityDetail=new Security(id,"What is your favourite sport?","FootBall");
		
		LoginDetail loginDetail=new LoginDetail("8001","8001");
		
		try {
			flag=dao.createSecurityCheck(securityDetail);
			if(flag==1){
				System.out.println("create security check success");
			}
		} catch (PayrollException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		flag=0;
		try {
			flag=dao.doLoginCheck(loginDetail);
			if(flag==1){
				System.out.println("login success");
			}
		} catch (PayrollException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}

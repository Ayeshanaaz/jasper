package com.virtusa.payroll.main;

import org.apache.log4j.Logger;


import com.virtusa.payroll.dao.PayrollDao;
import com.virtusa.payroll.exception.PayrollException;

import com.virtusa.payroll.model.Employee;


import com.virtusa.payroll.model.PayrollData;


public class App {


	public static void main(String[] args) {
		Logger logger=Logger.getLogger("App");
		
		int id=8001;
		
		
		
		PayrollDao dao=new PayrollDao();
		
		
		Employee employee=new Employee();
		employee.setempId(id);
		PayrollData payrollData=new PayrollData();
		payrollData.setEmployee(employee);
		payrollData.setpayMonth("07");
		payrollData.setpayYear(2019);
		try {
			String path=dao.viewPayslip(payrollData);
			logger.info("path is "+path);
		} catch (PayrollException e) {

			logger.info(e);
		}
		
		
		
		
		
	}

}

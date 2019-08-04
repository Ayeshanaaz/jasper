package com.virtusa.payroll.controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.virtusa.payroll.dao.PayrollDao;
import com.virtusa.payroll.model.Employee;




@WebServlet("/UpdateController")

public class UpdateController extends HttpServlet
{
	private static final long serialVersionUID = 1L;



	public UpdateController()
	{
		super();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger=Logger.getLogger("doPost");
	response.setContentType("text/html");
	
		PayrollDao dao=new PayrollDao();
		logger.info("ughu");
	
		HttpSession session = request.getSession();
		try 
		{

			String empid2=		session.getAttribute("user").toString();
			int empid12=Integer.parseInt(empid2);
			String name=request.getParameter("name");
			String gender=	request.getParameter("emp_gender");
			String address=		request.getParameter("emp_address");
			String contact=		request.getParameter("emp_contact");
			int contact1=Integer.parseInt(contact);
			String pan=		request.getParameter("emp_pan");
			String mail=		request.getParameter("empEmail");

			Employee employeeDetails=new Employee();
			
			employeeDetails.setempId(empid12);
			employeeDetails.setempName(name);
			employeeDetails.setempGender(gender);
			
			employeeDetails.setempAddress(address);
			employeeDetails.setempContact(contact1);
			employeeDetails.setempPan(pan);
			employeeDetails.setempEmail(mail);		
	
			int status1;
		

			
			logger.info(employeeDetails);
			
				status1 = dao.updateDetails(employeeDetails);
				if(status1>0){

					request.getRequestDispatcher("/jsp/success.jsp").forward(request,response);	
				}else
				{
					response.getWriter().println("not Updated");	


				}

		
		} catch (Exception e)
		{
			logger.info(e);
		}
	}	
}
	







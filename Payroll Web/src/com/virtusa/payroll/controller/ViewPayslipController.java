package com.virtusa.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.virtusa.payroll.dao.PayrollDao;
import com.virtusa.payroll.exception.PayrollException;
import com.virtusa.payroll.model.Employee;
import com.virtusa.payroll.model.PayrollData;
import com.virtusa.payroll.service.IMessages;


@WebServlet("/ViewPayslipController")
public class ViewPayslipController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewPayslipController() {
        super();

    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger=Logger.getLogger("doPost");
		String date=request.getParameter("date");
		PrintWriter out=response.getWriter();
		String[] monthYear=date.split("-");
		out.println(monthYear[0]);
		HttpSession session=request.getSession();
		RequestDispatcher dispatcher=null;
		if(session.getAttribute("user")!=null){
			int id=Integer.parseInt(session.getAttribute("user").toString());
			Employee employee=new Employee();
			employee.setempId(id);
			PayrollData payrollData=new PayrollData();
			payrollData.setEmployee(employee);
			payrollData.setpayMonth(monthYear[1]);
			payrollData.setpayYear(Integer.parseInt(monthYear[0]));
			logger.info(payrollData.getEmployee().getempId()+" "+payrollData.getpayMonth()+" "+payrollData.getpayYear());
			PayrollDao dao=new PayrollDao();
			
			try {
				String path=dao.viewPayslip(payrollData);
				request.setAttribute("path", path);
				dispatcher=request.getRequestDispatcher("/jsp/viewpayroll.jsp");
				dispatcher.forward(request, response);
				
			} catch (PayrollException e) {

				out.println(IMessages.contactAdmin);
			}
		}else{
			dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}

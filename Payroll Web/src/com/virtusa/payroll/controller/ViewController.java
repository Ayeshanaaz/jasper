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

import com.virtusa.payroll.dao.PayrollDao;
import com.virtusa.payroll.exception.PayrollException;
import com.virtusa.payroll.model.Employee;


@WebServlet("/ViewController")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public ViewController() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		int eid1=8001;
		PayrollDao dao=new PayrollDao();
	    Employee employee=new Employee();
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		RequestDispatcher dispatcher=null;
		if (session.getAttribute("user") != null) {
		try {
			employee=dao.viewDetails(eid1);
			if(employee!=null){
				request.setAttribute("empid", eid1);
				request.setAttribute("ename", employee.getempName());
				request.setAttribute("contact", employee.getempContact());

				request.setAttribute("gender", employee.getempGender());
				request.setAttribute("pan", employee.getempPan());
				request.setAttribute("address",employee.getempAddress());
				request.setAttribute("mail",employee.getempEmail());
				request.getRequestDispatcher("/jsp/viewdetail.jsp").forward(request, response);
			}
		} catch (PayrollException e1) {
			out.println("error");
		}
		}
		else{
			dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}


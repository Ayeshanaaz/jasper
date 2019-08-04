package com.virtusa.payroll.controller;

import java.io.IOException;


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
import com.virtusa.payroll.model.Salary;
import com.virtusa.payroll.service.IMessages;

/**
 * Servlet implementation class CTCController
 */
@WebServlet("/CTCController")
public class CTCController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CTCController() {
		super();
	}
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	Logger logger=Logger.getLogger("doGet");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		if (session.getAttribute("user") != null) {
			
			PayrollDao dao = new PayrollDao();
			int employeeId = Integer.parseInt(session.getAttribute("user").toString());
			try {
				Salary salary = dao.viewCtc(employeeId);
				request.setAttribute("salPackage", salary.getsalpackage());
				request.setAttribute("salHra", salary.getsalHra());
				request.setAttribute("salBasic", salary.getsalBasic());
				request.setAttribute("salBonus", salary.getsalBonus());
				request.setAttribute("salAllowance", salary.getsalAllowance());
				dispatcher = request.getRequestDispatcher("/jsp/viewctc.jsp");
				dispatcher.forward(request, response);
			} catch (PayrollException e) {

			logger.info(IMessages.contactAdmin);
			}
		} else {
			dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}

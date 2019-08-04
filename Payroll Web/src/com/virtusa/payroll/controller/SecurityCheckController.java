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

import com.virtusa.payroll.service.IMessages;

@WebServlet("/SecurityCheckController")
public class SecurityCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SecurityCheckController() {
		super();

	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	Logger logger=Logger.getLogger("doPost");
		response.setContentType("text/html");
		
		int employeeId = Integer.parseInt(request.getParameter("security1"));
		logger.info(employeeId);

		PayrollDao dao = new PayrollDao();
		RequestDispatcher dispatcher = null;
		HttpSession session = null;
		int flag = 0;
		try {
			flag = dao.checkEmployeeId(employeeId);
			if (flag == 1) {
				session = request.getSession();
				session.setAttribute("user", employeeId);
				String question = dao.retrieveResult(employeeId);
				request.setAttribute("question", question);
				dispatcher = request.getRequestDispatcher("/jsp/securityquestion.jsp");
				dispatcher.forward(request, response);
			} else {
				dispatcher = request.getRequestDispatcher("/jsp/home.html");
				dispatcher.forward(request, response);
			}
		} catch (PayrollException e) {
			logger.info(IMessages.contactAdmin);
		}

	}

}

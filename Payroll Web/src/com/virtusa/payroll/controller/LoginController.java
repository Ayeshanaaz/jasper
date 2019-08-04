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
import com.virtusa.payroll.model.LoginDetail;
import com.virtusa.payroll.service.IMessages;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

Logger logger=Logger.getLogger("doPost");
		response.setContentType("text/html");

		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		LoginDetail loginDetail = new LoginDetail(username, password);
		PayrollDao dao = new PayrollDao();
		RequestDispatcher dispatcher = null;
		HttpSession session = null;
		int flag = 0;
		try {
			flag = dao.doFirstUserCheck(Integer.parseInt(username));
			session = request.getSession();
			session.setAttribute("user", username);
			if (flag == 1) {
				
				flag = dao.doLoginCheck(loginDetail);
				if (flag == 1) {
					session = request.getSession();
					session.setAttribute("user", username);
					session.setMaxInactiveInterval(150);
					dispatcher = request.getRequestDispatcher("/jsp/welcome.jsp");
					dispatcher.forward(request, response);
				} else {
					dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				dispatcher = request.getRequestDispatcher("/jsp/securitycreate.jsp");
				dispatcher.forward(request, response);
			}
		} catch (PayrollException e) {

		logger.info(IMessages.contactAdmin);

		}

	}

}

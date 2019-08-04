package com.virtusa.payroll.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
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

@WebServlet("/SecurityUpdateController")
public class SecurityUpdateController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	public SecurityUpdateController() {
		super();

	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

Logger logger=Logger.getLogger("doPost");
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			PayrollDao dao = new PayrollDao();
			int flag;
			LoginDetail loginDetail = new LoginDetail();
			String password1 = request.getParameter("password");
			String password = request.getParameter("confirmpasssword");

			String username = session.getAttribute("user").toString();
		logger.info("password is suc is" + password);
		logger.info("username is suc is" + username);

			loginDetail.setUsername(username);
			loginDetail.setPassword(password);
			if (password1.equals(password)) {
				try {
					flag = dao.updatePassword(loginDetail);
					if (flag == 1) {
						dispatcher = request.getRequestDispatcher("/jsp/welcome.jsp");
						dispatcher.forward(request, response);
					} else {
						dispatcher = request.getRequestDispatcher("/jsp/securityquestion.jsp");
						dispatcher.forward(request, response);
					}
				} catch (PayrollException e) {

					logger.info(e);
				}
			} else {
				dispatcher = request.getRequestDispatcher("/jsp/updatepassword.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
			dispatcher.forward(request, response);
		}

	}

}

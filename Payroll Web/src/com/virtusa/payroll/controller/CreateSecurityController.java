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
import com.virtusa.payroll.model.Security;
import com.virtusa.payroll.service.IMessages;

@WebServlet("/CreateSecurityController")
public class CreateSecurityController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateSecurityController() {
		super();

	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			String question = request.getParameter("securityquestion");
			String answer = request.getParameter("securityanswer");

			int id = Integer.parseInt(session.getAttribute("user").toString());
			out.println(id + "  " + question + " " + answer);
			Security securityDetail = new Security(id, question, answer);
			PayrollDao dao = new PayrollDao();

			int flag = 0;
			try {
				flag = dao.createSecurityCheck(securityDetail);
				if (flag == 1) {
					dispatcher = request.getRequestDispatcher("/jsp/welcome.jsp");
					dispatcher.forward(request, response);
				}
			} catch (PayrollException e) {
				out.println(IMessages.contactAdmin);
			}
		} else {
			dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
			dispatcher.forward(request, response);
		}

	}

}

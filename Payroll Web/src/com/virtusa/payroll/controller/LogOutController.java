package com.virtusa.payroll.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogOutController")
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogOutController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		if (session.getAttribute("user") != null) {
			session.removeAttribute("userid");

			session.invalidate();
			rd = request.getRequestDispatcher("/jsp/Thankyou.jsp");
			rd.forward(request, response);

		} else {
			rd = request.getRequestDispatcher("/jsp/error.jsp");
			rd.forward(request, response);
		}
	}

}

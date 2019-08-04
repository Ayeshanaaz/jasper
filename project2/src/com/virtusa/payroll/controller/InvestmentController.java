package com.virtusa.payroll.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.payroll.dao.PayrollDao;
import com.virtusa.payroll.exception.PayrollException;
import com.virtusa.payroll.model.Investment;


@WebServlet("/InvestmentController")
public class InvestmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InvestmentController() {
		super();

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Investment investment = new Investment();
		PayrollDao dao = new PayrollDao();
		response.setContentType("text/html");
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();
		String insurance = request.getParameter("insurance");
		String eduloan = request.getParameter("eduloan");
		String ppf = request.getParameter("ppf");
		String loan = request.getParameter("loan");
		//PayrollDao dao = new PayrollDao();
		//Investment investment = new Investment();
		int employeeId = 5001;
		investment.setInv_insurance(insurance);
		investment.setInv_eduloan(eduloan);
		investment.setInv_ppf(ppf);
		investment.setInv_loan(loan);
		int flag = 0;
		try {
			flag = dao.doInvestmentDeclaration(employeeId, investment);
			if (flag == 1) {
				dispatcher = request.getRequestDispatcher("/jsp/invsubmitted.jsp");
				dispatcher.forward(request, response);
			} else {
				dispatcher = request.getRequestDispatcher("/jsp/security.jsp");
				dispatcher.forward(request, response);
			}
			//System.out.println("Submitted successfully");

		} catch (PayrollException e) {

			e.printStackTrace();
		}

	}

}
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
import com.virtusa.payroll.model.BenefitDetail;

import com.virtusa.payroll.service.IMessages;


@WebServlet("/BenefitRequestController")
public class BenefitRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BenefitRequestController() {
		super();

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		if (session.getAttribute("user") != null) {
			int empId = Integer.parseInt(session.getAttribute("user").toString());
			PrintWriter out = response.getWriter();
			PayrollDao dao = new PayrollDao();

			
			try {
				BenefitDetail benefitDetail = dao.getBenefitDetails(empId);
				
				request.setAttribute("lta", benefitDetail.getbenLta());
				request.setAttribute("phone", benefitDetail.getbenPhone());
				request.setAttribute("childfee", benefitDetail.getbenChildfee());
				request.setAttribute("food", benefitDetail.getbenFood());
				dispatcher = request.getRequestDispatcher("/jsp/Benefits.jsp");
				
				dispatcher.forward(request, response);

			} catch (PayrollException e) {
				out.println(IMessages.contactAdmin);
			}
			
		} else {
			dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
			dispatcher.forward(request, response);
		}

	}

}

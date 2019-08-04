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
import com.virtusa.payroll.model.BenefitDetail;
import com.virtusa.payroll.model.Employee;
import com.virtusa.payroll.service.IMessages;

@WebServlet("/BenifitController")
public class BenifitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BenifitController() {
		super();

	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
Logger logger=Logger.getLogger("doPost");
		
		PayrollDao dao = new PayrollDao();
		int flag = 0;
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			int empId = Integer.parseInt(session.getAttribute("user").toString());
			Employee employee = new Employee();
			employee.setempId(empId);
			logger.info(empId);
			BenefitDetail benefitDetail = new BenefitDetail();

			float childfee = Float.parseFloat(request.getParameter("childfee"));
			logger.info(childfee);

			float foodCoupons = Float.parseFloat(request.getParameter("foodcoupon"));
			logger.info(foodCoupons);
			float lta = Float.parseFloat(request.getParameter("lta"));
			logger.info(lta);
			float phone = Float.parseFloat(request.getParameter("phone"));
			logger.info(phone);
			benefitDetail.setEmployee(employee);
			benefitDetail.setbenChildfee(childfee);

			benefitDetail.setbenFood(foodCoupons);

			benefitDetail.setbenPhone(phone);
			benefitDetail.setbenLta(lta);
			try {
				flag = dao.changeBenefitDetail(benefitDetail);
				if (flag == 1) {
					dispatcher = request.getRequestDispatcher("/jsp/success.jsp");
					dispatcher.forward(request, response);
				} else {
					dispatcher = request.getRequestDispatcher("/jsp/benefits.jsp");
					dispatcher.forward(request, response);
				}
			} catch (PayrollException e) {
				logger.info(IMessages.contactAdmin);
			}
		} else {
			dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
			dispatcher.forward(request, response);
		}

	}

}

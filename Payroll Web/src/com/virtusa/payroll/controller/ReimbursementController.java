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
import com.virtusa.payroll.model.Employee;
import com.virtusa.payroll.model.Reimbursement;
import com.virtusa.payroll.service.IMessages;

@WebServlet("/ReimbursementController")
public class ReimbursementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReimbursementController() {
		super();

	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	Logger logger=Logger.getLogger("doPost");
		response.setContentType("text/html");
	
		PayrollDao service = new PayrollDao();
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		if (session.getAttribute("user") != null) {
			int empId = Integer.parseInt(session.getAttribute("user").toString());
			Employee employee = new Employee();
			employee.setempId(empId);
			String reType = request.getParameter("type");
			String amount = request.getParameter("Amount");
			float reAmount = Float.parseFloat(amount);
			String rePath = request.getParameter("proof");

			logger.info(reAmount + "  " + reType + " " + rePath);
			Reimbursement reimbursement = new Reimbursement();
			reimbursement.setEmployee(employee);
			reimbursement.setreType(reType);
			reimbursement.setreAmount(reAmount);
			reimbursement.setrePath(rePath);
			int flag = 0;

			try {
				flag = service.claimReimbursement(empId, reimbursement);
				if (flag == 1) {
					dispatcher = request.getRequestDispatcher("/jsp/success.jsp");
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

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
import com.virtusa.payroll.model.Security;

import com.virtusa.payroll.service.IMessages;

/**
 * Servlet implementation class SecurityValidateController
 */
@WebServlet("/SecurityValidateController")
public class SecurityValidateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SecurityValidateController() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger logger=Logger.getLogger("doPost");
		response.setContentType("text/html");
	
		
		String answer = request.getParameter("securityanswer");
		RequestDispatcher dispatcher = null;
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!=null){
			int empId=Integer.parseInt(session.getAttribute("user").toString());
			Security securityDetail = new Security();
			securityDetail.setsecId(empId);
			securityDetail.setsecAns(answer);
			PayrollDao dao = new PayrollDao();
			logger.info("answer "+answer);
			logger.info("employee "+empId);
			
			int flag = 0;
			try {
				flag = dao.doSecurityCheck(securityDetail);
				logger.info(flag);
				if (flag == 1) {
	
					dispatcher = request.getRequestDispatcher("/jsp/updatepassword.jsp");
					dispatcher.forward(request, response);
				} else {
					dispatcher = request.getRequestDispatcher("/html/home.html");
					dispatcher.forward(request, response);
				}
			} catch (PayrollException e) {
				logger.info(IMessages.contactAdmin);
			}
		}
		else{
			dispatcher=request.getRequestDispatcher("/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}

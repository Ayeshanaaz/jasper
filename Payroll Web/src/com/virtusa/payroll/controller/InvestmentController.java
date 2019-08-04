package com.virtusa.payroll.controller;

import java.io.File;

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
import org.apache.commons.io.FileUtils;
import org.apache.commons.fileupload.*;

@WebServlet("/InvestmentController")
public class InvestmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InvestmentController() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();

		if (session.getAttribute("user") != null) {
			Investment investment = new Investment();
			String insurance = request.getParameter("insurance");
			File sourceFile = new File(insurance);
			
			String destination="D:/yesh/Payroll Web/payroll/investmentfiles/";
			
	        String file=sourceFile.getName();
			String insuranceDest = (session.getAttribute("user").toString())+"insurance"+file.substring(file.indexOf('.'));
	        File targetFile = new File(destination+insuranceDest);
	        //FileUtils.copyFile(sourceFile, targetFile);
	        
			String eduloan = request.getParameter("eduloan");

			String ppf = request.getParameter("ppf");
			String loan = request.getParameter("loan");
			PayrollDao dao = new PayrollDao();

			int employeeId = Integer.parseInt(session.getAttribute("user").toString());

			investment.setinvInsurance(insurance);

			investment.setinvEduloan(eduloan);
			investment.setinvPpf(ppf);
			investment.setinvLoan(loan);
			int flag = 0;

			try {
				flag = dao.doInvestmentDeclaration(employeeId, investment);
				if (flag == 1) {
					dispatcher = request.getRequestDispatcher("/jsp/success.jsp");
					dispatcher.forward(request, response);
				} else {
					dispatcher = request.getRequestDispatcher("/jsp/security.jsp");
					dispatcher.forward(request, response);
				}

			} catch (PayrollException e) {

			}
		} else {
			dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
			dispatcher.forward(request, response);
		}

	}

}

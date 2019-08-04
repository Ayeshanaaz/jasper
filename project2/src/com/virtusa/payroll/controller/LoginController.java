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
import com.virtusa.payroll.model.LoginDetail;
import com.virtusa.payroll.service.IMessages;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("uname");
		String password=request.getParameter("password");
		LoginDetail loginDetail=new LoginDetail(username,password);
		PayrollDao dao=new PayrollDao();
		RequestDispatcher dispatcher=null;
		HttpSession session=null;
		int flag=0;
			try {
				flag=dao.doFirstUserCheck(Integer.parseInt(username));
				session=request.getSession();
				session.setAttribute("user",username);
				if(flag==1){
					out.println("hai");
					flag = dao.doLoginCheck(loginDetail);
					if(flag==1){
						session=request.getSession();
						session.setAttribute("user",username);
						
						dispatcher=request.getRequestDispatcher("/jsp/welcome.jsp");
						dispatcher.forward(request,response);
					}
					else{
						dispatcher=request.getRequestDispatcher("/html/login.html");
						dispatcher.forward(request,response);
					}
				}
				else{
					dispatcher=request.getRequestDispatcher("/jsp/securitycreate.jsp");
					dispatcher.forward(request, response);
				}
			}
			catch (PayrollException e) {
				
					out.println(IMessages.contactAdmin);
				
			}
		
	
	}

}

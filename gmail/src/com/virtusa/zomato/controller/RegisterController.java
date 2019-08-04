package com.virtusa.zomato.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.virtusa.zomato.exception.ZomatoException;
import com.virtusa.zomato.model.CustomerDetail;
import com.virtusa.zomato.model.LoginDetail;
import com.virtusa.zomato.service.ZomatoService;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
Logger logger=Logger.getLogger("RegisterController");
String customerName=request.getParameter("customerName");
String customerAddress=request.getParameter("customerAddress");

String password=request.getParameter("password");

String customerEmail=request.getParameter("customerEmail");
String customerContact=request.getParameter("customerContact");

String genderr=request.getParameter("gender");
String country=request.getParameter("country");
String state=request.getParameter("state");
String city=request.getParameter("city");
CustomerDetail customerDetail=new CustomerDetail(0,customerName,customerAddress,customerContact,customerEmail,password,genderr,country,state,city);
customerDetail.setGender(genderr);
customerDetail.setCountry(country);
customerDetail.setState(state);
customerDetail.setCity(city);
customerDetail.setPassword(password);
        ZomatoService service=new ZomatoService();
        logger.info("service object is created");
        RequestDispatcher dispatcher=null;
try{
int genId=service.registerCustomer(customerDetail);
if(genId!=0){
HttpSession session=request.getSession();
LoginDetail loginDetail=new LoginDetail(customerEmail,password);
session.setAttribute("user", loginDetail);
System.out.println("login");
dispatcher=request.getRequestDispatcher("html/home.html");
}
else{
dispatcher=request.getRequestDispatcher("html/Registration.html");

}

}
catch(ZomatoException e){
e.printStackTrace();
dispatcher=request.getRequestDispatcher("html/error.html");
logger.error("error page",e);
}
dispatcher.forward(request, response);

}

}


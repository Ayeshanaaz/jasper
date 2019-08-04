package com.virtusa.zomato.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.zomato.exception.ZomatoException;
import com.virtusa.zomato.model.LoginDetail;
import com.virtusa.zomato.service.ZomatoService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
response.setContentType("text/html");
PrintWriter out=response.getWriter();
out.print("Welcome to Servlets");
String username=request.getParameter("username");
String password=request.getParameter("password");
LoginDetail logindetail=new LoginDetail(username,password);
ZomatoService service=new ZomatoService();
try{
int flag=service.doLoginCheck(logindetail);
if(flag==0){
System.out.println("Not Successfully login");
}
else{
System.out.println(" successfully login");
RequestDispatcher dispatcher=request.getRequestDispatcher("/html/home.html");
dispatcher.forward(request, response);
}
}
catch(ZomatoException e){
e.printStackTrace();
}


}

}
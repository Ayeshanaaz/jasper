package com.virtusa.zomato.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.zomato.exception.ZomatoException;
import com.virtusa.zomato.model.RestaurantMenuDetail;
import com.virtusa.zomato.service.ZomatoService;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
ZomatoService service=new ZomatoService();
PrintWriter out=response.getWriter();
String resaurantName=request.getParameter("restaurantName");


try{
List<RestaurantMenuDetail> list=service.searchRestaurants(restaurant);
if(list.size()==0){
System.out.println("List is empty");
}else{
out.println("<table border='1'>");
out.println("<tr><td>Restauarant Name</td><td>Address</td><td>Menu Name</td><td>Menu Price</td></tr>");
for(RestaurantMenuDetail restaurantMenuDetail:list){
System.out.println("<tr>");
out.println("restaurant name= "+restaurantMenuDetail.getRestaurantName());
out.println("restaurant address= "+restaurantMenuDetail.getRestaurantAddress());
out.println("menu name= "+restaurantMenuDetail.getMenuDetail().getMenuName());
out.println("menu price= "+restaurantMenuDetail.getMenuDetail().getMenuPrice());
out.println("</tr>");
}
out.println("</table>");
}
}
catch(ZomatoException e){
dispatcher=request.getRequestDispatcher("html/error.html");
dispatcher.forward(request,response);
}
}

}
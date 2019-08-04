package com.virtusa.zomato.app;

import java.util.List;
import java.util.Scanner;

import com.virtusa.zomato.exception.ZomatoException;
import com.virtusa.zomato.model.CustomerDetail;
import com.virtusa.zomato.model.LoginDetail;
import com.virtusa.zomato.model.RestaurantMenuDetail;
import com.virtusa.zomato.service.ZomatoService;

public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		ZomatoService service=new ZomatoService();	
		Scanner scanner=new Scanner(System.in);

		System.out.println("Enter the text to search");
		String text=scanner.nextLine();
		
	List<RestaurantMenuDetail> list=null;
	try {
		list = service.searchRestautants(text);
		for (RestaurantMenuDetail restaurantMenuDetail : list) {
			
			
			System.out.println("Restaurant Name= "+restaurantMenuDetail.getRestaurant().getRestaurantName());
			System.out.println("Restaurant address= "+restaurantMenuDetail.getRestaurant().getRestaurantAddress());
            System.out.println("================Menu List===================================");
			System.out.print("Menu Name"+restaurantMenuDetail.getMenuDetail().getMenuName()+"\t");
			System.out.print("Menu Price"+restaurantMenuDetail.getMenuDetail().getMenuPrice());
			
			
		}
		
		
		
		
		
	} catch (ZomatoException e2) {
		// TODO Auto-generated catch block
		System.out.println(e2.getMessage());
	}
		
		System.out.println(list);
		
		
		
		
		System.out.println("Enter name");
		String name=		scanner.nextLine();
		System.out.println("Enter email");
		String email=		scanner.nextLine();
		System.out.println("Enter contact");
		String contact=		scanner.nextLine();
		System.out.println("Enter address");
		String address=		scanner.nextLine();
		System.out.println("Enter password");
		String passwords=		scanner.nextLine();
		
		CustomerDetail customerDetail=new CustomerDetail();
		
		customerDetail.setCustomerName(name);
		customerDetail.setCustomerEmail(email);
customerDetail.setCustomerContact(contact);
customerDetail.setPassword(passwords);
customerDetail.setCustomerAddress(address);


int customerNo=0;
try {
	customerNo = service.registerCustomer(customerDetail);
} catch (ZomatoException e1) {
	// TODO Auto-generated catch block
	System.out.println(e1.getMessage());
}

if(customerNo>=0){
	System.out.println("Customer registered");
	
}else{
	System.out.println("customer not registered");
	
}





		System.out.println("Enter username");
		String username=		scanner.nextLine();
		System.out.println("Enter password");
		String password=		scanner.nextLine();

		LoginDetail detail=new LoginDetail(username, password);
		
		
	int status=0;
	try {
		status = service.doLoginCheck(detail);
	} catch (ZomatoException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
		if(status==0){
			System.out.println("Not Successfully login");
		}
		else{
			System.out.println(" successfully login");
			
		}
		
		
		
	}

}

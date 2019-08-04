package com.virtusa.zomato.service;

import java.util.List;

import com.virtusa.zomato.exception.ZomatoException;
import com.virtusa.zomato.model.CustomerDetail;
import com.virtusa.zomato.model.LoginDetail;
import com.virtusa.zomato.model.OrderDetail;
import com.virtusa.zomato.model.PaymentDetail;
import com.virtusa.zomato.model.RestaurantMenuDetail;

public interface IZomato {
	
	public int doLoginCheck(LoginDetail loginDetail) throws ZomatoException;
	public int registerCustomer(CustomerDetail customerDetail)throws ZomatoException;
	public List<RestaurantMenuDetail>searchRestautants(String text)throws ZomatoException;
	public int placeOrder(OrderDetail orderDetail)throws ZomatoException;
	public int doPayment(PaymentDetail paymentDetail)throws ZomatoException;
	

}

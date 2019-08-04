package com.virtusa.zomato.service;

import java.util.List;

import com.virtusa.zomato.dao.ZomatoDao;
import com.virtusa.zomato.exception.ZomatoException;
import com.virtusa.zomato.model.CustomerDetail;
import com.virtusa.zomato.model.LoginDetail;
import com.virtusa.zomato.model.OrderDetail;
import com.virtusa.zomato.model.PaymentDetail;
import com.virtusa.zomato.model.RestaurantMenuDetail;

public class ZomatoService {

	
	public ZomatoService() {
		// TODO Auto-generated constructor stub
	}
	
	private ZomatoDao zomatoDao=new ZomatoDao();
	
	
	public int doLoginCheck(LoginDetail loginDetail) throws ZomatoException {
		// TODO Auto-generated method stub
		return zomatoDao.doLoginCheck(loginDetail);
	}


	public int registerCustomer(CustomerDetail customerDetail) throws ZomatoException {
		// TODO Auto-generated method stub
		return zomatoDao.registerCustomer(customerDetail);
	}

	public List<RestaurantMenuDetail> searchRestautants(String text) throws ZomatoException {
		// TODO Auto-generated method stub
		return zomatoDao.searchRestautants(text);
	}


	public int placeOrder(OrderDetail orderDetail) throws ZomatoException {
		// TODO Auto-generated method stub
		return zomatoDao.placeOrder(orderDetail);
	}

	public int doPayment(PaymentDetail paymentDetail) throws ZomatoException {
		// TODO Auto-generated method stub
		return zomatoDao.doPayment(paymentDetail);
	}


}

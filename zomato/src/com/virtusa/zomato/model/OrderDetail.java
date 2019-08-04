package com.virtusa.zomato.model;

public class OrderDetail {

	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
 private int orderId;
 private int orderQuantity;
@Override
public String toString() {
	return "OrderDetail [orderId=" + orderId + ", orderQuantity=" + orderQuantity + ", status=" + status
			+ ", restaurant=" + restaurant + ", customerDetail=" + customerDetail + ", menuDetail=" + menuDetail
			+ ", offerDetail=" + offerDetail + "]";
}
public OrderDetail(int orderId, int orderQuantity, String status, Restaurant restaurant, CustomerDetail customerDetail,
		MenuDetail menuDetail, OfferDetail offerDetail) {
	super();
	this.orderId = orderId;
	this.orderQuantity = orderQuantity;
	this.status = status;
	this.restaurant = restaurant;
	this.customerDetail = customerDetail;
	this.menuDetail = menuDetail;
	this.offerDetail = offerDetail;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public int getOrderQuantity() {
	return orderQuantity;
}
public void setOrderQuantity(int orderQuantity) {
	this.orderQuantity = orderQuantity;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Restaurant getRestaurant() {
	return restaurant;
}
public void setRestaurant(Restaurant restaurant) {
	this.restaurant = restaurant;
}
public CustomerDetail getCustomerDetail() {
	return customerDetail;
}
public void setCustomerDetail(CustomerDetail customerDetail) {
	this.customerDetail = customerDetail;
}
public MenuDetail getMenuDetail() {
	return menuDetail;
}
public void setMenuDetail(MenuDetail menuDetail) {
	this.menuDetail = menuDetail;
}
public OfferDetail getOfferDetail() {
	return offerDetail;
}
public void setOfferDetail(OfferDetail offerDetail) {
	this.offerDetail = offerDetail;
}
private String status;


private Restaurant restaurant;
private CustomerDetail customerDetail;
private MenuDetail menuDetail;
private OfferDetail offerDetail;




}

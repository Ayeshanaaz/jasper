package com.virtusa.zomato.model;

public class DeliveryDetail {

	public DeliveryDetail() {
		// TODO Auto-generated constructor stub
	}
	
private	int deliveryId;
private	float rating;
	
private	DevliveryBoyDetail devliveryBoyDetail;
private	OrderDetail orderDetail;
public int getDeliveryId() {
	return deliveryId;
}
public void setDeliveryId(int deliveryId) {
	this.deliveryId = deliveryId;
}
public float getRating() {
	return rating;
}
public void setRating(float rating) {
	this.rating = rating;
}
public DevliveryBoyDetail getDevliveryBoyDetail() {
	return devliveryBoyDetail;
}
public void setDevliveryBoyDetail(DevliveryBoyDetail devliveryBoyDetail) {
	this.devliveryBoyDetail = devliveryBoyDetail;
}
public OrderDetail getOrderDetail() {
	return orderDetail;
}
public void setOrderDetail(OrderDetail orderDetail) {
	this.orderDetail = orderDetail;
}
@Override
public String toString() {
	return "DeliveryDetail [deliveryId=" + deliveryId + ", rating=" + rating + ", devliveryBoyDetail="
			+ devliveryBoyDetail + ", orderDetail=" + orderDetail + "]";
}
public DeliveryDetail(int deliveryId, float rating, DevliveryBoyDetail devliveryBoyDetail, OrderDetail orderDetail) {
	super();
	this.deliveryId = deliveryId;
	this.rating = rating;
	this.devliveryBoyDetail = devliveryBoyDetail;
	this.orderDetail = orderDetail;
}
	

}

package com.virtusa.zomato.model;

public class PaymentDetail {

	public PaymentDetail() {
		// TODO Auto-generated constructor stub
	}
	
	private int paymentId;
	private String paymentType;
	private char paymentStatus;
	
	
    @Override
	public String toString() {
		return "PaymentDetail [paymentId=" + paymentId + ", paymentType=" + paymentType + ", paymentStatus="
				+ paymentStatus + ", orderDetail=" + orderDetail + ", customerDetail=" + customerDetail + "]";
	}
	public PaymentDetail(int paymentId, String paymentType, char paymentStatus, OrderDetail orderDetail,
			CustomerDetail customerDetail) {
		super();
		this.paymentId = paymentId;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.orderDetail = orderDetail;
		this.customerDetail = customerDetail;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public char getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(char paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}
	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}

	private OrderDetail orderDetail;
    private CustomerDetail customerDetail;
    
    
    
	
	
}

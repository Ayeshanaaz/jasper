package com.virtusa.zomato.model;

public class CustomerDetail {
	

	public CustomerDetail() {
		// TODO Auto-generated constructor stub
	}
	
	private int customerId;
	private String customerName;
	private String customerAddress;
	private String customerEmail;
	private String customerContact;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	
	public CustomerDetail(int customerId, String customerName, String customerAddress, String customerEmail,
			String customerContact, String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerContact = customerContact;
		this.password = password;
	}
	@Override
	public String toString() {
		return "CustomerDetail [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerEmail=" + customerEmail + ", customerContact=" + customerContact + ", Password=" + password + "]";
	}
	
	

}

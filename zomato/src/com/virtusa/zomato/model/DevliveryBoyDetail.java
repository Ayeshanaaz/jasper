package com.virtusa.zomato.model;

public class DevliveryBoyDetail {

	public DevliveryBoyDetail() {
		// TODO Auto-generated constructor stub
	}
	
	private int deliveryBoyId;
	private String deliveryBoyName;
	private String deliveryBoyAddress;
	private String deliveryBoyEmail;
	private String deliveryBoyContact;
	public int getDeliveryBoyId() {
		return deliveryBoyId;
	}
	public void setDeliveryBoyId(int deliveryBoyId) {
		this.deliveryBoyId = deliveryBoyId;
	}
	public String getDeliveryBoyName() {
		return deliveryBoyName;
	}
	public void setDeliveryBoyName(String deliveryBoyName) {
		this.deliveryBoyName = deliveryBoyName;
	}
	public String getDeliveryBoyAddress() {
		return deliveryBoyAddress;
	}
	public void setDeliveryBoyAddress(String deliveryBoyAddress) {
		this.deliveryBoyAddress = deliveryBoyAddress;
	}
	public String getDeliveryBoyEmail() {
		return deliveryBoyEmail;
	}
	public void setDeliveryBoyEmail(String deliveryBoyEmail) {
		this.deliveryBoyEmail = deliveryBoyEmail;
	}
	public String getDeliveryBoyContact() {
		return deliveryBoyContact;
	}
	public void setDeliveryBoyContact(String deliveryBoyContact) {
		this.deliveryBoyContact = deliveryBoyContact;
	}
	public DevliveryBoyDetail(int deliveryBoyId, String deliveryBoyName, String deliveryBoyAddress,
			String deliveryBoyEmail, String deliveryBoyContact) {
		super();
		this.deliveryBoyId = deliveryBoyId;
		this.deliveryBoyName = deliveryBoyName;
		this.deliveryBoyAddress = deliveryBoyAddress;
		this.deliveryBoyEmail = deliveryBoyEmail;
		this.deliveryBoyContact = deliveryBoyContact;
	}
	@Override
	public String toString() {
		return "DevliveryBoyDetail [deliveryBoyId=" + deliveryBoyId + ", deliveryBoyName=" + deliveryBoyName
				+ ", deliveryBoyAddress=" + deliveryBoyAddress + ", deliveryBoyEmail=" + deliveryBoyEmail
				+ ", deliveryBoyContact=" + deliveryBoyContact + "]";
	}
	

}

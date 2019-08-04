package com.virtusa.zomato.model;

public class Restaurant {

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	
	private int restaurantId;
	private String restaurantName;
	private String restaurantAddress;
	private String restaurantEmail;
	private String restaurantContact;
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantAddress() {
		return restaurantAddress;
	}
	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}
	public String getRestaurantEmail() {
		return restaurantEmail;
	}
	public void setRestaurantEmail(String restaurantEmail) {
		this.restaurantEmail = restaurantEmail;
	}
	public String getRestaurantContact() {
		return restaurantContact;
	}
	public void setRestaurantContact(String restaurantContact) {
		this.restaurantContact = restaurantContact;
	}
	public Restaurant(int restaurantId, String restaurantName, String restaurantAddress, String restaurantEmail,
			String restaurantContact) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.restaurantEmail = restaurantEmail;
		this.restaurantContact = restaurantContact;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantAddress=" + restaurantAddress + ", restaurantEmail=" + restaurantEmail
				+ ", restaurantContact=" + restaurantContact + "]";
	}
	
	
	
}

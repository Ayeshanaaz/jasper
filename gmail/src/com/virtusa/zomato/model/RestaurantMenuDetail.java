package com.virtusa.zomato.model;

public class  RestaurantMenuDetail {

	public RestaurantMenuDetail() {
		// TODO Auto-generated constructor stub
	}
	
	
	private int restaurantMenuId;
    private MenuDetail menuDetail;
    private Restaurant restaurant;
	@Override
	public String toString() {
		return "RestaurantMenuDetail [restaurantMenuId=" + restaurantMenuId + ", menuDetail=" + menuDetail
				+ ", restaurant=" + restaurant + "]";
	}
	public RestaurantMenuDetail(int restaurantMenuId, MenuDetail menuDetail, Restaurant restaurant) {
		super();
		this.restaurantMenuId = restaurantMenuId;
		this.menuDetail = menuDetail;
		this.restaurant = restaurant;
	}
	public int getRestaurantMenuId() {
		return restaurantMenuId;
	}
	public void setRestaurantMenuId(int restaurantMenuId) {
		this.restaurantMenuId = restaurantMenuId;
	}
	public MenuDetail getMenuDetail() {
		return menuDetail;
	}
	public void setMenuDetail(MenuDetail menuDetail) {
		this.menuDetail = menuDetail;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
    
    
    
}

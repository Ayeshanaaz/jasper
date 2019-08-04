package com.virtusa.zomato.model;

public class MenuDetail {

	public MenuDetail() {
		// TODO Auto-generated constructor stub
	}
	
	private int menuId;
	private String menuName;
	private float menuPrice;
	public MenuDetail(int menuId, String menuName, float menuPrice) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public float getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(float menuPrice) {
		this.menuPrice = menuPrice;
	}
	
	

	
}

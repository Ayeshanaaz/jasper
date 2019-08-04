package com.virtusa.payroll.model;

public class Admin {

	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	private int AdID;
	private String AdName;
	private int adPhone;
	private String adPassword;
	public Admin(int AdID, String AdName, int adPhone, String adPassword) {
		super();
		this.AdID = AdID;
		this.AdName = AdName;
		this.adPhone = adPhone;
		this.adPassword = adPassword;
	}
	public int getAdID() {
		return AdID;
	}
	public void setAdID(int AdID) {
		this.AdID = AdID;
	}
	public String getAdName() {
		return AdName;
	}
	public void setAdName(String AdName) {
		this.AdName = AdName;
	}
	public int getadPhone() {
		return adPhone;
	}
	public void setadPhone(int adPhone) {
		this.adPhone = adPhone;
	}
	public String getadPassword() {
		return adPassword;
	}
	public void setadPassword(String adPassword) {
		this.adPassword = adPassword;
	}
	@Override
	public String toString() {
		return "Admin [AdID=" + AdID + ", AdName=" + AdName + ", adPhone=" + adPhone + ", adPassword="
				+ adPassword + "]";
	}
	
	

}

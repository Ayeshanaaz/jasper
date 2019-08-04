package com.virtusa.payroll.model;

public class Admin {

	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	private int ad_id;
	private String ad_name;
	private int ad_phone;
	private String ad_password;
	public Admin(int ad_id, String ad_name, int ad_phone, String ad_password) {
		super();
		this.ad_id = ad_id;
		this.ad_name = ad_name;
		this.ad_phone = ad_phone;
		this.ad_password = ad_password;
	}
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	public String getAd_name() {
		return ad_name;
	}
	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}
	public int getAd_phone() {
		return ad_phone;
	}
	public void setAd_phone(int ad_phone) {
		this.ad_phone = ad_phone;
	}
	public String getAd_password() {
		return ad_password;
	}
	public void setAd_password(String ad_password) {
		this.ad_password = ad_password;
	}
	@Override
	public String toString() {
		return "Admin [ad_id=" + ad_id + ", ad_name=" + ad_name + ", ad_phone=" + ad_phone + ", ad_password="
				+ ad_password + "]";
	}
	
	

}

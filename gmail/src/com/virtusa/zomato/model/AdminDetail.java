package com.virtusa.zomato.model;

public class AdminDetail {

	public AdminDetail() {
		// TODO Auto-generated constructor stub
	}
	
	
	private int adminId;
	private String adminName;
	private String adminAddress;
	private String adminEmail;
	private String adminPhone;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminAddress() {
		return adminAddress;
	}
	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPhone() {
		return adminPhone;
	}
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	public AdminDetail(int adminId, String adminName, String adminAddress, String adminEmail, String adminPhone) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminAddress = adminAddress;
		this.adminEmail = adminEmail;
		this.adminPhone = adminPhone;
	}
	@Override
	public String toString() {
		return "AdminDetail [adminId=" + adminId + ", adminName=" + adminName + ", adminAddress=" + adminAddress
				+ ", adminEmail=" + adminEmail + ", adminPhone=" + adminPhone + "]";
	}
	
	
	

}

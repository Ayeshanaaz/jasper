package com.virtusa.payroll.model;

public class LoginDetail {

	public LoginDetail() {
		// TODO Auto-generated constructor stub
	}
	private	String username,password;
	public LoginDetail(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDetail [username=" + username + ", password=" + password + "]";
	}
	
}

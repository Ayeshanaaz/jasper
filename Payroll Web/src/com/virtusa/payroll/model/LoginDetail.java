package com.virtusa.payroll.model;

public class LoginDetail {

	
	private	String username;
	private String password;
	public LoginDetail(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public LoginDetail() {
		// constructor
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

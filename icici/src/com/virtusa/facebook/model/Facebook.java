package com.virtusa.facebook.model;

import com.virtusa.bank.model.Account;

abstract public class Facebook {


	public static final String companyName="facebook";
	abstract public void doLinkBankAccount(Account account);
	
	private String url;
	private String databaseName;
	private String countryName;

	public boolean doLogin(LoginDetails loginDetails) {
		boolean flag = false;
		if (loginDetails != null) {
			flag = true;

		}
		return flag;

	}

	public  boolean doSignUp(RegistrationDetails registrationDetails) {

		boolean flag = false;
		if (registrationDetails != null) {
			System.out.println("Singup from facebook is done");
			flag = true;

		}
		return flag;

	}

	public void doPost(LoginDetails loginDetails) {

		if (loginDetails != null) {
			System.out.println("Post is posted successfully by " + loginDetails.getUsername());
		}

	}

	public void doLike(LoginDetails loginDetails) {

		if (loginDetails != null) {
			System.out.println("Post is liked successfully by " + loginDetails.getUsername());
		}
	}

	public void doComment(LoginDetails loginDetails) {

		if (loginDetails != null) {
			System.out.println("Post is commented successfully by " + loginDetails.getUsername());
		}

	}

	public Facebook() {
		super();
		System.out.println("Contructor from Facebook");
		// TODO Auto-generated constructor stub
	}

	public Facebook(String url, String databaseName, String countryName) {
		super();
		this.url = url;
		this.databaseName = databaseName;
		this.countryName = countryName;
		System.out.println("Contructor from Facebook parameterized");
	
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}

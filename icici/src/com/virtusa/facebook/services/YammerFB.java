package com.virtusa.facebook.services;

import com.virtusa.facebook.model.LoginDetails;
import com.virtusa.facebook.model.RegistrationDetails;

public class YammerFB implements IFacebook {

	@Override
	public boolean doLogin(LoginDetails loginDetails) {
		boolean flag = false;
		if (loginDetails != null) {
			System.out.println("Do login()--yammer");
			flag = true;

		}
		return flag;
		
		
	}

	@Override
	public boolean doSignUp(RegistrationDetails registrationDetails) {
		boolean flag = false;
		if (registrationDetails != null) {
			flag = true;
System.out.println("Do signup--yammer");
		}
		return flag;
	}

	@Override
	public void doPost(LoginDetails loginDetails) {
		if (loginDetails != null) {
			System.out.println("yammer Post is posted successfully by " + loginDetails.getUsername());
		}
	}

	@Override
	public void doLike(LoginDetails loginDetails) {
		// TODO Auto-generated method stub
		if (loginDetails != null) {
			System.out.println("yammer Post is liked successfully by " + loginDetails.getUsername());
		}
	}

	@Override
	public void doComment(LoginDetails loginDetails) {
		// TODO Auto-generated method stub
		if (loginDetails != null) {
			System.out.println("yammer Post is commented successfully by " + loginDetails.getUsername());
		}
	}
	
	public static void linkBankAccount(){
		
		System.out.println("Link bank account");
	}
	
	
	

}

package com.virtusa.facebook.services;

import com.virtusa.facebook.model.LoginDetails;
import com.virtusa.facebook.model.RegistrationDetails;

public class BoomerFB implements IFacebook,INewFacebook {

	@Override
	public boolean doLogin(LoginDetails loginDetails) {
		boolean flag = false;
		if (loginDetails != null) {
			System.out.println("Do login()--boomer");
			flag = true;

		}
		return flag;
		
		
	}

	@Override
	public boolean doSignUp(RegistrationDetails registrationDetails) {
		boolean flag = false;
		if (registrationDetails != null) {
			flag = true;
System.out.println("Do signup--boomer");
		}
		return flag;
	}

	@Override
	public void doPost(LoginDetails loginDetails) {
		if (loginDetails != null) {
			System.out.println("boomer Post is posted successfully by " + loginDetails.getUsername());
		}
	}

	@Override
	public void doLike(LoginDetails loginDetails) {
		// TODO Auto-generated method stub
		if (loginDetails != null) {
			System.out.println("boomer Post is liked successfully by " + loginDetails.getUsername());
		}
	}

	@Override
	public void doComment(LoginDetails loginDetails) {
		// TODO Auto-generated method stub
		if (loginDetails != null) {
			System.out.println("boomer Post is commented successfully by " + loginDetails.getUsername());
		}
	}

	@Override
	public void doChat(LoginDetails loginDetails) {
		// TODO Auto-generated method stub
	System.out.println("Boomer chat");	
	}

	@Override
	public void doPostStatus(LoginDetails loginDetails) {
		// TODO Auto-generated method stub
		System.out.println("Boomer post status");	
			
	}

	@Override
	public void playGames(LoginDetails loginDetails) {
		// TODO Auto-generated method stub
		System.out.println("Boomer paly games");	
		
	}

}
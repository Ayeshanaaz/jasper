package com.virtusa.facebook.services;

import com.virtusa.facebook.model.LoginDetails;
import com.virtusa.facebook.model.RegistrationDetails;

public  interface IFacebook {

	public boolean doLogin(LoginDetails loginDetails);	
	public boolean doSignUp(RegistrationDetails registrationDetails) ;
	public void doPost(LoginDetails loginDetails) ;
	public void doLike(LoginDetails loginDetails) ;
	public void doComment(LoginDetails loginDetails) ;

	default public  void doVideoCall(){
		
		System.out.println("Use inbuild functionality of phone to do video call");
	}
}

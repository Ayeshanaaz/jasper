package com.virtusa.facebook.services;

import com.virtusa.facebook.model.LoginDetails;
import com.virtusa.facebook.model.RegistrationDetails;

public class YammerApp {
	
	public static void main(String[] args) {
		
		YammerFB app=new YammerFB();
		RegistrationDetails registrationDetails=new RegistrationDetails();
		registrationDetails.setFullName("Praveeen Kumar");
		registrationDetails.setDob("20-06-1990");
		registrationDetails.setEmail("praveen@gmail.com");
		registrationDetails.setPassword("*****");
		registrationDetails.setPhone(1234567890L);
		
		LoginDetails loginDetails=
			new LoginDetails(registrationDetails.getEmail()
					,registrationDetails.getPassword());
		
		
		app.doSignUp(registrationDetails);
		app.doLogin(loginDetails);
		app.doPost(loginDetails);
		app.doComment(loginDetails);
		app.doLike(loginDetails);
		
		
	}

}

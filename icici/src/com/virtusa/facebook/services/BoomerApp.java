package com.virtusa.facebook.services;

import com.virtusa.facebook.model.LoginDetails;
import com.virtusa.facebook.model.RegistrationDetails;

public class BoomerApp {
	public static void main(String[] args) {
		
	//	BoomerFB app=new BoomerFB();
		//IFacebook app=new BoomerFB();
			
		
		
		
		RegistrationDetails registrationDetails=new RegistrationDetails();
		registrationDetails.setFullName("Praveeen Kumar");
		registrationDetails.setDob("20-06-1990");
		registrationDetails.setEmail("praveen@gmail.com");
		registrationDetails.setPassword("*****");
		registrationDetails.setPhone(1234567890L);
		
		LoginDetails loginDetails=
			new LoginDetails(registrationDetails.getEmail()
					,registrationDetails.getPassword());
		
		IFacebook app=new YammerFB();
		YammerFB.linkBankAccount();
			app=new BoomerFB();
		app.doSignUp(registrationDetails);
		app.doLogin(loginDetails);
		app.doPost(loginDetails);
		app.doComment(loginDetails);
		app.doLike(loginDetails);
		
		
		IFacebook app2=new BoomerFB();	
		app2.doSignUp(registrationDetails);
		app2.doLogin(loginDetails);
		app2.doPost(loginDetails);
		app2.doComment(loginDetails);
		app2.doLike(loginDetails);
		app2.doVideoCall();
		
		INewFacebook app3=new BoomerFB();	
		//app3.doSignUp(registrationDetails);
		//app3.doLogin(loginDetails);
		//app3.doPost(loginDetails);
		//app3.doComment(loginDetails);
		//app3.doLike(loginDetails);
		
		app3.doChat(loginDetails);
        app3.doPostStatus(loginDetails);	
        app3.playGames(loginDetails);
        
        BoomerFB  fb=new BoomerFB();
        fb.doSignUp(registrationDetails);
		fb.doLogin(loginDetails);
		fb.doPost(loginDetails);
		fb.doComment(loginDetails);
		fb.doLike(loginDetails);
		fb.doChat(loginDetails);
        fb.doPostStatus(loginDetails);	
        fb.playGames(loginDetails);
        
        fb.doVideoCall();
        
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

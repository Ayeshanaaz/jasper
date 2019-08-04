package com.virtusa.facebook.app;

import com.virtusa.bank.model.Account;
import com.virtusa.facebook.model.Facebook;
import com.virtusa.facebook.model.LoginDetails;
import com.virtusa.facebook.model.NewFacebook;
import com.virtusa.facebook.model.RegistrationDetails;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    //Facebook.companyName="GOOGLE";
		 
		System.out.println(NewFacebook.companyName);
		 
		System.out.println(Facebook.companyName);
		//Facebook facebook1=new Facebook("www.favcebook.com","Oracle","UK");
		
		//Facebook facebook=new Facebook("www.fb.com","MYSQL","India");
		RegistrationDetails registrationDetails=new RegistrationDetails();
		registrationDetails.setFullName("Praveeen Kumar");
		registrationDetails.setDob("20-06-1990");
		registrationDetails.setEmail("praveen@gmail.com");
		registrationDetails.setPassword("*****");
		registrationDetails.setPhone(1234567890L);
		
		LoginDetails loginDetails=
			new LoginDetails(registrationDetails.getEmail()
					,registrationDetails.getPassword());
		
		Facebook newFacebook=new NewFacebook();
		newFacebook.doLinkBankAccount(new Account());
		newFacebook.setUrl("www.fbk.com");
		newFacebook.setDatabaseName("Mongodb");
		newFacebook.setCountryName("US");
	boolean signup=	newFacebook.doSignUp(registrationDetails);
		System.out.println("Sign up is done "+signup);
	boolean login=	newFacebook.doLogin(loginDetails);
		
	if(login){
		
		System.out.println("Successfully logged in");
		newFacebook.doPost(loginDetails);
		newFacebook.doComment(loginDetails);
	    newFacebook.doLike(loginDetails);
	   //  newFacebook.doScheduleEvent(loginDetails);
	  //   newFacebook.doPayment(loginDetails);
	  //   newFacebook.doShare(loginDetails);
	     
	    
	    
	}else{
		System.out.println("Plz sigup if you are not registered");
	}
	
	
	}

}

package com.virtusa.facebook.model;

import com.virtusa.bank.model.Account;

public  class NewFacebook extends Facebook {

	private int textDataLimit;
	private int videoFileLimit;
	private int audioFileLimit;
	
	
	
	
	
	public NewFacebook(int textDataLimit, int videoFileLimit, int audioFileLimit,String url, String databaseName, String countryName) {
		super(url, databaseName, countryName);
		this.textDataLimit = textDataLimit;
		this.videoFileLimit = videoFileLimit;
		this.audioFileLimit = audioFileLimit;
	}

	public NewFacebook() {
		super();
		System.out.println("New Facebook constructor");
		// TODO Auto-generated constructor stub
	}

	public NewFacebook(String url, String databaseName, String countryName) {
		super(url, databaseName, countryName);
		System.out.println("New Facebook constructor parameterised");
			
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doSignUp(RegistrationDetails registrationDetails) {
		// TODO Auto-generated method stub
	//System.out.println(super.url);
	boolean flag	=super.doSignUp(registrationDetails);
	System.out.println("Linking the G-pay to the user for payment is done");	
	return flag;
	
	
		
	}
	
	public void doShare(LoginDetails loginDetails){
		if(loginDetails!=null){
		
		System.out.println("Successfully shared on timeline by "+loginDetails.getUsername());
		}		
	}
	
	public void doPayment(LoginDetails loginDetails){
		
		if(loginDetails!=null){
		System.out.println("Successfully payment by "+loginDetails.getUsername());
		}
	}
public void doScheduleEvent(LoginDetails loginDetails){
		if(loginDetails!=null){
		System.out.println("Successfully events schedule by "+loginDetails.getUsername());
		}
	}

@Override
public void doLinkBankAccount(Account account) {
	// TODO Auto-generated method stub
	
	System.out.println("Bank account is linked by New facebook");
	
}
	
	

}

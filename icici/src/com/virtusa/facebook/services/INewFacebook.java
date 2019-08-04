package com.virtusa.facebook.services;

import com.virtusa.facebook.model.LoginDetails;

public interface INewFacebook {
	
	public void doChat(LoginDetails loginDetails);
	public void doPostStatus(LoginDetails loginDetails);
	public void playGames(LoginDetails loginDetails);
	
	

}

package com.virtusa.payroll.model;

public class SecurityDetail {

	public SecurityDetail() {

	}
	private String question;
	private String password;
	public SecurityDetail(String question, String password) {
		super();
		this.question = question;
		this.password = password;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "SecurityDetail [question=" + question + ", password=" + password + "]";
	}
	
}

package com.virtusa.payroll.model;

public class Security {

	
	private  int secId;
	private String secQuestion;
	private String secAns;
	public Security(int secId, String secQuestion, String secAns) {
		super();
		this.secId = secId;
		this.secQuestion = secQuestion;
		this.secAns = secAns;
	}
	public Security() {
		//constructor
	}
	public int getsecId() {
		return secId;
	}
	public void setsecId(int secId) {
		this.secId = secId;
	}
	public String getsecQuestion() {
		return secQuestion;
	}
	public void setsecQuestion(String secQuestion) {
		this.secQuestion = secQuestion;
	}
	public String getsecAns() {
		return secAns;
	}
	public void setsecAns(String secAns) {
		this.secAns = secAns;
	}
	@Override
	public String toString() {
		return "Security [secId=" + secId + ", secQuestion=" + secQuestion + ", secAns=" + secAns + "]";
	}
	
	

}

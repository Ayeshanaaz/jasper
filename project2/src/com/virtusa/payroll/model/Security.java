package com.virtusa.payroll.model;

public class Security {

	public Security() {
		// TODO Auto-generated constructor stub
	}
	private  int sec_id;
	private String sec_question;
	private String sec_ans;
	public Security(int sec_id, String sec_question, String sec_ans) {
		super();
		this.sec_id = sec_id;
		this.sec_question = sec_question;
		this.sec_ans = sec_ans;
	}
	public int getSec_id() {
		return sec_id;
	}
	public void setSec_id(int sec_id) {
		this.sec_id = sec_id;
	}
	public String getSec_question() {
		return sec_question;
	}
	public void setSec_question(String sec_question) {
		this.sec_question = sec_question;
	}
	public String getSec_ans() {
		return sec_ans;
	}
	public void setSec_ans(String sec_ans) {
		this.sec_ans = sec_ans;
	}
	@Override
	public String toString() {
		return "Security [sec_id=" + sec_id + ", sec_question=" + sec_question + ", sec_ans=" + sec_ans + "]";
	}
	
	

}

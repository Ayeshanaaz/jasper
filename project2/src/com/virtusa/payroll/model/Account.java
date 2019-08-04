package com.virtusa.payroll.model;

public class Account {

	public Account() {
	}
	private int acc_no;
	private String acc_bank_name;
	private String acc_ifsc;
	public Account(int acc_no, String acc_bank_name, String acc_ifsc) {
		super();
		this.acc_no = acc_no;
		this.acc_bank_name = acc_bank_name;
		this.acc_ifsc = acc_ifsc;
	}
	public int getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}
	public String getAcc_bank_name() {
		return acc_bank_name;
	}
	public void setAcc_bank_name(String acc_bank_name) {
		this.acc_bank_name = acc_bank_name;
	}
	public String getAcc_ifsc() {
		return acc_ifsc;
	}
	public void setAcc_ifsc(String acc_ifsc) {
		this.acc_ifsc = acc_ifsc;
	}
	@Override
	public String toString() {
		return "Account [acc_no=" + acc_no + ", acc_bank_name=" + acc_bank_name + ", acc_ifsc=" + acc_ifsc + "]";
	}
	
}

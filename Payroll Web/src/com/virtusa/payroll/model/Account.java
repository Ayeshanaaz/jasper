package com.virtusa.payroll.model;

public class Account {

	public Account() {

	}
	private int accNo;
	private String accBankName;
	private String accIfsc;
	public Account(int accNo, String accBankName, String accIfsc) {
		super();
		this.accNo = accNo;
		this.accBankName = accBankName;
		this.accIfsc = accIfsc;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getAccBankName() {
		return accBankName;
	}
	public void setAccBankName(String accBankName) {
		this.accBankName = accBankName;
	}
	public String getAccIfsc() {
		return accIfsc;
	}
	public void setAccIfsc(String accIfsc) {
		this.accIfsc = accIfsc;
	}
	@Override
	public String toString() {
		return "Account [acc_no=" + accNo + ", acc_bank_name=" + accBankName + ", acc_ifsc=" + accIfsc + "]";
	}
	
}

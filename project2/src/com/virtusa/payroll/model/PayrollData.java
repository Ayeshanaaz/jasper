package com.virtusa.payroll.model;

public class PayrollData {

	public PayrollData() {
		// TODO Auto-generated constructor stub
	}
	private String pay_id;
	private Employee employee;
	private String pay_month;
	private int pay_year;
	private String pay_details;
	public PayrollData(String pay_id, Employee employee, String pay_month, int pay_year, String pay_details) {
		super();
		this.pay_id = pay_id;
		this.employee = employee;
		this.pay_month = pay_month;
		this.pay_year = pay_year;
		this.pay_details = pay_details;
	}
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getPay_month() {
		return pay_month;
	}
	public void setPay_month(String pay_month) {
		this.pay_month = pay_month;
	}
	public int getPay_year() {
		return pay_year;
	}
	public void setPay_year(int i) {
		this.pay_year = i;
	}
	public String getPay_details() {
		return pay_details;
	}
	public void setPay_details(String pay_details) {
		this.pay_details = pay_details;
	}
	@Override
	public String toString() {
		return "PayrollData [pay_id=" + pay_id + ", employee=" + employee + ", pay_month=" + pay_month + ", pay_year="
				+ pay_year + ", pay_details=" + pay_details + "]";
	}
	
}

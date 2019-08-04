package com.virtusa.payroll.model;

public class PayrollData {

	private String payId;
	private Employee employee;
	private String payMonth;
	private int payYear;
	private String payDetails;
	public PayrollData(String payId, Employee employee, String payMonth, int payYear, String payDetails) {
		super();
		this.payId = payId;
		this.employee = employee;
		this.payMonth = payMonth;
		this.payYear = payYear;
		this.payDetails = payDetails;
	}
	public PayrollData() {
		//constructor
	}
	public String getpayId() {
		return payId;
	}
	public void setpayId(String payId) {
		this.payId = payId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getpayMonth() {
		return payMonth;
	}
	public void setpayMonth(String payMonth) {
		this.payMonth = payMonth;
	}
	public int getpayYear() {
		return payYear;
	}
	public void setpayYear(int i) {
		this.payYear = i;
	}
	public String getpayDetails() {
		return payDetails;
	}
	public void setpayDetails(String payDetails) {
		this.payDetails = payDetails;
	}
	@Override
	public String toString() {
		return "PayrollData [payId=" + payId + ", employee=" + employee + ", payMonth=" + payMonth + ", payYear="
				+ payYear + ", payDetails=" + payDetails + "]";
	}
	
}

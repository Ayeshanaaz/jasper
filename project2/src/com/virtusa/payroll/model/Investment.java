package com.virtusa.payroll.model;

public class Investment {

	public Investment() {
		// TODO Auto-generated constructor stub
	}
	private int inv_id;
	private Employee employee;
	private String inv_insurance;
	private String inv_eduloan;
	private String inv_ppf;
	private String inv_loan;
	public Investment(int inv_id, Employee employee, String inv_insurance, String inv_eduloan, String inv_ppf,
			String inv_loan) {
		super();
		this.inv_id = inv_id;
		this.employee = employee;
		this.inv_insurance = inv_insurance;
		this.inv_eduloan = inv_eduloan;
		this.inv_ppf = inv_ppf;
		this.inv_loan = inv_loan;
	}
	public int getInv_id() {
		return inv_id;
	}
	public void setInv_id(int inv_id) {
		this.inv_id = inv_id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getInv_insurance() {
		return inv_insurance;
	}
	public void setInv_insurance(String inv_insurance) {
		this.inv_insurance = inv_insurance;
	}
	public String getInv_eduloan() {
		return inv_eduloan;
	}
	public void setInv_eduloan(String inv_eduloan) {
		this.inv_eduloan = inv_eduloan;
	}
	public String getInv_ppf() {
		return inv_ppf;
	}
	public void setInv_ppf(String inv_ppf) {
		this.inv_ppf = inv_ppf;
	}
	public String getInv_loan() {
		return inv_loan;
	}
	public void setInv_loan(String inv_loan) {
		this.inv_loan = inv_loan;
	}
	@Override
	public String toString() {
		return "Investment [inv_id=" + inv_id + ", employee=" + employee + ", inv_insurance=" + inv_insurance
				+ ", inv_eduloan=" + inv_eduloan + ", inv_ppf=" + inv_ppf + ", inv_loan=" + inv_loan + "]";
	}
	
}

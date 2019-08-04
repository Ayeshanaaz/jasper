package com.virtusa.payroll.model;

public class Reimbursement {

	public Reimbursement() {
		// TODO Auto-generated constructor stub
	}
	
	private int re_id;
	private Employee employee;
	private String re_type;
	private float re_amount;
	private String re_path;
	public Reimbursement(int re_id, Employee employee, String re_type, float re_amount, String re_path) {
		super();
		this.re_id = re_id;
		this.employee = employee;
		this.re_type = re_type;
		this.re_amount = re_amount;
		this.re_path = re_path;
	}
	public int getRe_id() {
		return re_id;
	}
	public void setRe_id(int re_id) {
		this.re_id = re_id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getRe_type() {
		return re_type;
	}
	public void setRe_type(String re_type) {
		this.re_type = re_type;
	}
	public float getRe_amount() {
		return re_amount;
	}
	public void setRe_amount(float re_amount) {
		this.re_amount = re_amount;
	}
	public String getRe_path() {
		return re_path;
	}
	public void setRe_path(String re_path) {
		this.re_path = re_path;
	}
	@Override
	public String toString() {
		return "Reimbursement [re_id=" + re_id + ", employee=" + employee + ", re_type=" + re_type + ", re_amount="
				+ re_amount + ", re_path=" + re_path + "]";
	}
	

}

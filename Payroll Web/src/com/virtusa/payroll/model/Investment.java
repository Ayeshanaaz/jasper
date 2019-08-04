package com.virtusa.payroll.model;

public class Investment {

	
	private int invId;
	private Employee employee;
	private String invInsurance;
	private String invEduloan;
	private String invPpf;
	private String invLoan;
	public Investment(int invId, Employee employee, String invInsurance, String invEduloan, String invPpf,
			String invLoan) {
		super();
		this.invId = invId;
		this.employee = employee;
		this.invInsurance = invInsurance;
		this.invEduloan = invEduloan;
		this.invPpf = invPpf;
		this.invLoan = invLoan;
	}
	public Investment() {
	//constructor
	}
	public int getinvId() {
		return invId;
	}
	public void setinvId(int invId) {
		this.invId = invId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getinvInsurance() {
		return invInsurance;
	}
	public void setinvInsurance(String invInsurance) {
		this.invInsurance = invInsurance;
	}
	public String getinvEduloan() {
		return invEduloan;
	}
	public void setinvEduloan(String invEduloan) {
		this.invEduloan = invEduloan;
	}
	public String getinvPpf() {
		return invPpf;
	}
	public void setinvPpf(String invPpf) {
		this.invPpf = invPpf;
	}
	public String getinvLoan() {
		return invLoan;
	}
	public void setinvLoan(String invLoan) {
		this.invLoan = invLoan;
	}
	@Override
	public String toString() {
		return "Investment [invId=" + invId + ", employee=" + employee + ", invInsurance=" + invInsurance
				+ ", invEduloan=" + invEduloan + ", invPpf=" + invPpf + ", invLoan=" + invLoan + "]";
	}
	
}

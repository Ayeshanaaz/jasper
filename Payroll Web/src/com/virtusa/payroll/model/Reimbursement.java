package com.virtusa.payroll.model;

public class Reimbursement {

	
	
	private int reId;
	private Employee employee;
	private String reType;
	private float reAmount;
	private String rePath;
	public Reimbursement(int reId, Employee employee, String reType, float reAmount, String rePath) {
		super();
		this.reId = reId;
		this.employee = employee;
		this.reType = reType;
		this.reAmount = reAmount;
		this.rePath = rePath;
	}
	public Reimbursement() {
	//constructor
	}
	public int getreId() {
		return reId;
	}
	public void setreId(int reId) {
		this.reId = reId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getreType() {
		return reType;
	}
	public void setreType(String reType) {
		this.reType = reType;
	}
	public float getreAmount() {
		return reAmount;
	}
	public void setreAmount(float reAmount) {
		this.reAmount = reAmount;
	}
	public String getrePath() {
		return rePath;
	}
	public void setrePath(String rePath) {
		this.rePath = rePath;
	}
	@Override
	public String toString() {
		return "Reimbursement [reId=" + reId + ", employee=" + employee + ", reType=" + reType + ", reAmount="
				+ reAmount + ", rePath=" + rePath + "]";
	}
	

}

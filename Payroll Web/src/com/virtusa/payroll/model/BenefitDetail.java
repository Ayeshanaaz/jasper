package com.virtusa.payroll.model;

public class BenefitDetail {

	
	
	private int benId;
	private Employee employee;
	private float benLta;
	private float benPhone;
	private float benChildfee;
	private float benFood;
	public BenefitDetail(int benId, Employee employee, float benLta, float benPhone, float benChildfee, float benFood) {
		super();
		this.benId = benId;
		this.employee = employee;
		this.benLta = benLta;
		this.benPhone = benPhone;
		this.benChildfee = benChildfee;
		this.benFood = benFood;
	}
	public BenefitDetail() {
		
	}
	public int getbenId() {
		return benId;
	}
	public void setbenId(int benId) {
		this.benId = benId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public float getbenLta() {
		return benLta;
	}
	public void setbenLta(float benLta) {
		this.benLta = benLta;
	}
	public float getbenPhone() {
		return benPhone;
	}
	public void setbenPhone(float benPhone) {
		this.benPhone = benPhone;
	}
	public float getbenChildfee() {
		return benChildfee;
	}
	public void setbenChildfee(float benChildfee) {
		this.benChildfee = benChildfee;
	}
	public float getbenFood() {
		return benFood;
	}
	public void setbenFood(float benFood) {
		this.benFood = benFood;
	}
	@Override
	public String toString() {
		return "Benefits [benId=" + benId + ", employee=" + employee + ", benLta=" + benLta + ", benPhone="
				+ benPhone + ", benChildfee=" + benChildfee + ", benFood=" + benFood + "]";
	}
	
	

}

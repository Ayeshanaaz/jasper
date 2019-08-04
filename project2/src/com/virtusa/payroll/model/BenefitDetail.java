package com.virtusa.payroll.model;

public class BenefitDetail {

	public BenefitDetail() {
		// TODO Auto-generated constructor stub
	}
	private int ben_id;
	private Employee employee;
	private float ben_lta;
	private float ben_phone;
	private float ben_childfee;
	private float ben_food;
	public BenefitDetail(int ben_id, Employee employee, float ben_lta, float ben_phone, float ben_childfee, float ben_food) {
		super();
		this.ben_id = ben_id;
		this.employee = employee;
		this.ben_lta = ben_lta;
		this.ben_phone = ben_phone;
		this.ben_childfee = ben_childfee;
		this.ben_food = ben_food;
	}
	public int getBen_id() {
		return ben_id;
	}
	public void setBen_id(int ben_id) {
		this.ben_id = ben_id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public float getBen_lta() {
		return ben_lta;
	}
	public void setBen_lta(float ben_lta) {
		this.ben_lta = ben_lta;
	}
	public float getBen_phone() {
		return ben_phone;
	}
	public void setBen_phone(float ben_phone) {
		this.ben_phone = ben_phone;
	}
	public float getBen_childfee() {
		return ben_childfee;
	}
	public void setBen_childfee(float ben_childfee) {
		this.ben_childfee = ben_childfee;
	}
	public float getBen_food() {
		return ben_food;
	}
	public void setBen_food(float ben_food) {
		this.ben_food = ben_food;
	}
	@Override
	public String toString() {
		return "Benefits [ben_id=" + ben_id + ", employee=" + employee + ", ben_lta=" + ben_lta + ", ben_phone="
				+ ben_phone + ", ben_childfee=" + ben_childfee + ", ben_food=" + ben_food + "]";
	}
	
	

}

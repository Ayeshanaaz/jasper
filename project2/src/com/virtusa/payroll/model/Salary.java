package com.virtusa.payroll.model;

public class Salary {

	public Salary() {
		// TODO Auto-generated constructor stub
	}
	private int sal_id;
	private int sal_package;
	private float sal_basic;
	private float sal_hra;
	private float sal_bonus;
	private float sal_allowance;
	public Salary(int sal_id, int sal_package, float sal_basic, float sal_hra, float sal_bonus, float sal_allowance) {
		super();
		this.sal_id = sal_id;
		this.sal_package = sal_package;
		this.sal_basic = sal_basic;
		this.sal_hra = sal_hra;
		this.sal_bonus = sal_bonus;
		this.sal_allowance = sal_allowance;
	}
	public int getSal_id() {
		return sal_id;
	}
	public void setSal_id(int sal_id) {
		this.sal_id = sal_id;
	}
	public int getSal_package() {
		return sal_package;
	}
	public void setSal_package(int sal_package) {
		this.sal_package = sal_package;
	}
	public float getSal_basic() {
		return sal_basic;
	}
	public void setSal_basic(float sal_basic) {
		this.sal_basic = sal_basic;
	}
	public float getSal_hra() {
		return sal_hra;
	}
	public void setSal_hra(float sal_hra) {
		this.sal_hra = sal_hra;
	}
	public float getSal_bonus() {
		return sal_bonus;
	}
	public void setSal_bonus(float sal_bonus) {
		this.sal_bonus = sal_bonus;
	}
	public float getSal_allowance() {
		return sal_allowance;
	}
	public void setSal_allowance(float sal_allowance) {
		this.sal_allowance = sal_allowance;
	}
	@Override
	public String toString() {
		return "Salary [sal_id=" + sal_id + ", sal_package=" + sal_package + ", sal_basic=" + sal_basic + ", sal_hra="
				+ sal_hra + ", sal_bonus=" + sal_bonus + ", sal_allowance=" + sal_allowance + "]";
	}
	
	
}

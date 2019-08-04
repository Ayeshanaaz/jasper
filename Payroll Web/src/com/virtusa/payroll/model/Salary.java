package com.virtusa.payroll.model;

public class Salary {

	
	private int salId;
	private int salpackage;
	private float salBasic;
	private float salHra;
	private float salBonus;
	private float salAllowance;
	public Salary(int salId, int salpackage, float salBasic, float salHra, float salBonus, float salAllowance) {
		super();
		this.salId = salId;
		this.salpackage = salpackage;
		this.salBasic = salBasic;
		this.salHra = salHra;
		this.salBonus = salBonus;
		this.salAllowance = salAllowance;
	}
	public Salary() {
		//constructor
	}
	public int getsalId() {
		return salId;
	}
	public void setsalId(int salId) {
		this.salId = salId;
	}
	public int getsalpackage() {
		return salpackage;
	}
	public void setsalpackage(int salpackage) {
		this.salpackage = salpackage;
	}
	public float getsalBasic() {
		return salBasic;
	}
	public void setsalBasic(float salBasic) {
		this.salBasic = salBasic;
	}
	public float getsalHra() {
		return salHra;
	}
	public void setsalHra(float salHra) {
		this.salHra = salHra;
	}
	public float getsalBonus() {
		return salBonus;
	}
	public void setsalBonus(float salBonus) {
		this.salBonus = salBonus;
	}
	public float getsalAllowance() {
		return salAllowance;
	}
	public void setsalAllowance(float salAllowance) {
		this.salAllowance = salAllowance;
	}
	@Override
	public String toString() {
		return "Salary [salId=" + salId + ", salpackage=" + salpackage + ", salBasic=" + salBasic + ", salHra="
				+ salHra + ", salBonus=" + salBonus + ", salAllowance=" + salAllowance + "]";
	}
	
	
}

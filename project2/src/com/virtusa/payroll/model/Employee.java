package com.virtusa.payroll.model;

import java.sql.Date;

public class Employee {

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	private int emp_id;
	private String emp_password;
	private String emp_name;
	private Date emp_dob;
	private Date emp_doj;
	private String emp_gender;
	private String emp_pan;
	private Location location;
	private Designation designation;
	private Account account;
	private Salary salary;
	private Mbopayouts mbopayouts;
	private Admin admin;
	public Employee(int emp_id, String emp_password, String emp_name, Date emp_dob, Date emp_doj, String emp_gender,
			String emp_pan, Location location, Designation designation, Account account, Salary salary,
			Mbopayouts mbopayouts, Admin admin) {
		super();
		this.emp_id = emp_id;
		this.emp_password = emp_password;
		this.emp_name = emp_name;
		this.emp_dob = emp_dob;
		this.emp_doj = emp_doj;
		this.emp_gender = emp_gender;
		this.emp_pan = emp_pan;
		this.location = location;
		this.designation = designation;
		this.account = account;
		this.salary = salary;
		this.mbopayouts = mbopayouts;
		this.admin = admin;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_password() {
		return emp_password;
	}
	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Date getEmp_dob() {
		return emp_dob;
	}
	public void setEmp_dob(Date emp_dob) {
		this.emp_dob = emp_dob;
	}
	public Date getEmp_doj() {
		return emp_doj;
	}
	public void setEmp_doj(Date emp_doj) {
		this.emp_doj = emp_doj;
	}
	public String getEmp_gender() {
		return emp_gender;
	}
	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}
	public String getEmp_pan() {
		return emp_pan;
	}
	public void setEmp_pan(String emp_pan) {
		this.emp_pan = emp_pan;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Designation getDesignation() {
		return designation;
	}
	public void setDesignation(Designation designation) {
		this.designation = designation;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	public Mbopayouts getMbopayouts() {
		return mbopayouts;
	}
	public void setMbopayouts(Mbopayouts mbopayouts) {
		this.mbopayouts = mbopayouts;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_password=" + emp_password + ", emp_name=" + emp_name + ", emp_dob="
				+ emp_dob + ", emp_doj=" + emp_doj + ", emp_gender=" + emp_gender + ", emp_pan=" + emp_pan
				+ ", location=" + location + ", designation=" + designation + ", account=" + account + ", salary="
				+ salary + ", mbopayouts=" + mbopayouts + ", admin=" + admin + "]";
	}
	
}

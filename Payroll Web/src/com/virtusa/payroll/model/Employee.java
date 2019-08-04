package com.virtusa.payroll.model;

import java.sql.Date;

public class Employee {

	
	private int empId;
	private String empPassword;
	private String empName;
	private Date empDob;
	private Date empDoj;
	private String empGender;
	private String empPan;
	private int empContact;
	
	private String empEmail;
	private String empAddress;
	private Location location;
	private Designation designation;
	private Account account;
	private Salary salary;
	private Mbopayouts mbopayouts;
	private Admin admin;
	public Employee(){
		super();
		
	}
		public Employee(Location location, Designation designation, Account account, Salary salary,
				Mbopayouts mbopayouts, Admin admin) {
		super();
		this.location = location;
		this.designation = designation;
		this.account = account;
		this.salary = salary;
		this.mbopayouts = mbopayouts;
		this.admin = admin;
	}
	
	public int getempId() {
		return empId;
	}
	public void setempId(int empId) {
		this.empId = empId;
	}
	public String getempPassword() {
		return empPassword;
	}
	public void setempPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public String getempName() {
		return empName;
	}
	public void setempName(String empName) {
		this.empName = empName;
	}
	public Date getempDob() {
		return empDob;
	}
	public void setempDob(Date empDob) {
		this.empDob = empDob;
	}
	public Date getempDoj() {
		return empDoj;
	}
	public void setempDoj(Date empDoj) {
		this.empDoj = empDoj;
	}
	public String getempGender() {
		return empGender;
	}
	public void setempGender(String empGender) {
		this.empGender = empGender;
	}
	public String getempPan() {
		return empPan;
	}
	public void setempPan(String empPan) {
		this.empPan = empPan;
	}
	public int getempContact() {
		return empContact;
	}
	public void setempContact(int empContact) {
		this.empContact = empContact;
	}
	public String getempEmail() {
		return empEmail;
	}
	public void setempEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getempAddress() {
		return empAddress;
	}
	public void setempAddress(String empAddress) {
		this.empAddress = empAddress;
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
		return "Employee [empId=" + empId + ", empPassword=" + empPassword + ", empName=" + empName + ", empDob="
				+ empDob + ", empDoj=" + empDoj + ", empGender=" + empGender + ", empPan=" + empPan
				+ ", location=" + location + ", designation=" + designation + ", account=" + account + ", salary="
				+ salary + ", mbopayouts=" + mbopayouts + ", admin=" + admin + "]";
	}
	
}

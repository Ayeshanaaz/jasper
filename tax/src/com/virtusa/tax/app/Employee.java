package com.virtusa.tax.app;

public class Employee {
	int id;
	String name;
	int age;
	double annualIncome;
	String email;
    Address address;
	public Employee(int id, String name, int age, double annualIncome, String email, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.annualIncome = annualIncome;
		this.email = email;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public float getSalary() {
		// TODO Auto-generated method stub
		return 0;
	}
    
}
class Address
{
	String addressLine1;
	String addressLine2;
	String Locality;
	String city;
	int pinCode;
	public Address(String addressLine1, String addressLine2, String locality, String city, int pinCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		Locality = locality;
		this.city = city;
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", Locality=" + Locality
				+ ", city=" + city + ", pinCode=" + pinCode + "]";
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getLocality() {
		return Locality;
	}
	public void setLocality(String locality) {
		Locality = locality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
}

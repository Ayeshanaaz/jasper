package com.virtusa.payroll.model;

public class Designation {

	public Designation() {
		// TODO Auto-generated constructor stub
	}
	private int desg_id;
	private String desg_name;
	public Designation(int desg_id, String desg_name) {
		super();
		this.desg_id = desg_id;
		this.desg_name = desg_name;
	}
	public int getDesg_id() {
		return desg_id;
	}
	public void setDesg_id(int desg_id) {
		this.desg_id = desg_id;
	}
	public String getDesg_name() {
		return desg_name;
	}
	public void setDesg_name(String desg_name) {
		this.desg_name = desg_name;
	}
	@Override
	public String toString() {
		return "Designation [desg_id=" + desg_id + ", desg_name=" + desg_name + "]";
	}
	
}

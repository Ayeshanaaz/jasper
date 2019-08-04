package com.virtusa.payroll.model;

public class Designation {


	private int desgId;
	private String desgName;
	public Designation(int desgId, String desgName) {
		super();
		this.desgId = desgId;
		this.desgName = desgName;
	}
	public int getdesgId() {
		return desgId;
	}
	public void setdesgId(int desgId) {
		this.desgId = desgId;
	}
	public String getdesgName() {
		return desgName;
	}
	public void setdesgName(String desgName) {
		this.desgName = desgName;
	}
	@Override
	public String toString() {
		return "Designation [desgId=" + desgId + ", desgName=" + desgName + "]";
	}
	
}

package com.virtusa.payroll.model;

public class Location {

	
	private int locId;
	private String locName;
	public Location(int locId, String locName) {
		super();
		this.locId = locId;
		this.locName = locName;
	}
	public int getlocId() {
		return locId;
	}
	public void setlocId(int locId) {
		this.locId = locId;
	}
	public String getlocName() {
		return locName;
	}
	public void setlocName(String locName) {
		this.locName = locName;
	}
	@Override
	public String toString() {
		return "Location [locId=" + locId + ", locName=" + locName + "]";
	}
	

}

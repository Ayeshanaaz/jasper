package com.virtusa.payroll.model;

public class Location {

	public Location() {
		// TODO Auto-generated constructor stub
	}
	private int loc_id;
	private String loc_name;
	public Location(int loc_id, String loc_name) {
		super();
		this.loc_id = loc_id;
		this.loc_name = loc_name;
	}
	public int getLoc_id() {
		return loc_id;
	}
	public void setLoc_id(int loc_id) {
		this.loc_id = loc_id;
	}
	public String getLoc_name() {
		return loc_name;
	}
	public void setLoc_name(String loc_name) {
		this.loc_name = loc_name;
	}
	@Override
	public String toString() {
		return "Location [loc_id=" + loc_id + ", loc_name=" + loc_name + "]";
	}
	

}

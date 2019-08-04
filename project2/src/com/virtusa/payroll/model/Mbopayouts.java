package com.virtusa.payroll.model;

public class Mbopayouts {

	public Mbopayouts() {
		// TODO Auto-generated constructor stub
	}
	private int mbo_rating;
	private int mbo_bonus;
	public Mbopayouts(int mbo_rating, int mbo_bonus) {
		super();
		this.mbo_rating = mbo_rating;
		this.mbo_bonus = mbo_bonus;
	}
	public int getMbo_rating() {
		return mbo_rating;
	}
	public void setMbo_rating(int mbo_rating) {
		this.mbo_rating = mbo_rating;
	}
	public int getMbo_bonus() {
		return mbo_bonus;
	}
	public void setMbo_bonus(int mbo_bonus) {
		this.mbo_bonus = mbo_bonus;
	}
	@Override
	public String toString() {
		return "Mbopayouts [mbo_rating=" + mbo_rating + ", mbo_bonus=" + mbo_bonus + "]";
	}
	
}

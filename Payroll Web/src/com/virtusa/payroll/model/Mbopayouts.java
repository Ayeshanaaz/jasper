package com.virtusa.payroll.model;

public class Mbopayouts {

	
	private int mboRating;
	private int mboBonus;
	public Mbopayouts(int mboRating, int mboBonus) {
		super();
		this.mboRating = mboRating;
		this.mboBonus = mboBonus;
	}
	public int getmboRating() {
		return mboRating;
	}
	public void setmboRating(int mboRating) {
		this.mboRating = mboRating;
	}
	public int getmboBonus() {
		return mboBonus;
	}
	public void setmboBonus(int mboBonus) {
		this.mboBonus = mboBonus;
	}
	@Override
	public String toString() {
		return "Mbopayouts [mboRating=" + mboRating + ", mboBonus=" + mboBonus + "]";
	}
	
}

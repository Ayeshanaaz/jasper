package com.virtusa.zomato.model;

import java.time.LocalDate;

public class MembershipDetail {

	public MembershipDetail() {
		// TODO Auto-generated constructor stub
	}
	
	private int memberId;
	private LocalDate startDate;
	private LocalDate endDate;
	private String type;
	// fk
	private CustomerDetail customerDetail;
	public MembershipDetail(int memberId, LocalDate startDate, LocalDate endDate, String type,
			CustomerDetail customerDetail) {
		super();
		this.memberId = memberId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.customerDetail = customerDetail;
	}
	@Override
	public String toString() {
		return "MembershipDetail [memberId=" + memberId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", type=" + type + ", customerDetail=" + customerDetail + "]";
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}
	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}
	
	
	

}

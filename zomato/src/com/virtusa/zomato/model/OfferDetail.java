package com.virtusa.zomato.model;

import java.time.LocalDate;

public class OfferDetail {

	public OfferDetail() {
		// TODO Auto-generated constructor stub
	}

	
	private int offerId;
	private String offerName;
	private int discount;
	@Override
	public String toString() {
		return "OfferDetail [offerId=" + offerId + ", offerName=" + offerName + ", discount=" + discount
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	public OfferDetail(int offerId, String offerName, int discount, LocalDate startDate, LocalDate endDate) {
		super();
		this.offerId = offerId;
		this.offerName = offerName;
		this.discount = discount;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
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


	private LocalDate startDate;
	private LocalDate endDate;
	
}

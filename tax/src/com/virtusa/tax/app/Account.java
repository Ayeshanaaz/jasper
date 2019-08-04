package com.virtusa.tax.app;

public class Account implements Cloneable{
	private float amount;
	private char transcationType;
	private float transcationAmount;
	private float accountNumber;
	@Override
	
	public String toString() {
		return "Account [amount=" + amount + ", accountNumber=" + accountNumber + "]";
	}
	public Account(float accountNumber,float amount ) {
		super();
		this.amount = amount;
		this.accountNumber = accountNumber;
	}
	public Account(float amount, char transcationType, float transcationAmount, float accountNumber) {
		super();
		this.amount = amount;
		this.transcationType = transcationType;
		this.transcationAmount = transcationAmount;
		this.accountNumber = accountNumber;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public char getTranscationType() {
		return transcationType;
	}
	public void setTranscationType(char transcationType) {
		this.transcationType = transcationType;
	}
	public float getTranscationAmount() {
		return transcationAmount;
	}
	public void setTranscationAmount(float transcationAmount) {
		this.transcationAmount = transcationAmount;
	}
	public float getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(float accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Account()
	{
		
	}
	public void transcation(char transcationType,float transcationAmount)
	{
	if(transcationType=='w')
	{
	withdraw(transcationAmount);
	}
	if(transcationType=='d')
	{
	deposite(transcationAmount);
	}
	}public void deposite(float transcationAmount)
	{
		System.out.println(accountNumber+"has balance amount before deposite is"+amount);
		amount+=transcationAmount;
		System.out.println(accountNumber+"the balance amount after deposite is"+amount);
		}
		public void withdraw(float transcationAmount)
		{
		System.out.println(accountNumber+"the balance amount before withdrawal is"+amount);
		amount-=transcationAmount;
		System.out.println(accountNumber+"the balance amount after withdrawal is"+amount);
		}

}
	

package com.virtusa.calculator;

public class Main {

	public static void main(String args[])
	{
		int a=10,b=0;
		Calculator calculator= new Calculator();
		int result =calculator.division(a,b);
		System.out.println("the division of " +a+" / "+b+" = " +result);
	}

}

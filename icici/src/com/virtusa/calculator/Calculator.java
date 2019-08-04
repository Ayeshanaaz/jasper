package com.virtusa.calculator;

public class Calculator {

	public int division( int a, int b){
		
	
	int c=0;
	try {
		c=a/b;
		System.out.println("There is no exception");
	}
	catch (ArithmeticException e)
	{
		
		System.out.println(e.getMessage());
	}
	
	finally{
		System.out.println("Finally Executed");
	}
	
return c;
}
}

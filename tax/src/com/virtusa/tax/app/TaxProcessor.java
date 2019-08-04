package com.virtusa.tax.app;

public class TaxProcessor {

	public void processTax(Employee emp)
	{
		float salary=emp.getSalary();
		if(salary<250000f){

		System.out.println("No income tax for salary less than 250000");

		}
		else if(salary>250000f && salary<=500000f)
		{
		System.out.println("Income tax is "+(salary-200000)*5/100);

		}
		else if(salary>500000f && salary<=1000000f){
		System.out.println("Income tax is "+12500+((salary-500000)*20/100));
		}
		else
		{
		System.out.println("Income tax is "+112500+((salary-1000000)*30/100));
		}
		}

	}




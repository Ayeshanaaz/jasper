package com.virtusa.bank.app;
import com.virtusa.bank.model.*;

public class BankMain {

	public BankMain() {
			}

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Account account=new Account(123456789L,45000);
		
		System.out.println(account.hashCode());
		Account bansalAccount=new Account(123456780L,345000);
		Account nischayAccount=new Account(123456789L,345000);
		
		
	boolean same=	bansalAccount.equals(nischayAccount);
		System.out.println("Same or not"+same);
		
	Account account2=(Account) account.cloneAccount();
	System.out.println(account2);
		System.out.println(account);
		account.transaction('w',100000);
		account.transaction('d',10000);

		String[] data={"100001,50000,d,1000","100002,60000,d,2000","100001,50000,w,10000","100002,50000,w,10000","100004,650000,d,1000"};

		// split

		for(int i=0;i<data.length;i++){
			try{
		String temp=data[i];
		String arr[]=  temp.split(",");
		long accountNo=Long.parseLong(arr[0]);
		float balance=Float.parseFloat(arr[1]);
		char transactionType=arr[2].charAt(0);        
		float transactionAmount=Float.parseFloat(arr[3]);
		Account account1=new Account(accountNo,balance);
		account1.transaction(transactionType,transactionAmount);
		
			}
			
			
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			
			}
		
		}

	}

}

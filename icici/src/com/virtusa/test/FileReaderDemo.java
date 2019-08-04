package com.virtusa.test;


	import java.io.*;
	import java.util.*;

	import com.virtusa.bank.model.Account;
	public class FileReaderDemo {

	public FileReaderDemo() {
	super();
	// TODO Auto-generated constructor stub
	}
	public static void main(String[] args){
	FileReader fr=null;
	BufferedReader br=null;
	String data="";
	try{
	fr=new FileReader("d:\\sample1.txt");
	br=new BufferedReader(fr);
	List<Account> li=new LinkedList<>();
	while((data=br.readLine())!=null){
	System.out.println(data);
	String arr[]=data.split(",");
	float accno=Float.parseFloat(arr[0]);
	float bala=Float.parseFloat(arr[1]);
	char transactionType=arr[2].charAt(0);
	float transactionAmount = Float.parseFloat(arr[3]);
	Account acc1=new Account();
	acc1.transaction(transactionType, transactionAmount);
	li.add(acc1);
	}
	}
	catch(FileNotFoundException e){
	System.out.println("file not available afte rsome time");
	} catch (NumberFormatException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	}
	



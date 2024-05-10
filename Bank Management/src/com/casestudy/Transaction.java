package com.casestudy;

import java.util.Scanner;
public class Transaction 
{
	static Transaction[] details=new Transaction[10];
	int accNo;
	String processName;
	double amount;
	
	public Transaction(int accNo, String processName, double amount)
	{
		super();
		this.accNo = accNo;
		this.processName = processName;
		this.amount = amount;
	}
	public int getAccNo()
	{
		return accNo;
	}
	public void setAccNo(int accNo) 
	{
		this.accNo = accNo;
	}
	public String getProcessName()
	{
		return processName;
	}
	public void setProcessName(String processName) 
	{
		this.processName = processName;
	}
	public double getAmount() 
	{
		return amount;
	}
	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	
	

}

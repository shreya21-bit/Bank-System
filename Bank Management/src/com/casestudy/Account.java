package com.casestudy;
import java.time.LocalDate;
import java.util.Date;
public abstract class Account
{
	int accNo;
	String holderName;
	double balance;
	
	abstract double deposite();
	abstract double withdraw();
	abstract void calculateinterest();
	abstract void checkbalance();
	
	public Account() 
	{
		this.accNo=0000;
		this.holderName="ABC";
		this.balance=0.00;
	}

	public Account(int accNo, String holderName, double balance) 
	{
		super();
		this.accNo = accNo;
		this.holderName = holderName;
		this.balance = balance;
	}

	public int getAccNo() 
	{
		return accNo;
	}

	public void setAccNo(int accNo) 
	{
		this.accNo = accNo;
	}

	public String getHolderName()
	{
		return holderName;
	}

	public void setHolderName(String holderName)
	{
		this.holderName = holderName;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance) 
	{
		this.balance = balance;
	}
	public String toString() 
	{
		return "accNo=" + this.accNo + ",\nhName=" + this.holderName + ",\nbalance=" + this.balance ;
			
	}
}

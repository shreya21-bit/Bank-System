package com.casestudy;
import java.util.Scanner;

public class CurrentAccount extends Account
{
	double OverDraftLimit;
	double OverDraftedAmt;
	
	static Scanner sc =new Scanner(System.in);
	public CurrentAccount(int accNo,String holderName,double balance,double OverDraftLimit,double OverDraftedAmt) 
	{
		super(accNo,holderName,balance);
		this.OverDraftLimit = OverDraftLimit;
		this.OverDraftedAmt = OverDraftedAmt;
	}


	public double getOverDraftLimit()
	{
		return OverDraftLimit;
	}


	public void setOverDraftLimit(double overDraftLimit)
	{
		OverDraftLimit = overDraftLimit;
	}


	public double getOverDraftedAmt()
	{
		return OverDraftedAmt;
	}


	public void setOverDraftedAmt(double overDraftedAmt ) 
	{
		OverDraftedAmt = overDraftedAmt;
	}
	
	public double deposite()
	{
		System.out.println("Enter the amount you want to deposite");
		double amount=sc.nextInt();
		if(OverDraftedAmt==0)
		{
			this.setBalance(this.getBalance()+amount);
			System.out.println("Your amount deposited sucesfully");
			return amount;
		}
		else
		{
			
			if(amount<=OverDraftedAmt)
			{
				this.setOverDraftedAmt(OverDraftedAmt-amount);
				this.setOverDraftLimit(OverDraftLimit+amount);
				System.out.println("Your amount deposited sucesfully");
				System.out.println("Your overdrafted amount is "+ OverDraftedAmt);
				return amount;
				
			}
			if(amount>OverDraftedAmt)
			{
				this.setOverDraftLimit(OverDraftLimit + OverDraftedAmt);
				this.setBalance(amount-OverDraftedAmt);
				this.setOverDraftedAmt(0);
				System.out.println("Your amount deposited sucesfully");
				System.out.println("Your overdrafted amount is "+ OverDraftedAmt);
				return amount;
			}
		}
		return amount;
	}

	public double withdraw() 
	{
		System.out.println("Enter the amount you want to deposite");
		double amount=sc.nextInt();
		if(this.getBalance()>=amount)
		{
			this.setBalance(this.getBalance()-amount);
			return amount;
		}
		else if((this.getOverDraftLimit()+this.getBalance())>=amount)
		{
			amount=amount-this.getBalance();
			this.setOverDraftedAmt(this.getOverDraftedAmt()+amount);
			this.setBalance(0);
			this.setOverDraftLimit(this.getOverDraftLimit()-amount);
			return amount;
		}
		else
		{
			System.out.println("Your balance is low you cannot withdraw amount ");
			return 0;
		}
		
		
	}


	@Override
	void calculateinterest()
	{
		System.out.println("---Your account is current account there is no  interest Calculation---");
		
	}


	@Override
	void checkbalance() 
	{
		System.out.println("|| %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ||");
		System.out.println("||                                                    ||");
		System.out.println("||             Name :"+ holderName +"                 ||");
		System.out.println("||             Account number:" + accNo +"            ||");
		System.out.println("||             Balance:  "+ balance + "               ||");
		System.out.println("||         Overdraft Limit:"+ OverDraftLimit+"        ||");
		System.out.println("||        Overdrafted Amount"+OverDraftedAmt+"        ||");
		System.out.println("||                                                    ||");
		System.out.println("|| %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  ||");	
		
	}
	
}

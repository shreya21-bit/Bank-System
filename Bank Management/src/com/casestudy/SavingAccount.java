package com.casestudy;
import java.util.Scanner;
public class SavingAccount extends Account
{
	
	static double miniBalance;
	static double rateOfInterest=2.5;
	Scanner sc=new Scanner (System.in);

	public SavingAccount(int accno, String holderName, double balance)
	{
		super(accno,  holderName,  balance);
	}
	public double getMiniBalance() 
	{
		return miniBalance;
	}
	public void setMiniBalance() 
	{
		SavingAccount.miniBalance = 10000;
	}
	
	public double deposite() 
	{
		System.out.println("Enter the amount you want to deposite");
		double amount=sc.nextInt();
		this.setBalance(amount+this.getBalance());
		System.out.println("Amount added sucessfully");
		return amount;
	}
	
	public double withdraw()
	{
		System.out.println("Enter the amount you want to deposite");
		double amount=sc.nextInt();
		//condition
		if(this.getBalance()-amount>=SavingAccount.miniBalance)
		{
			this.setBalance(this.getBalance()-amount);
			System.out.println("Withdraw sucessfully");
			this.checkbalance();
			return amount;
		}
		else
		{
			System.out.println("The amount exceeds your minimum balance");
			System.out.println("you can withdraw"+this.getBalance());
			return 0;
			
		}
		
		
	}
	void calculateinterest()
	{
		System.out.println("Rate of Interest Yearly ");
		double rate=(this.getBalance()*rateOfInterest*1)/100;
		System.out.println("Interest amount: "+(this.getBalance()*rateOfInterest*1)/100);
		System.out.println("For your "+this.getBalance()+" amount you given to the interest for one year is Rs."+rate);
		System.out.println("Total amount :"+(rate+this.balance));
	}
	void checkbalance() 
	{
		System.out.println("|| %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ||");
		System.out.println("||                                                    ||");
		System.out.println("||              Name : "+ holderName+"                || ");
		System.out.println("||              Account number: "+ accNo+"            || ");
		System.out.println("||              Balance:  "+ balance +"               || ");
		System.out.println("||                                                    || ");
		System.out.println("|| %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ||");
		
	}


	
	

}

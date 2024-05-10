package com.casestudy;
import java.util.Scanner;

public class LoanAccount extends Account
{
	
	double loanGiven;
	static double rateOfInterest=2;
	Scanner sc=new Scanner (System.in);
	
	public LoanAccount(int accno, String holderName, double balance) 
	{
		super(accno,  holderName,0 -(balance+(balance/100)*rateOfInterest));
		this.loanGiven=balance;	
	}
	public double getLoanGiven() 
	{
		return loanGiven;
	}
	public void setLoanGiven(double loanGiven) 
	{
		this.loanGiven = loanGiven;
	}
	
	public double deposite() 
	{
		System.out.println("Enter the amount you want to deposite");
		double amount=sc.nextInt();
		if(this.getBalance()+amount<=0)
		{
			this.setBalance(getBalance()+amount);
			System.out.println("your balance is "+this.getBalance());
			if(this.getBalance()==0)
			{
				this.setLoanGiven(0);
			}
			return amount;
		}
		else
		{
			System.out.println("you can deposite only Rs."+(-(this.getBalance())));
			System.out.println(this.getLoanGiven());
			return 0;
		}	
	}
	
	public double withdraw() 
	{
		System.out.println("Enter the amount you want to withdraw");
		double amount=sc.nextInt();
		if(balance==0)
		{
			this.setBalance(-amount);
			this.setLoanGiven(amount);
			System.out.println("the loan given is");
			return amount;
		}
		else
		{
			System.out.println("you alredy have a loan on your account so you cannot withdraw again");
			System.out.println("If you want to withdraw then first clear your loan");
			System.out.println("The loan is Rs."+this.getBalance());
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
		System.out.println("||  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ||");
		System.out.println("||                                                     ||");
		System.out.println("||            Name : "+holderName+"                    ||");
		System.out.println("||            Account number: "+accNo+"                || ");
		System.out.println("||            Balance:  "+balance+"                    ||");
		System.out.println("||  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ||");
	}
	
	
}

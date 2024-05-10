package com.casestudy;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class SalaryAccount extends Account
{
	LocalDate  lastTrasactionDate;
	static int timeLimit=2;
	Scanner sc=new Scanner (System.in);
	static double rateOfInterest=2.5;

	public SalaryAccount(int accno, String holderName, double balance,LocalDate  lastTrasactionDate) 
	{
		super(accno,  holderName,  balance);
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM, yyyy");		
//		this.lastTrasactionDate = LocalDate.parse(date, formatter);	
		this.lastTrasactionDate=lastTrasactionDate;
		
	}

	public LocalDate getLastTrasactionDate()
	{
		return lastTrasactionDate;
	}

	public void setLastTrasactionDate(LocalDate lastTrasactionDate)
	{
		this.lastTrasactionDate = lastTrasactionDate;
	}

	public int getTimeLimit()
	{
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) 
	{
		SalaryAccount.timeLimit = timeLimit;
	}

	
	public double  deposite() 
	{
		System.out.println("Enter the amount you want to deposite");
		double amount=sc.nextInt();
		this.setBalance(amount+this.getBalance());
		System.out.println("Amount added sucessfully");
		return amount;
	}
	public double withdraw()
	{

        if(ChronoUnit.MONTHS.between(LocalDate.now(),this.getLastTrasactionDate())<=timeLimit)
        {
        	System.out.println("Enter the amount you want to withdraw");
    		double amount=sc.nextInt();
        	if(this.getBalance()>=amount)
        	{
        		this.setBalance(this.getBalance()-amount);
        		System.out.println("Amount withdraw sucessfully \n Balance is "+this.getBalance());
        		this.setLastTrasactionDate(LocalDate.now());
        		return amount;
        	}
        	else
        	{
        		System.out.println("Your balance is low");
        		return 0;
        	}
        }
        else
        {
        	System.out.println("Your account is freeze you cannot withdraw amount");
        	return 0;
        }
	}
	void calculateinterest() {
		System.out.println("Rate of Interest Yearly ");
		double rate=(this.getBalance()*rateOfInterest*1)/100;
		System.out.println("Interest amount: "+(this.getBalance()*rateOfInterest*1)/100);
		System.out.println("For your "+this.getBalance()+" amount you given to the interest for one year is Rs."+rate);
		System.out.println("Total amount :"+(rate+this.balance));
	}
	
	void checkbalance() {

		System.out.println("||  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ||");
		System.out.println("||                                                     ||");
		System.out.println("||            Name : "+holderName+"                    ||");
		System.out.println("||            Account number: "+accNo+"                || ");
		System.out.println("||            Balance:  "+balance+"                    ||");
		System.out.println("||  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ||");
		
	}	
}


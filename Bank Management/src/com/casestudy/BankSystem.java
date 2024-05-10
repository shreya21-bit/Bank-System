package com.casestudy;

import java.time.LocalDate;
import java.util.Scanner;

public class BankSystem 
{
	static Account [] allAccInfo = new Account [10];
	static int count=0;
	public static int ct=0;
	static int acctNo=100;
	static Scanner sc=new Scanner (System.in);
	//public static String ct;
	
	public static void main(String args[])
	{
		bankoperations();
	}
	
	static void bankoperations()
	{
		int choice=0;
		while(choice!=4)
		{
			System.out.println("||=======================================================||");
			System.out.println("||                 Bank Administration                   ||");
			System.out.println("||=======================================================||");
			System.out.println("|| 1.              Login as Admin                        ||");
			System.out.println("|| 2.              Login as User                         ||");
			System.out.println("|| 3.              Create Account                        ||");
			System.out.println("|| 4.              Exit!!!!                              ||");
			System.out.println("||                                                       ||");
			System.out.println("||    >>>>>>     *|* Enter your choice *|*    <<<<<<<<   ||");
			System.out.println("||                                                       ||");
			System.out.println("||=======================================================||");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:
				{
					dailyReport();
				}
				break;
				case 2:
				{
					 BankCounter();
				}
				break;
				case 3:
				{
					addAccount();
				}
				break;
				case 4:
				{
					System.out.println("Exiting program");
				}
				break;
			}

			
		}
	}
	static void   BankCounter() 
	{
		
		int choice=0;
		while(choice!=7)
		{   System.out.println("||%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%||");
			System.out.println("||         Bank Counter Operations         ||");
			System.out.println("||=========================================||");
			System.out.println("|| 1.           Deposite                   ||");
			System.out.println("|| 2.           Withdraw                   ||");
			System.out.println("|| 3.           check Balance              ||");
			System.out.println("|| 4.       Interest Calculations          ||");
			System.out.println("|| 5.          close account               ||");
			System.out.println("|| 6.          Exit Window                 ||");
			System.out.println("||-----------------------------------------||");
			System.out.println("||             Enter your choice           ||");
			System.out.println("||                                         ||");
			System.out.println("||%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%||");
			choice =sc.nextInt();
            switch(choice)
            {
	            
	            case 1:
	            {
	            	depositeBalance();
	            }
	            break;
	            case 2:
	            {
	            	withdrawAmount();	            	
	            }
	            break;
	            case 3:
	            {
	            	checkBalance();
	            }
	            break;
	            case 4:
	            {
	            	checkInterest();
	            }
	            break;
	            case 5:
	            {
	            	closeAccount();
	            }
	            
	            break;
	            case 6:
	            {
	            	bankoperations();
	            }
	            break;
			
            }
		}
	}
	static void addAccount() 
	{
		
		int ch =0;
		    System.out.println("||%%%%%%-----Types of Account-----%%%%%%%||");
			System.out.println("||          1.Saving account             ||");
			System.out.println("||          2.Current account            ||");
			System.out.println("||          3.Salary account             ||");
			System.out.println("||          4.Loan account               ||");
			System.out.println("||                                       ||");
			System.out.println("|| %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ||");
			System.out.println("Enter choice which type of account you want to open ");
			ch=sc.nextInt();
			if(ch==1)
			{
						System.out.println("Enter the name of account holder");
						String name=sc.next();
						sc.nextLine();
						System.out.println("Enter the balance you want to deposite ");
						double balance=sc.nextDouble();
						while(balance<10000)
						{
							System.out.println("Minimum limit of balance is 10000 ");
							System.out.println("Enter the balance you want to deposite");
							 balance=sc.nextDouble();
						}
						allAccInfo[count++]=new SavingAccount(++acctNo,name,balance);
						Transaction.details[ct++]=new Transaction(acctNo,"Saving Account created",balance);
						System.out.println("Congratulations your account is created ");
						System.out.println("Welcome to our bank ");
						System.out.println("Your account number is  "+ (acctNo));
			}
			else if(ch==2) 
			{
						System.out.println("Enter the name of account holder");
						String holderName=sc.next();
						sc.nextLine();
						System.out.println("Enter the balance you want to deposite ");
						double balance=sc.nextDouble();
						allAccInfo[count++]=new CurrentAccount(++acctNo,holderName,balance,50000,0);
						Transaction.details[ct++]=new Transaction(acctNo,"Current Account created",balance);
						System.out.println("Congratulations your account is created ");
						System.out.println("Welcome to our bank ");
						System.out.println("Your account number is  "+ (acctNo));
			}
			else if (ch==3)
			{
				System.out.println("Enter the name of account holder");
				String holderName=sc.next();
				sc.nextLine();
				System.out.println("Enter the balance you want to deposite ");
				double balance=sc.nextDouble();
				allAccInfo[count++]=new SalaryAccount(++acctNo,holderName,balance,LocalDate.now());
				Transaction.details[ct++]=new Transaction(acctNo,"Salary Account created",balance);
				System.out.println("Congratulations your account is created ");
				System.out.println("Welcome to our bank ");
				System.out.println("Your account number is  "+ (acctNo));
			}
			else if (ch==4)
			{
				System.out.println("Enter the name of account holder");
				String holderName=sc.next();
				sc.nextLine();
				System.out.println("How much amount you want to take it as a loan: ");
				double balance=sc.nextDouble();
				allAccInfo[count++]=new LoanAccount(++acctNo,holderName,balance);
				Transaction.details[ct++]=new Transaction(acctNo,"Loan Account created",balance);
				System.out.println("Congratulations your account is created ");
				System.out.println("Welcome to our bank ");
				System.out.println("Your account number is  "+ (acctNo));
			} 
	}
	static void depositeBalance()
	{
		System.out.println("Enter the account number ");
		int accountNo=sc.nextInt();
	
		for(int i=0;i<allAccInfo.length;i++)
	    {
	    	if(allAccInfo[i].accNo==accountNo)
	    	{
	    		double amount=allAccInfo[i].deposite();
	    		Transaction.details[ct++]=new Transaction(allAccInfo[i].getAccNo(),"Balance deposited",amount);	    		
	    		return;
	    	}
	    	else
	    	{
	    		System.out.println("Enter valid Account No..!");
	    	}
	    }
	}
	static void withdrawAmount()
	{
		System.out.println("Enter the account number ");
		int accountNo=sc.nextInt();
	    
		for(int i=0;i<allAccInfo.length;i++)
	    {
	    	if(allAccInfo[i].accNo==accountNo)
	    	{
	    		double amount=allAccInfo[i].withdraw();
	    		if(amount==0)
	    		{
		    		Transaction.details[ct++]=new Transaction(allAccInfo[i].getAccNo(),"Withdrawl unsucessfull",amount);

	    		}
	    		else
	    		Transaction.details[ct++]=new Transaction(allAccInfo[i].getAccNo(),"Withdrawl unsucessfull",amount);
	    		return;
	    	}
	    	else
	    	{
	    		System.out.println("Enter valid Account No..!");
	    	}
	    }
	}
	static void checkBalance()
	{
		System.out.println("Enter the account number ");
		int accountNo=sc.nextInt();
		for(int i=0;i<allAccInfo.length;i++)
	    {
	    	if(allAccInfo[i].accNo==accountNo)
	    	{
	    		allAccInfo[i].checkbalance();
	    		return;
	    	}
	    }
	}
	static void checkInterest()
	{
		System.out.println("Enter the account number ");
		int accountNo=sc.nextInt();
		for(int i=0;i<allAccInfo.length;i++)
	    {
	    	if(allAccInfo[i].accNo==accountNo)
	    	{
	    		allAccInfo[i].calculateinterest();
	    		return;
	    	}
	    }
	}
	public static void displaytransactions()
	{
		System.out.println("********************************************* || The Daily Report Of Bank ||  *********************************************");
		System.out.println("    Transaction Number    ||         Account Number      ||         Process Name             ||         Amount        ||");
		System.out.println("|| ================================================================================================================== ||");
		for(int i=0;i<ct;i++)
		{
			System.out.println( "          "+(i+1)+"                            "+Transaction.details[i].accNo+"                      "+Transaction.details[i].processName+"                   "+Transaction.details[i].amount       );
		}
	}
	static void dailyReport()
	{
		String id="1shreya2";
		int pass= 973016;
		System.out.println("Only bank admin can have  access");
		System.out.println("Enter id :");
		String id1;
		id1=sc.next();
		System.out.println("Enter the password: ");
		int password=sc.nextInt();
		
		if(id.equals(id1) && pass == password)
		{
			displaytransactions();
		}
		
		else
		{
			System.out.println("YOU ENTER WRONGE ID AND PASSWARD");
		}
		
	}
	static void closeAccount()
	{
		System.out.println("Enter your account number");
		int acc=sc.nextInt();
	
		for(int i=0;i<count;i++) {
			if(allAccInfo[i].accNo==acc)
			{
				if(allAccInfo[i].balance == 0)
				{
					while(i<count)
					{
						allAccInfo[i]=allAccInfo[i+1];
						i++;
					}
					count--;
					System.out.println("  Account Closed Successfully..!");
					Transaction.details[ct++]=new Transaction(acctNo,"Account Closed",0);
				}
				else if (allAccInfo[i].balance <0)
				{
					System.out.println("You can not delete your account.[It is a loan account] ");
					System.out.println("First your have to pay your loan and then you close your account");
					System.out.println("The amount is "+(-allAccInfo[i].balance ));
					System.out.println("\n1.deposite\n 2.cancel Deletion\n Enter your choice:");
					int choice= sc.nextInt();
					
					if(choice == 1)
					{ 
						System.out.println("Enter "+(-allAccInfo[i].balance)+"amount");
						allAccInfo[i].deposite();
						while(i<count)
						{
							allAccInfo[i]=allAccInfo[i+1];
							i++;
						}
						count--;
						System.out.println("Account Deleted Successfully..!");
						Transaction.details[ct++]=new Transaction(acctNo,"Account Deleted",0);
					}
					else
					{
					System.out.println("your account deletion is cancelled !");
						
					}

				}
				else
				{
					System.out.println("You can't close your account, You have Rs. "+allAccInfo[i].balance+"\n1.Withdraw\n2.cancel Deletion\nEnter your choice:");
					int choice= sc.nextInt();
					if(choice == 1)
					{
						System.out.println("Enter "+allAccInfo[i].balance+"amount");
						allAccInfo[i].withdraw();
						while(i<count)
						{
							allAccInfo[i]=allAccInfo[i+1];
							i++;
						}
						count--;
						System.out.println("Account Deleted Successfully..!");
						Transaction.details[ct++]=new Transaction(acctNo,"Account Deleted",0);
					}
					else
					{
					System.out.println("your account deletion is cancelled!!!!");
						
					}
				}
			}
			else
			{
				System.out.println("Your account not found");
			}
		}
		
	}
	
	
}

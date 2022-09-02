package com.hexa.sbi_atm.serviceImpl;


import com.hexa.sbi_atm.exception.InvalidBalanceWithdraw;
import com.hexa.sbi_atm.exception.OutOfDepositAmountLimit;
import com.hexa.sbi_atm.model.Account;

import com.hexa.sbi_atm.service.AccountService;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountServiceImpl implements AccountService
{
	Scanner s = new Scanner(System.in);
	Account a;

	Account arr[];

	@Override
      public void accountOpen() 
	{
	 System.out.println(" enter array size");
		int size = s.nextInt();
		arr = new Account[size];

		for (int i = 0; i < arr.length; i++) 
		{

			a = new Account();

			// TODO Auto-generated method stub
			System.out.println("Enter your details");
			System.out.println();

			System.out.println("enter first name");
			a.setFirstname(s.next());
		    System.out.println("enter last name");
			a.setLastname(s.next());
			System.out.println("enter city name");
			a.setCityname(s.next());
			System.out.println("enter Area name");
			a.setAreaname(s.next());
			System.out.println("enter pincode name");
			a.setPincode(s.nextInt());
			String regex = "^\\d{8,11}$";
			boolean flag = true;
			while (flag)
			{
			System.out.println("enter Mobile no");
			String mNumber = s.next();
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(mNumber);
			if (matcher.matches())
			{
            a.setMobileno(mNumber);
			flag = false;
			
			} else
				
			{
				
			System.out.println("please enter correct format mobile no");
				
			}
			
		    }

			System.out.println("enter Email Id");
			a.setEmailid(s.next());
			System.out.println("enter balance");
			a.setBalance(s.nextFloat());

			for (double j = a.getBalance(); j <= 500; j++) {
				
			if (a.getBalance() < 500)

			{
			 System.out.println(("enter valid balance"));
			 System.out.println("enter balance");
			 a.setBalance(s.nextFloat());
			}
			}

			System.out.println("enter account type");
			a.setAccountType(s.next());
			System.out.println("Your Account NO.is");
			Random r = new Random();
			int y = r.nextInt(10000);
			a.setAccountNo(y);
			System.out.println(y);
			System.out.println("Account sucessfully created");
			arr[i] = a;
			System.out.println();
		}

	}

	@Override
	     public void balanceCheck() {
		// TODO Auto-generated method stub
		System.out.println("please enter account number");
		int accountno = s.nextInt();
		for (int i = 0; i < arr.length; i++) {
	    if (arr[i].getAccountNo() == accountno) {
		System.out.println(" Your account available balance" + arr[i].getBalance());
	    break;
		}
	    
		}
		System.out.println();

	}

	@Override
	    public void withdraw() throws InvalidBalanceWithdraw {
		System.out.println("please enter account number");
		int accountno = s.nextInt();
		for (int i = 0; i < arr.length; i++)
		{
		if (arr[i].getAccountNo() == accountno)
		{
			// TODO Auto-generated method stub
		System.out.println("Enter the withdrawal amount");
	    double aa = arr[i].getBalance();
		double ab = s.nextFloat();
		if (aa < ab) 
		{
		InvalidBalanceWithdraw e = new InvalidBalanceWithdraw("Out of Balance");
	    System.out.println("Available balance" + aa);
		throw e;

		}
      else
       {
		double ac = aa - ab;
        arr[i].setBalance(ac);
        System.out.println("Available balance" + ac);
		}
		
		}
		
		}

		System.out.println();

	}

	@Override
	    public void deposit() throws OutOfDepositAmountLimit
	   {
		System.out.println("please enter account number");
		int accountno = s.nextInt();
		for (int i = 0; i < arr.length; i++)
		{
		if (arr[i].getAccountNo() == accountno)
		{
        	// TODO Auto-generated method stub
		  System.out.println("Enter the deposit amount");
		  double aa = arr[i].getBalance();
		  double ab = s.nextFloat();
          if (ab >= 1000000) 
          {
        	  
		  OutOfDepositAmountLimit o = new OutOfDepositAmountLimit("Amount is Out Of Deposite Limit");
		  throw o;
		  }
				
          double ac = aa + ab;
		  arr[i].setBalance(ac);
		  System.out.println(" Your Available balance" + ac);
		  }
		}
		  System.out.println();
	}

	@Override
	    public void accountshow()
	    {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++)
		{
            System.out.println("Account Details");
			System.out.println("First name :- " + arr[i].getFirstname());
			System.out.println("Last name :- " + arr[i].getLastname());
			System.out.println("City name :- " + arr[i].getCityname());
			System.out.println("Area name :- " + arr[i].getAreaname());
			System.out.println("Pincode :- " + arr[i].getPincode());
			System.out.println("Mobile No :- " + arr[i].getMobileno());
			System.out.println("Email id :- " + arr[i].getEmailid());
			System.out.println("Available balance :- " + arr[i].getBalance());
			System.out.println("AccounType :- " + arr[i].getAccountType());
			System.out.println();
		}
	}

}

package com.Bankdetails;

import java.io.Serializable;
import java.util.Random;

public abstract class Account implements Serializable 
{
	private long accountNo;
	private String accountHolderName;
	private int accBalance;
	
	Random r = new Random();
	
	public Account() {}
	
	public Account(String accountHloderName,int accBalance)
	{
		this.accountNo=r.nextLong(123456789123l);
		this.accountHolderName=accountHloderName;
		this.accBalance=accBalance;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(int accBalance) {
		this.accBalance = accBalance;
	}

	public long getAccountNo() {
		return accountNo;
	}
	public abstract void deposite(int amount);
	public abstract void withdraw(int amount);
	public abstract int showBalance();
	public abstract int caluculateIntrest();
	
	public void display()
	{
		System.out.println("AccountNo : " + getAccountNo());
		System.out.println("AccountHolder Name : " + getAccountHolderName());
		System.out.println("Account Balance : " + getAccBalance());
		System.out.println("Intrest :  " + caluculateIntrest());
		System.out.println("---------------------------------------------");
	}

}

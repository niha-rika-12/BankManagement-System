package com.Bankdetails;

import java.util.Random;

public class CurrentAccount extends Account {
	private long accountNo;
	Random r = new Random();

	public CurrentAccount() {
		
	}
	public  CurrentAccount(String accountHolderName,int accBalance)
	{
		super(accountHolderName, accBalance);
		this.accountNo = r.nextLong(123456789123l);
	}
	@Override
	public void deposite(int amount) {
		if(amount>0)
		{
			int accbalance=getAccBalance();
			accbalance = accbalance + amount;
			setAccBalance(accbalance);
			System.out.println("Rupees /-" + accbalance + "deposited Succesfully");
		}
		else
		{
			throw new InvalidAmountException();
		}
		
	}
	@Override
	public void withdraw(int amount) {
		if(amount<=getAccBalance())
		{
			int accbalance = getAccBalance();
			accbalance = accbalance-amount;
			setAccBalance(accbalance);
			System.out.println( "Rupees /- " + accbalance +"Withdraw Succesfully");
		}
		else
		{
			throw new InSufficientAmountException();
		}
		
	}
	@Override
	public int showBalance() {
		// TODO Auto-generated method stub
		return getAccBalance();
	}
	@Override
	public int caluculateIntrest() {
		// TODO Auto-generated method stub
		return getAccBalance()*4;
	}

	public void displayCurrentAccountDetails()
	{
		System.out.println("AccountNo : " + getAccountNo());
		System.out.println("AccountHolder Name : " + getAccountHolderName());
		System.out.println("Account Balance : " + getAccBalance());
		System.out.println("Intrest :  " + caluculateIntrest());
		System.out.println("---------------------------------------------");
	}
public CurrentAccount getAccountDetails()
{
	return new CurrentAccount();
}

}

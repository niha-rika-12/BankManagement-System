package com.myCustomer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import com.Bankdetails.CurrentAccount;
import com.Bankdetails.SavingAccount;

public class Customer implements Serializable
{
private String name;
private int cId;

public Customer()
{
	
}

public Customer(String name, int cId) {
	this.name = name;
	this.cId = cId;
}

private ArrayList<CurrentAccount> ca = new ArrayList<CurrentAccount>();
private ArrayList<SavingAccount> sa = new ArrayList<SavingAccount>();
     public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getcId() {
	return cId;
}

	private Scanner sc = new Scanner(System.in);
	
    public void createAccount()
    {
    	System.out.println(getName() + "Welcome,,, Let start creatig Your Account..");
    	boolean start=true;
    	while(true)
    	{
    		System.out.println("Select Account Type : \n 1.CurrentAccount \n 2. SaviingsAccount  \n 3.Exit \n ");
    		int ch = sc.nextInt();
    		switch(ch) {
    	case 1: {
			System.out.println("Enter The AccountHolderName");
			String name = sc.next();
			System.out.println("Enter The Inital_Account_Balance");
			int accbalance = sc.nextInt();
			CurrentAccount caa = new CurrentAccount(name, accbalance);
			ca.add(caa);
			System.out.println("Hey :" + caa.getAccountHolderName()
					+ "Your CurrentAccount is Created Successfully With AccountNO:|| " + caa.getAccountNo());
		}
			break;
		case 2: {
			System.out.println("Enter The Account_Holder_Name");
			String name = sc.next();
			System.out.println("Enter The Inital_Account_Balance");
			int accbalance = sc.nextInt();
			SavingAccount sac = new SavingAccount(name, accbalance);
			sa.add(sac);
			System.out.println("Hey :" + sac.getAccountHolderName()
					+ "Your SavingsAccount is Created Successfully With AccountNO:|| " + sac.getAccountNo());
		}
			break;
		case 3: {
			start = false;
			System.out.println("Thank You.... :)");
		}
			break;
		default:
			System.out.println("Enter Valid Choice....");
		}
	}
}

public void depositTOAccount(int cid, long accountNo, int amount) {
	if (this.cId != cid) {
		System.out.println("No Customer Found With This ID.....");
		return;
	}

	for (CurrentAccount cac : ca) {
		if (cac.getAccountNo() == accountNo) {
			cac.deposite(amount);
			return;
		}
	}

	for (SavingAccount sac : sa) {
		if (sac.getAccountNo() == accountNo) {
			sac.deposite(amount);
			return;
		}
	}
	System.out.println("No Accounts Found...Please Check Your Account NO......");
}

public void withDrawFromAccount(int cid, long accountNo, int amount) {
	if (this.cId != cid) {
		System.out.println("No Customer_Found With This ID.....");
		return;
	}

	for (CurrentAccount cac : ca) {
		if (cac.getAccountNo() == accountNo) {
			cac.withdraw(amount);
			return;
		}
	}
	for (SavingAccount sac : sa) {
		if (sac.getAccountNo() == accountNo) {
			sac.withdraw(amount);
			return;
		}
	}

	System.out.println("No Account Found....Please Check Your AccountNo....");
}

public void showAccountBalances() {
	System.out.println("------------Balances For Customer:--------------");
    System.out.println(getName()+": Your Accounts Balance Are :");
	for (CurrentAccount cac : ca) {
		System.out.println("Current Account NO:"+cac.getAccountNo()+" || Balance: "+cac.getAccBalance());
	}
	
	for (SavingAccount sac : sa) {
		System.out.println("Saving Account No:"+sac.getAccountNo()+" || Balance: "+sac.getAccBalance());
	}

	System.out.println("---------------------------------------------");
}

public void showCustomerDetails(int cid) {
		boolean isFound=false;
	    // System.out.println("Name of The Customer:"+getName());
	    System.out.println("==============================================");
		System.out.println("Id Of The Customer:" + getcId());
	    if(ca.isEmpty() && sa.isEmpty())
	    {
	    	System.out.println("No Accounts Created Yet...");
	    }
	    else
	    {
	    	System.out.println("-----Current_Account_Details------");
	    	for (CurrentAccount cac : ca) {
				cac.displayCurrentAccountDetails();
				isFound=true;
				break;
			}
            
	    	System.out.println("----Saving_Account_Details------");
			for (SavingAccount sac : sa) {
				sac.displaySavingAccountDetails();
				isFound=true;
				break;
			}

	    }
	    if(isFound==false)
	    {
	    	System.out.println("No Account Found...");
	    }
	}
	


}

package com.Bankdetails;

public class InSufficientAmountException extends RuntimeException
{
@Override
public String toString()
{
	return getClass()+ "Invalid Withdraw Ammount";
}
}

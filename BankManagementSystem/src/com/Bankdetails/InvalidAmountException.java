package com.Bankdetails;

public class InvalidAmountException extends RuntimeException 
{
@Override
public String toString()
{
	return getClass()+ "Invalid Ammount";
}
}

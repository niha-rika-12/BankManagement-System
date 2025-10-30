package com.Bankdetails;

	import java.util.Scanner;

	import com.myCustomer.Customer;

	public class BankMainclass {

		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
			Bank b = new Bank();
			boolean isstart = true;
			while (isstart) {
				System.out.println(
						"Enter The Choice: \n 1.AddCustomer \n 2.Create Account \n 3.DepositeToAccount \n 4.WithDrawFromAccount \n 5.ShowBalance \n 6.ShowCustomer \n 7.RemoveCustomer \n 8.Exit");
				int ch = sc.nextInt();
				switch (ch) {
				case 1: {
					System.out.println("Enter The CustomerName");
					String name = sc.next();
					System.out.println("Enter The CustomerID");
					int id = sc.nextInt();
					Customer c = new Customer(name, id);
					b.addCustomer(c);
				}
					break;
				case 2: {
					System.out.println("Enter The CustomerID");
					int cid = sc.nextInt();
					Customer c = b.getCustomerByID(cid);
					c.createAccount();
				}
					break;
				case 3: {
					System.out.println("Enter The Customer_ID");
					int cid = sc.nextInt();
					Customer c = b.getCustomerByID(cid);
					if (c != null) {
						System.out.println("Enter The AccountNo");
						long accountNo = sc.nextLong();
						System.out.println("Enter The Deposit Amount");
						int amount = sc.nextInt();
						c.depositTOAccount(cid, accountNo, amount);
					}
				}
					break;
				case 4: {
					System.out.println("Enter The Customer_ID");
					int cid = sc.nextInt();
					Customer c = b.getCustomerByID(cid);
					if (c != null) {
						System.out.println("Enter The AccountNo");
						long accountNo = sc.nextLong();
						System.out.println("Enter The WithDrawn Amount");
						int amount = sc.nextInt();
						c.withDrawFromAccount(cid, accountNo, amount);
						
					}
				}
					break;
				case 5: {
					System.out.println("Enter The CustomerId");
					int cid = sc.nextInt();
					Customer c = b.getCustomerByID(cid);
					c.showAccountBalances();
				}
					break;
				case 6: {
					System.out.println("Enter The CustomerId");
					int cid = sc.nextInt();
					Customer c = b.getCustomerByID(cid);
					if(c!=null)
					{
						c.showCustomerDetails(cid);
					}

				}
					break;
				case 7: {
					System.out.println("Enter The CustomerId");
					int cid = sc.nextInt();
					b.removeCustomerByID(cid);
				}
					break;
				case 8: {
					isstart = false;
					System.out.println("Thank You....:");
				}
					break;
				default:
					System.out.println("Enter valid Choice....");
				}
			}
		}
	}
package com.Bankdetails;
	import java.io.Serializable;
	import java.util.ArrayList;
	import java.util.Iterator;

	import com.myCustomer.Customer;

	public class Bank implements Serializable {
		private String bankeName;

		private ArrayList<Customer> customer = new ArrayList<Customer>();

		// AddCustomer
		public void addCustomer(Customer c) {
			customer.add(c);
			System.out.println(c.getName() + " Addedd Successfully.. With ID:" + c.getcId());

		}

		public Customer getCustomerByID(int id) {
			if (customer.isEmpty()) {
				System.out.println("No Customer Addedd Yet...");
			} else {
				for (Customer c : customer) {
					if (c.getcId() == id) {
						return c;
					}
				}
			}
			return null;
		}

		public void showCustomers(int cid) {
			if (customer.isEmpty())
				System.out.println("No Customer Are Addedd...");
			else {
				for (Customer c : customer) {
					Customer customer = getCustomerByID(cid);
					if (customer.getcId() == cid) {
						customer.showCustomerDetails(cid);
					}
				}
			}
		}

		public void removeCustomerByID(int cid) {
			boolean isremoved = false;
			if (customer.isEmpty())
				System.out.println("No Customer are Addedd....");
			else {
				Iterator<Customer> itr = customer.iterator();
				while (itr.hasNext()) {
					Customer c = itr.next();
					if (c.getcId() == cid) {
						itr.remove();
						System.out.println(c.getName() + " is Removed Successfully....");
						isremoved = true;
						break;
					}
				}
				if (isremoved != true)
					System.out.println("Invalid CustomerID...");
			}
		}

	}

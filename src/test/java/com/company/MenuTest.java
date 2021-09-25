package com.company;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.company.Customers;
import com.company.Menu;

public class MenuTest {

     Customers []customer = new Customers[50];
     Menu M = new Menu();
    
	@Before
	public void initialize()
	{
		for(int i=0;i< 50;i++)
		{
			customer[i] = new Customers();
		}
		//Some of the Attribute of the Customer is Initialized
		customer[0].name = "Ahmed";
		customer[0].Account.Account_number = 34201;
		customer[0].Account.Account_Type = "Current Account";
		customer[0].Account.balance = 0;
		customer[0].Account.Date = "23/2/2021";
	}
    
	@Test
	public void testOperationsDone() {
		Customers obj = Customers.TakeAccountInput(customer);
		assertTrue(M.operations(obj, customer));
	}
	
	@Test
	public void testOperationsFailed() {
		Customers obj = Customers.TakeAccountInput(customer);
		assertFalse(M.operations(obj, customer));
	}
	
	

}

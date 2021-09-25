package com.company;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.company.Customers;

public class TestCustomers {
	
	Customers []customer = new Customers[50];
    
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
	public void testAccountFound_CheckBalance() {
		assertTrue(customer[0].CheckBalance());
	}
	
	
	@Test 
	public void testAccountNotFound_CheckBalance()
	{
    	assertFalse(customer[1].CheckBalance());
	}
	
	@Test
	public void testAccountFound_checkIndexAccountADD()
	{
		Customers obj = Customers.checkIndexAccountADD(customer);
		assertEquals(0,obj.Account.Account_number);
	}
     
	@Test
	public void testAccountNotFound_checkIndexAccountADD()
	{
		Customers obj = Customers.checkIndexAccountADD(customer);
		assertEquals(0,obj.Account.Account_number);
	}
	
	@Test
	public void testAccountFound_checkIndexAccountDelete()
	{
		Customers obj = Customers.checkIndexAccountDelete(customer,34201);
		assertEquals(34201,obj.Account.Account_number);
	}
	
	@Test
	public void testAccountNotFound_checkIndexAccountDelete()
	{
		Customers obj = Customers.checkIndexAccountDelete(customer,0);
		assertEquals(0,obj.Account.Account_number);
	}
	
	@Test 
	public void testEligible_AccountOpen()
	{
		assertTrue(customer[1].newAccount());
	}
	
	@Test 
	public void testNotEligible_AccountOpen()
	{
		assertFalse(customer[1].newAccount());
	}
	
	@Test 
	public void testAccountFound_AccountDelete()
	{
		assertTrue(customer[0].DeleteAccount());
	}
	
	@Test 
	public void testAccountNotFound_AccountDelete()
	{
		assertFalse(customer[1].DeleteAccount());
	}
	@Test
	public void testAccountFound_SearchAccount()
	{
		Customers obj = Customers.searchAccount(34201, customer);
		assertEquals(34201,obj.Account.Account_number);
	}
	
	@Test
	public void testAccountNotFound_SearchAccount()
	{
		assertEquals(null,Customers.searchAccount(3420, customer));
	}
	
	@Test
	public void testmakeDeposit()
	{
		assertEquals(customer[0].makeDeposit(), customer[0].Account.balance);
	}
	@Test
	public void testmakeWithdrawl()
	{
		customer[0].Account.balance = 900;
		assertEquals(customer[0].makeWithDrawl(), customer[0].Account.balance);
	}
	@Test 
	public void testRemoveBalanceSuccess()
	{
		customer[0].Account.balance = 900;
		assertTrue(customer[0].removeBalance(500));
	}
	
	@Test 
	public void testRemoveBalanceFailed()
	{
		customer[0].Account.balance = 400;
		assertFalse(customer[0].removeBalance(500));
	}
	@Test 
	public void testAddBalanceSuccess()
	{
		assertTrue(customer[0].AddBalance(500));
	}
	
	@Test 
	public void testAddBalanceFailed()
	{
		assertFalse(customer[1].AddBalance(500));
	}
	@Test
	public void testmakeTransactionsuccess()
	{
		customer[0].Account.balance = 1000;
		customer[1].newAccount();
		assertTrue(customer[0].makeTransaction(customer));
	}
	
	@Test
	public void testmakeTransactionFailed()
	{
		customer[0].Account.balance = 1000;
		assertFalse(customer[0].makeTransaction(customer));
	}
	@Test 
	public void testZakatdeductionSuccess()
	{
		customer[0].Account.balance = 40000;
		customer[0].Account.Account_Type = "Saving Account";
		assertTrue(customer[0].CalculateZakat());
	}
	@Test
	public void testzakatdedutionFailed()
	{
		assertFalse(customer[0].CalculateZakat());
	}
}

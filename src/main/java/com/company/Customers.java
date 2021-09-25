package com.company;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Customers
{
    String name;
    String Address;
    String Phone_Number;
    int SA_count, CA_count;
    Bank_Account Account;
    Customers()    //Default Constructor
    {
        name = null;
        Address = null;
        Phone_Number = null;
        SA_count = CA_count = 0;
        Account =  new Bank_Account();
    }
    Boolean newAccount()
    {
    	Scanner sc = new Scanner(System.in);
    	int age;
    	System.out.println("What's Your age: ");
    	age =  sc.nextInt();
    	if(age >= 18 )
    	{
    		System.out.println("Now, You are opening your New Account: ");
            System.out.println("First of All, tell us Which Account do you want to open, " + "1. Saving Account " + "2. Checking Account");
            this.Account.Account_Type = sc.nextLine();
            System.out.println("Enter your Account Information");
            System.out.println("Enter your Name");
            this.name = sc.nextLine();
            System.out.println("Enter your Phone Number");
            this.Phone_Number = sc.nextLine();
            System.out.println("Enter your Address");
            this.Address = sc.nextLine();
            System.out.println("Enter your Account Number");
            this.Account.Account_number = sc.nextInt();
            System.out.println("Enter your Account Balance");
            this.Account.balance = sc.nextInt();

            sc.nextLine();   //Skip Escape Character
            System.out.println("Enter Today's Date");
            this.Account.Date = sc.nextLine();
            sc.nextLine();   //Skip Escape Character
            return true;
    	}
    	
    	else
    	{
    		System.out.println("Sorry, You are not eligible for account openening because of under Age ");
    		return false;
    	}
    }
    static Customers checkIndexAccountADD(Customers []customer)
    {
        for(int i=0;i<50;i++)
        {
            if(customer[i].Account.Account_number == 0 )
            {
                return customer[i];
            }
        }
        return null;
    }

    static Customers checkIndexAccountDelete(Customers []customer, int Account_number)
    {
        for(int i=0;i<50;i++)
        {
            if(customer[i].Account.Account_number ==  Account_number)
            {
                return customer[i];
            }
        }
        return null;
    }
    Boolean DeleteAccount()
    {
    	if(this.Account.Account_number !=0 )
    	{
    		 System.out.println(this.name  + " your Account is Successfully deleted ");
    	        this.name = null;
    	        this.Address = null;
    	        this.Phone_Number = null;
    	        this.Account.Account_number = 0;
    	        this.Account.Account_Type = null;
    	        this.CA_count = this.SA_count =0;
    	        this.Account.Date = null;
    	        this.Account.balance = 0;
    	        return true;
    	}
    	else
    	{
    		System.out.println("Sorry, You don't have any account ");
    		return false;
    	}

    }

    static Customers searchAccount(int Account_No,Customers []customer)
    {
        for(int i=0;i<50;i++)
        {
            if(customer[i].Account.Account_number == Account_No)
            {
                return customer[i];
            }

        }
        System.out.println("Sorry, Required Account is not in our record yet");
        return null;
    }

    void Details()
    {
        System.out.println("Check Details");
        System.out.println("Name: ");
        System.out.println("           " + this.name);
        System.out.println("Phone_No: ");
        System.out.println("           " + this.Phone_Number);
        System.out.println("Address: ");
        System.out.println("           " + this.Address);
        System.out.println("Account_type: ");
        System.out.println("           " + this.Account.Account_Type);
        System.out.println("Account_number: ");
        System.out.println("           " + this.Account.Account_number);
        System.out.println("Balance: ");
        System.out.println("           " + this.Account.balance);
        System.out.println("Date of Account Creation: ");
        System.out.println("           " + this.Account.Date);
    }

    int makeDeposit()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("How much money you want to Deposit in your Account ");
        int balance = sc.nextInt();
        this.Account.balance += balance;
        System.out.println("Congratulations, " + this.name + " You done your Deposit Successfully");
        if(this.Account.Account_Type.toLowerCase().equals("checking account"))
        {
            this.Account.transaction_fee+=10;
            this.Account.balance-=10;
            System.out.println("Additional 10RS transaction fee is deducted from your balance ");
            System.out.println("Now, Your current Balance is " + this.Account.balance);
        }
        
        return balance;
    }

    int makeWithDrawl()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("How much money you want to withdraw from your Account ");
        int balance = sc.nextInt();
        this.Account.balance -= balance;
        System.out.println("Congratulations, " + this.name + " You  withdraw Money Successfully");
        if(this.Account.Account_Type.toLowerCase().equals("checking account"))
        {
            this.Account.transaction_fee+=10;
            this.Account.balance-=10;
            System.out.println("Additional 10RS transaction fee is deducted from your balance ");
            System.out.println("Now, Your current Balance is " + this.Account.balance);
        }
        return this.Account.balance;
    }


    Boolean CheckBalance()
    {
    	if(this.name != null)
    	{
    		System.out.println("Name is: " + this.name);
            System.out.println("Your current Balance in the account is: " + this.Account.balance);
            return true;
    	}
    	else
    	{
    		System.out.println("Required Account is not opened yet: ");
    		return false;
    	}
    }
    void printStatement(Customers customer,int Amount)
    {
        System.out.println("Details of the Sender: ");
        System.out.println("Name is: " + customer.name);
        System.out.println("Time and Date of Transaction:   ");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        System.out.println("Transaction Amount: " + Amount);
        System.out.println("Remaining Balance: " + customer.Account.balance);
    }

    Boolean removeBalance(int Amount)
    {
    	if(this.Account.balance > Amount)
    	{
    		 this.Account.balance -= Amount;
    	        return true;
    	}
    	else
    	{
    		System.out.println("Sorry, you don't have enough money for withdrawl ");
    		return false;
    	}
    }

    Boolean AddBalance(int Amount)
    {
    	if(this.Account.Account_number != 0 )
    	{
    		 this.Account.balance += Amount;
    	    	return true;
    	}
    	else
    	{
    		System.out.println("Sorry, You don't have any Account in this Bank ");
    		return false;
    	}
    }

    boolean makeTransaction(Customers []customer)
    {
        Scanner sc = new Scanner(System.in);
        Customers temp = new Customers();
        temp = Customers.TakeAccountInput(customer);
        if(temp != null)
        {
        	 Customers temp2 = new Customers();//For backup for printing Statement of the Sender
             if(temp != null)
                 temp2 = temp;
             System.out.println("Enter amount you want to sent: ");
             int Amount = sc.nextInt();
             if (temp != null)
                 temp.removeBalance(Amount);
             System.out.println("Other person: ");
             temp = Customers.TakeAccountInput(customer);
             if(temp != null)
             {
            	 temp.AddBalance(Amount);
             }
             else
            	 return false;
             System.out.println("Your transaction done Successfully ");
             System.out.println("Do you want to print Statement of your transaction? y/n");
             char c = sc.next().charAt(0);
             if( c == 'Y' || c == 'y')
                 printStatement(temp2,Amount);
             return true;
        }
        else
        	return false;
    }

    static Customers TakeAccountInput(Customers []customer)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account Number");
        int Account_no = sc.nextInt();
        return Customers.searchAccount(Account_no,customer);
    }

    Boolean CalculateZakat()
    {
        String Account_type = this.Account.Account_Type;
        System.out.println("String " + Account_type.toLowerCase());
        if( Account_type.toLowerCase().equals("saving account") )
        {
            System.out.println("good");
            if( this.Account.balance >= 20000 )
            {
                System.out.println("Calculating Zakaat... " );
                double Zakaat = (this.Account.balance*2.5)/100;
                System.out.println("Zakat is " + Zakaat);
            }
            else
            {
            	 System.out.println("Your current Balance is below Zakat threshold..");
                 return false;
            }
              return true; 
        }
        else
        {
        	System.out.println("For Zakat your Account should be Saving..");
            return false;
        }
    }

    void DisplayAllDeduction(Customers temp)
    {
        System.out.println("Transaction Fee deducted is:  " + temp.Account.transaction_fee);
    }

}
package com.company;

import java.util.Scanner;

public class Menu
{
    Boolean operations(Customers temp,Customers []customer)
    {
        if(temp != null)
        {
        	System.out.println("1. makeDeposit");
            System.out.println("2. makeWithdrawal");
            System.out.println("3. check Balance");
            System.out.println("4. transfer Amount");
            System.out.println("5. calculate Zakaat");
            System.out.println("6. DisplayAllDeductions");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
        	 switch(choice)
             {
                 case 1:
                     temp.makeDeposit();
                     break;
                 case 2:
                     temp.makeWithDrawl();
                     break;
                 case 3:
                     temp.CheckBalance();
                     break;
                 case 4:
                     temp.makeTransaction(customer);
                     break;
                 case 5:
                     temp.CalculateZakat();
                     break;
                 case 6:
                     temp.DisplayAllDeduction(temp);
                 default:
                     System.out.println("Invalid operation, Can't Do that ");
             }
        	 return true;
         }
        else
        	return false;
       
    }
    void Menu_Display()
    {
        Scanner sc =  new Scanner(System.in);
        System.out.println("1. Open a new Account ");
        System.out.println("2. Close an Account ");
        System.out.println("3. Login to a specific Account by providing the unique account number");
        System.out.println("4. Perform Account operations ");
        System.out.println("5. Display all account details, including the bank owner details ");
        System.out.println("6. Display all account deductions along with account details ");
    }
}


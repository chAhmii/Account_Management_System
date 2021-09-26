package com.company;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Interface {
    public static void main(String[] args) {
	// write your code here
        Scanner sc =  new Scanner(System.in);
        Customers []customer = new Customers[50];
        for(int i=0;i<50;i++)
        {
            customer[i] = new Customers();
        }
      
        //Displaying Menu
        while(true)
        {
            System.out.println("Menu ");
            Menu Display = new Menu();
            Display.Menu_Display();

            Customers temp = new Customers();
            switch (sc.nextInt())
            {
                case 1:
                    temp = Customers.checkIndexAccountADD(customer);
                    temp.newAccount();
                    break;
                case 2:
                    System.out.println("Enter your Account Number");
                    int Account_number =  sc.nextInt();
                    temp = Customers.checkIndexAccountDelete(customer,Account_number);
                    temp.DeleteAccount();
                    break;
                case 3:
                    temp = Customers.TakeAccountInput(customer);
                    if(temp != null)
                    temp.Details();
                    break;
                case 4:    //Performing Operations
                    temp = Customers.TakeAccountInput(customer);
                    if(temp != null)
                    Display.operations(temp,customer);
                    break;
                case 5:   //Display all Accounts details
                    for(int i=0;customer[i].Account.Account_number != 0;i++)
                    {
                        customer[i].Details();
                    }
                    break;
                case 6:   //Display All Accounts details with their deductions
                    for(int i=0;customer[i].Account.Account_number != 0 ;i++)
                    {
                        customer[i].Details();
                        System.out.println("For checking Deduction, ");
                        temp = Customers.TakeAccountInput(customer);
                        System.out.println("Deduction of this Account are below.. ");
                        if(temp != null)
                        customer[i].DisplayAllDeduction(temp);
                    }
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}
package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class DataBase {
	
	
	String concatData(Customers arr)
	{ 
		
		String concat = "Name:" + arr.name + " Address: " + arr.Address + " Phone Number: "
		+ arr.Phone_Number + " Account Number: " + arr.Account.Account_number + " Account Type: " + arr.Account.Account_Type + 
		" Current Balance: " + arr.Account.balance + " Account Date Creation: " + arr.Account.Date + "\n";
		return concat;
	}
	void FileWriting(Customers arr)
	{
			try {
				 BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\Ch Ahmed\\TestFile.txt",true));
				out.write(concatData(arr));
				out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}

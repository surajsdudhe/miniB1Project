package com.project_mini_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PaymentProcedure {
	public  void myPaymentProcedure() {
		System.out.println("Welcome payment procedure");
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Product ID from cart info table  for Payment ");
		String productID = sc.nextLine();
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerceB1project","root","root");
			//Statement stmt = conn.createStatement();
			 PreparedStatement ps = conn.prepareStatement("SELECT productid,category,brand,price as priceInINR,productdiscription FROM productdetails where productid = ?");
			ps.setString(1, productID);
			 ResultSet rs = ps.executeQuery();
			 // for table entry allignment
			String leftAlignFormat = "| %-3s |  %-12s|  %-11s|  %-11s|  %-100s |%n";	
			
			
			
			System.out.format("+-----+--------------+-------------+-------------+------------------------------------------------------------------------------+%n");
			System.out.format("|ID   |Category      | Brand       | Price inINR | Product Description                        |%n");
			System.out.format("+-----+--------------+-------------+-------------+------------------------------------------------------------------------------+%n");
			
			
			String i4="0" ; // for price
			while(rs.next()) {
				String i1 =rs.getString(1);
				String i2 =rs.getString(2);
				String i3 =rs.getString(3);
				 i4 =rs.getString(4);
				String i5 =rs.getString(5);
				//System.out.println(i1+" "+i2+" "+i3+" "+i4+" "+i5);
				System.out.format(leftAlignFormat ,i1,i2,i3,i4,i5);
				System.out.format("+-----+--------------+-------------+-------------+------------------------------------------------------------------------------+%n");
				
			}
			
			
			System.out.println("Proceed for paymrnt with amount :-"+ i4);
			System.out.println("Enter Debit Card Number ");
			String dCard = sc.nextLine();
			System.out.println("Enter  Debit Card Expiry Date ");
			String dCardExp= sc.nextLine();
			System.out.println("Enter  Debit Card CSV code ");
			String dCardCSV= sc.nextLine();
			System.out.println("Payment Successfull");
			
			CheckLogin objLog = new CheckLogin();
			String emailuser =objLog.getUserName();//get email for updating order information
			
			
			//update order information table
			ps = conn.prepareStatement("INSERT into orderinformation(email, productid) value (?,?)");
			ps.setString(1, emailuser);
			ps.setString(2, productID);
			ps.executeUpdate();
			//delete cart information 
			ps = conn.prepareStatement("DELETE FROM cartinformation WHERE productid=?");
			ps.setString(1, productID);
			ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
	}

}

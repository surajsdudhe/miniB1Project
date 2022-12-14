package com.project_mini_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class OrderInfo {
	
	public void myOrderInfo() {
		
		CheckLogin objLog = new CheckLogin();
		objLog.checkMyLogin();
		String emailuser =objLog.getUserName();
		
		
		System.out.println("your Order  info as follows");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerceB1project","root","root");
			//Statement stmt = conn.createStatement();
			//ResultSet rs = stmt.executeQuery("SELECT productid,category,brand,price as priceInINR,productdiscription FROM productdetails");
			
			PreparedStatement ps = conn.prepareStatement("SELECT t.* FROM productdetails AS t    INNER JOIN orderinformation AS tr ON t.productid= tr.productid WHERE email= ?");
			ps.setString(1, emailuser);
			//ResultSet rs = stmt.executeQuery("SELECT t.* FROM productdetails AS t    INNER JOIN cartinformation AS tr ON t.productid= tr.productid WHERE email= ?");
			ResultSet rs = ps.executeQuery();
			 // for table entry allignment
			String leftAlignFormat = "| %-3s |  %-12s|  %-11s|  %-11s|  %-100s |%n";	
			
			
			
			System.out.format("+-----+--------------+-------------+-------------+------------------------------------------------------------------------------+%n");
			System.out.format("|ID   |Category      | Brand       | Price inINR | Product Description                        |%n");
			System.out.format("+-----+--------------+-------------+-------------+------------------------------------------------------------------------------+%n");
			
			while(rs.next()) {


				String i1 =rs.getString(1);
				String i2 =rs.getString(2);
				String i3 =rs.getString(3);
				String i4 =rs.getString(4);
				String i5 =rs.getString(5);
				//System.out.println(i1+" "+i2+" "+i3+" "+i4+" "+i5);
				
				System.out.format(leftAlignFormat ,i1,i2,i3,i4,i5);
				
				System.out.format("+-----+--------------+-------------+-------------+------------------------------------------------------------------------------+%n");
				
				
				
			}
			
			System.out.println("Enter 1 for home page ");
			int x =0;
			Scanner sc = new Scanner(System.in);
			while(x==0) {
				x=sc.nextInt();
			}
			Navigation objNev = new Navigation();
					objNev.navigateMe();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}

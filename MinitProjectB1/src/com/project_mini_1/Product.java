package com.project_mini_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Product {

	public void productDetails() {
		System.out.println("Our products are as follows ");
				try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerceB1project","root","root");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT productid,category,brand,price as priceInINR,productdiscription FROM productdetails");
			
			
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
				  
				//System.out.format(leftAlignFormat,"i","i","i","i","i");
				//System.out.print(rs.getString(1) + rs.getString(2)+ rs.getString(3)+ rs.getString(4)+rs.getString(5));
				//System.out.println();
				//System.out.print(rs.getString(1)+" ");
				//System.out.print(rs.getString(2)+" ");
				//System.out.print(rs.getString(3)+" ");
				//System.out.print(rs.getString(4)+" ");
				//System.out.println(rs.getString(5)+" ");
				System.out.format("+-----+--------------+-------------+-------------+------------------------------------------------------------------------------+%n");
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

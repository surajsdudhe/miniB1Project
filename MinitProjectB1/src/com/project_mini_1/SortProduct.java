package com.project_mini_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public class SortProduct {
	public void sortMyProduct() {
		try {
			HashMap<Integer,String> hm = new HashMap<Integer,String>();//store category key-wise
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerceB1project","root","root");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT category FROM productdetails GROUP BY category");
			String leftAlignFormat = "| %-13s |  %-11s| %n";	
			
			
			
			System.out.format("+---------------+-------------+%n");
			System.out.format("|Category       |Selection No.|%n");
			System.out.format("+---------------+-------------+%n");
			
			int x = 0;
			while(rs.next()) {
				
				x =x+1;
				String i1 =rs.getString(1);
				hm.put(x, i1); // hashmap key int value category
				System.out.format(leftAlignFormat,i1,x);
				System.out.format("+---------------+-------------+%n");
			}
			
			
			PreparedStatement ps = conn.prepareStatement("SELECT productid,brand,price,productdiscription FROM productdetails WHERE category = ?");
			System.out.println("Enter Category Selection Number");
			Scanner sc = new Scanner(System.in);
			int j = sc.nextInt();
			
			//String j = sc.nextLine();
			//ps.setString(1, j);
			//ps.setString(1, sc.nextLine());
			String getCat = hm.get(j);
			ps.setString(1, getCat);
			ResultSet resultProduct = ps.executeQuery();
		
			
			leftAlignFormat = "| %-4s |  %-11s| %-12s| %-100s| %n";	
			
			
			
			System.out.format("+------+-------------+-------------+------------------------------------------------------+%n");
			System.out.format("|ID    |Brand        |Price in INR |Description                                           |%n");
			System.out.format("+------+-------------+-------------+------------------------------------------------------+%n");
			
			while(resultProduct.next()) {
				System.out.format(leftAlignFormat, resultProduct.getString(1),resultProduct.getString(2),resultProduct.getString(3),resultProduct.getString(4),"|");
				System.out.format("+------+-------------+-------------+------------------------------------------------------+%n");	
			}
			
			
			System.out.println("Enter 1 for product selection or  2 for home");
			int y = sc.nextInt();
			if(y==1 ) {
				System.out.println("Select Product ID for adding to Cart");
				AddtoCart objCart = new AddtoCart();
				objCart.addCartM();
			}else {
				Navigation objnev = new Navigation();
				objnev.navigateMe();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

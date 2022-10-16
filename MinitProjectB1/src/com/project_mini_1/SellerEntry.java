package com.project_mini_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SellerEntry {
	
	public void newProduct() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerceB1project","root","root");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO  productdetails  (category,brand,price,productdiscription) "
					+ "VALUE (?,?,?,?);");
			Scanner sc = new Scanner(System.in);
			System.out.println("Product Details entry Started for Seller only ");
			
			System.out.println("Enter Product category(Watch,Shoes,Mobile,Laptop,Earphone) ");
			ps.setString(1, sc.nextLine());	
			System.out.println("Enter Product brand");
			ps.setString(2, sc.nextLine());	
			System.out.println("Enter Product price in INR");
			ps.setString(3, sc.nextLine());	
			System.out.println("Enter product discription");
			ps.setString(4, sc.nextLine());	
			sc.close();
			
			ps.executeUpdate();
			System.out.println("Product Entry Done");
			
//			ResultSet st = stmt.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

package com.project_mini_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Registration {
	
	public void newRegistration() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerceB1project","root","root");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO  userinfo  (name,surname,mobile,email,username,password,address) "
					+ "VALUE (?,?,?,?,?,?,?);");
			Scanner sc = new Scanner(System.in);
			System.out.println("Registration process is stsrted ");
			
			System.out.println("Enter Name");
			ps.setString(1, sc.nextLine());	
			System.out.println("Enter SUrname");
			ps.setString(2, sc.nextLine());	
			System.out.println("Enter Mobile Number");
			ps.setString(3, sc.nextLine());	
			System.out.println("Enter unique Email");
			ps.setString(4, sc.nextLine());	
			System.out.println("Enter surename");
			ps.setString(5, sc.nextLine());	
			System.out.println("Enter Password");
			ps.setString(6, sc.nextLine());	
			System.out.println("Enter Address");
			ps.setString(7, sc.nextLine());	
			
			ps.executeUpdate();
			
			
//			ResultSet st = stmt.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

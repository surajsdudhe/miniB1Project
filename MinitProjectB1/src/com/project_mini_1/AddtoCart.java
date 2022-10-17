package com.project_mini_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddtoCart {
	
	public void addCartM() {
		try {
			System.out.println("Cart insertion in process");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerceB1project","root","root");
			PreparedStatement ps_cart = conn.prepareStatement("INSERT INTO  cartinformation  (email, productid)  VALUE (?,?)");
			
			ps_cart.setString(1, "surajsdudhe@gmail.com");
			System.out.println("Enter Selection Number");
			Scanner sc = new Scanner(System.in);
			String id_product = sc.nextLine();
			ps_cart.setString(2,id_product );	
			ps_cart.executeUpdate();
			System.out.println("Updated cart entry");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

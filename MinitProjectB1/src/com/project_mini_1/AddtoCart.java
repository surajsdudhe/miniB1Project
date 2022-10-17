package com.project_mini_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddtoCart {
	
	public void addCartM() {
		try {
			
			CheckLogin ObjCheckLogin = new CheckLogin();
			ObjCheckLogin.checkMyLogin();
			
			System.out.println("Cart insertion in process");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerceB1project","root","root");
			PreparedStatement ps_cart = conn.prepareStatement("INSERT INTO  cartinformation  (email, productid)  VALUE (?,?)");
			String objEmail = ObjCheckLogin.getUserName();
			ps_cart.setString(1, objEmail);
			
			int x = 1 ; // conter for multiple cart selection
			while(x==1) {
			System.out.println("Enter Selection Number");
			Scanner sc = new Scanner(System.in);
			
			String id_product = sc.nextLine();
			ps_cart.setString(2,id_product);
			ps_cart.executeUpdate();
			System.out.println("cart entry Updated ");
			System.out.println("Do you want to add more Aitom, press 1  otherwise press 2");
			x = sc.nextInt();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

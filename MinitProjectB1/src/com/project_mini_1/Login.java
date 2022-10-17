package com.project_mini_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// it will check login servirse..
public class Login {

	public void LoginMe() {
	

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerceB1project","root","root");
			PreparedStatement ps = conn.prepareStatement("SELECT email,password FROM userinfo WHERE email = ?");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter email");
			String email = sc.nextLine();
			System.out.println("Enter Password");
			String pass= sc.nextLine();
			ps.setString(1, email );
			
			ResultSet resultPass = ps.executeQuery();
			resultPass.next();
			String i1 =resultPass.getString(2);
			
			System.out.println("Entered_Pass: "+pass);
			System.out.println("db_Pass: "+i1);
			//System.out.println( resultPass.getString(2));
			
			//System.out.println("Comapre password"+pass.equals((String)resultPass.getString(1)));
			
			if(pass.equals(resultPass.getString(2)) ) {
				System.out.println("Login Successfull");
				CheckLogin ObjCheckLogin = new CheckLogin();
				ObjCheckLogin.setUserName(email);
				ObjCheckLogin.setUserPass(i1);
			}else{
				System.out.println("Wrong Credential");
			}
	  
	    // Do something with the Connection

	  
		} catch (SQLException | ClassNotFoundException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
		//	System.out.println("SQLState: " + ex.getSQLState());
		//	System.out.println("VendorError: " + ex.getErrorCode());
		}
	
 }
}

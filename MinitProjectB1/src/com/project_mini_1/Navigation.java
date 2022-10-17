package com.project_mini_1;

import java.util.Scanner;

public class Navigation {
	public void navigateMe() {
	String leftAlignFormat = "| %-12s|  %-11s|%n";	
	System.out.format("+----------+---------+%n");
	System.out.format("|Custmer(1)|Seller(2)|%n");
	System.out.format("+----------+---------+%n");
	

	System.out.println("Enter number(1 or 2) in the console for further action");
	Scanner sc = new Scanner(System.in);
	int select = sc.nextInt();
	
	if(select == 1) {
		
		//check login
				CheckLogin ObjCheckLogin = new CheckLogin();
				String objEmail = ObjCheckLogin.getUserName();
				if(objEmail==null) {
					System.out.println("login for Beter Experience");
					
				}else {
					System.out.println("Welcome:-"+objEmail);
				}
				
				//table view
	leftAlignFormat = "| %-12s|  %-11s|  %-11s|  %-10s|  %-10s|  %-10s |%n";	
	System.out.println("Enter number in the console for further action");
	System.out.format("+---------+------------+-------------------+-------------+-------------+-----------------+%n");
	System.out.format("|Log in(1)|Log out(2)  |New Registration(3)|Your  Cart(4)|Tour Order(5)|Filter Product(6)|%n");
	System.out.format("+---------+------------+-------------------+-------------+-------------+-----------------+%n");
	//fetching product details from product table
	Product objProduct = new Product();
	objProduct.productDetails();
	System.out.println("Enter number in the console for further action");
	System.out.format("+---------+------------+-------------------+-------------+-------------+-----------------+%n");
	System.out.format("|Log in(1)|Log out(2)  |New Registration(3)|Your  Cart(4)|Tour Order(5)|Filter Product(6)|%n");
	System.out.format("+---------+------------+-------------------+-------------+-------------+-----------------+%n");
	int selectAction = sc.nextInt();
	if(selectAction==1) {
		
		
		ObjCheckLogin.checkMyLogin();
		String email =ObjCheckLogin.getUserName();
		if (email ==null) {
		Login objLogin = new Login();
		objLogin.LoginMe();
		}else {System.out.println("You are already logIn:-"+ email);}
		
	}else if(selectAction==2) {
		Logout objLogout = new Logout();
	}else if(selectAction==3) {
		Registration objReg = new Registration();
		
		objReg.newRegistration();
		
	}else if(selectAction==4) {
		CartInfo objCart = new CartInfo();
	}else if(selectAction==5) {
		OrderInfo objOrder = new OrderInfo();
	}else if(selectAction==6) {
		SortProduct objSort=new SortProduct();
				objSort.sortMyProduct();
	}else {
		System.out.println("Enter Valid Selection");		
	}
	
	}else {
	int x = 1;
	while(x==1) {
	SellerEntry objSeller = new SellerEntry(); // for product entry
	objSeller.newProduct();
	System.out.println("Do you want to add other product datails, enter 1 otherwise enter 0");
	 x = sc.nextInt();
	}
	System.out.println("Close application if done or Restart Application for further use");
	//Registration obj = new Registration(); // for new user registration 
			//obj.newRegistration();
			
	}
	
  
    
 }
	


}

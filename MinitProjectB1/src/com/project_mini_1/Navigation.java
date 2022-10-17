package com.project_mini_1;

import java.util.Scanner;

public class Navigation {
	public void navigateMe() {
	String leftAlignFormat ;
	
	Scanner sc = new Scanner(System.in);

	
	
		
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
				System.out.format("|Log in(1)|Log out(2)  |New Registration(3)|Your  Cart(4)|Your Order(5)|Filter Product(6)|%n");
				System.out.format("+---------+------------+-------------------+-------------+-------------+-----------------+%n");
				//fetching product details from product table
				Product objProduct = new Product();
				objProduct.productDetails();
				System.out.println("Enter number in the console for further action");
				System.out.format("+---------+------------+-------------------+-------------+-------------+-----------------+%n");
				System.out.format("|Log in(1)|Log out(2)  |New Registration(3)|Your  Cart(4)|Your Order(5)|Filter Product(6)|%n");
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
					objLogout.logOutMe();
				}else if(selectAction==3) {
					Registration objReg = new Registration();
		
					objReg.newRegistration();
		
				}else if(selectAction==4) {
		
				ObjCheckLogin.checkMyLogin();
				String email =ObjCheckLogin.getUserName();
				if (email ==null) {
				Login objLogin = new Login();
				objLogin.LoginMe();
				}else {
					YourCart objCart = new YourCart();
					objCart.yourCartInfo(email); //
		
				}
		
		
				
			}else if(selectAction==5) {
				OrderInfo objOrder = new OrderInfo();
				objOrder.myOrderInfo();
			}else if(selectAction==6) {
				SortProduct objSort=new SortProduct();
						objSort.sortMyProduct();
			}else {
				System.out.println("Enter Valid Selection");		
			}
			
	
	
  
    
 }
	


}

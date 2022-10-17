package com.project_mini_1;

import java.io.IOException;
import java.util.Scanner;

// this class is for showing main e-comarse info

public class Home {
// https://github.com/surajsdudhe/miniB1Project.git
	
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to B1Ecommerce");
		System.out.println("SSG pvt ltd Pune");
		System.out.println("");
		
		String leftAlignFormat = "| %-12s|  %-11s|%n";	
		System.out.format("+----------+---------+%n");
		System.out.format("|Custmer(1)|Seller(2)|%n");
		System.out.format("+----------+---------+%n");
		

		System.out.println("Enter number(1 or 2) in the console for further action");
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		////////////////////////
		if(select == 1) {
			Navigation objNavigate = new Navigation();
			objNavigate.navigateMe();
      ///////////////////////////////////////////////// 
		}else{
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
       
       
       
       Home objMain = new Home();
      objMain.mainCaller(); /// calling main method again
	}
	
	void mainCaller()
    {
		
        // Calling the main() method
        Home.main(null);
    }

	
}

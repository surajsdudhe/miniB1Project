package com.project_mini_1;

import java.io.IOException;
import java.util.Scanner;

// this class is for showing main e-comarse info

public class Home {
// https://github.com/surajsdudhe/miniB1Project.git
	
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to B1Ecommerce");
		System.out.println("SSG pvt ltd Mumbai");
		System.out.println("");
		
       Navigation objNavigate = new Navigation();
       objNavigate.navigateMe();
       
       Home objMain = new Home();
      objMain.mainCaller(); /// calling main method again
	}
	
	void mainCaller()
    {
		
        // Calling the main() method
        Home.main(null);
    }

	
}

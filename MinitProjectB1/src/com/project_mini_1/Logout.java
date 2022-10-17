package com.project_mini_1;

public class Logout {
	public void logOutMe() {
		CheckLogin objLogout = new CheckLogin();
		objLogout.setUserName(null);
		objLogout.setUserPass(null);
		System.out.println("Logout Successfully..");
		System.out.println("Thank you");
		System.out.println("Visit Again");
		}
}

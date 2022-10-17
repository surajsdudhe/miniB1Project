package com.project_mini_1;

public class CheckLogin {
	private static String userName;
	private static String userPass;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	
	public void checkMyLogin() {
		if(getUserPass()==null && getUserName()==null) {
			System.out.println("Your are not login yet");
			Login objLogin = new Login();
			objLogin.LoginMe();
			
		}

	}

}

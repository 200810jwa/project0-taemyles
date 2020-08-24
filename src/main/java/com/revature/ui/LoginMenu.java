package com.revature.ui;

import com.revature.models.User;
import com.revature.services.UserService;

public class LoginMenu {
	static String username = null;
	static String password = null;
	static UserService us = new UserService();
	static User user = new User();
	
	public static void loginMenu() {
		System.out.println("**************************");
		System.out.println("*\tLogin Menu\t *");
		System.out.println("**************************");
		System.out.println("To access your account, please enter your username and password below.");
		System.out.print("Username: ");
		username = MainMenu.scanner.nextLine();
		System.out.print("Password: ");
		password = MainMenu.scanner.nextLine();
		user = us.login(username, password);
		if (user != null) {
			if (user.getRole().name() == "Customer") {
				CustomerMenu.customerMenu(user);
			}
			if (user.getRole().name() == "Employee") {
				EmployeeMenu.employeeMenu(user);
			}
		}
	}
}

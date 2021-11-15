package com.java.logic.command;

import java.util.List;

import com.java.model.entity.User;

public class LoginLogic {
	private final static String ADMIN_LOGIN = "admin";
	private final static String ADMIN_PASS = "";

//	public static boolean checkLogin(String enterLogin, String enterPass, List<User> dbUsers) {
	public static User checkLogin(String enterLogin, String enterPass, List<User> dbUsers) {
		User currentUser = null;
		for (User user : dbUsers) {
			if (user.getEmail().equals(enterLogin) && user.getPassword().equals(enterPass)) {
				currentUser = user;
				break;
			}
		}
		return currentUser;
		// return ADMIN_LOGIN.equals(enterLogin) && ADMIN_PASS.equals(enterPass);
	}
}

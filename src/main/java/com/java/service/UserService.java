package com.java.service;

import com.java.model.UserManager;
import com.java.model.entity.User;

public class UserService {
	public static boolean isExistByEmail(String email) {
		User user = UserManager.getInstance().FindUserByEmail(email);
		if (user.getEmail() != null) {
			return true;
		}
		return false;
	}
}

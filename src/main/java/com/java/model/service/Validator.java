package com.java.model.service;

import java.util.regex.Pattern;

import com.java.model.constant.RoleConstant;

public class Validator {

	public static boolean isValidEmailAddress(String email) {
		if (email == null) {
			return false;
		}

		String regexPattern = "^(?=.{1,32}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
				+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		return Pattern.compile(regexPattern).matcher(email).matches();
	}

	public static boolean isValidName(String name) {
		if (name == null) {
			return false;
		}
		String regexPattern = "^[A-Za-z]\\w{5,64}$";
		return Pattern.compile(regexPattern).matcher(name).matches();
	}

	public static boolean isValidRoleID(String paramId) {
		if (paramId == null) {
			return false;
		}

		long id = 0;
		try {
			id = Long.parseLong(paramId);
		} catch (NumberFormatException e) {
			return false;
		}
		return ((id > 0) && (id <= RoleConstant.ROLE_BLOCED_ID));
	}

}

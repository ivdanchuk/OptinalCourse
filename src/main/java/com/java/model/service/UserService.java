package com.java.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.command.course.ReadCourses;
import com.java.model.constant.RoleConstant;
import com.java.model.dao.manager.UserManager;
import com.java.model.entity.User;

public class UserService {
	private final static Logger log = LogManager.getLogger(ReadCourses.class);

//	public static boolean isPassValid(String pass, User user) {

	public boolean isPassValid(String pass, User user) {
		if (user.getPassword().equals(pass)) {
			return true;
		}
		return false;
	}

//	public static boolean isEmptyUser(User user) {
	public boolean isEmptyUser(User user) {
		if ((user.getEmail() == null) || (user.getPassword() == null)) {
			return true;
		}
		return false;
	}

//	public static boolean isExistUser(String email) {
	public boolean isExistUser(String email) {
		User user = UserManager.getInstance().FindUserByEmail(email);
		if (!isEmptyUser(user)) {
			return true;
		}
		return false;
	}

//	public static User getValidUser(String email, String pass, StringBuilder message) {
	public User getValidUser(String email, String pass, StringBuilder message) {
		User user = UserManager.getInstance().FindUserByEmail(email);
		if (isEmptyUser(user)) {
			message.append("There is no such login");
			return null;
		}

		String hashPass = PasswordService.hash(pass);
		if (!isPassValid(hashPass, user)) {
			message.append("Password is not correct");
			return null;
		}

		if (user.getRole_id() == RoleConstant.ROLE_BLOCED_ID) {
			message.append("Account is blocked");
			return null;
		}
		return user;
	}
//	public void setCurrentUser(User user, HttpServletRequest request) {
//		// SessionService.setCurrentUser(request, user);
//		request.getSession().setAttribute("currentUser", user);
//		request.getSession().setAttribute("currentRole", user.getRole_id());
//	}
}

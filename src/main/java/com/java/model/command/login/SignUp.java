package com.java.model.command.login;

import javax.servlet.http.HttpServletRequest;

import com.java.model.command.IActionCommand;
import com.java.model.config.MessageManager;
import com.java.model.constant.Path;
import com.java.model.constant.RoleId;
import com.java.model.dao.manager.UserManager;
import com.java.model.entity.User;
import com.java.model.service.PasswordService;
import com.java.model.service.Validator;

public class SignUp implements IActionCommand {
	private static final String PARAM_NAME_EMAIL = "email";
	private static final String PARAM_NAME_PASSWORD = "password";
	private static final String PARAM_NAME_F_NAME = "f_name";
	private static final String PARAM_NAME_L_NAME = "l_name";

	@Override
	public String execute(HttpServletRequest request) {
		String page = Path.PAGE__LOGIN;
		String email = request.getParameter(PARAM_NAME_EMAIL);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		String fname = request.getParameter(PARAM_NAME_F_NAME);
		String lname = request.getParameter(PARAM_NAME_L_NAME);

		if (!Validator.isValidEmailAddress(email)) {
			request.getSession().setAttribute("errorLoginPassMessage",
					MessageManager.getProperty("message.email.not.valid"));
			return page;
		}

		User user = UserManager.getInstance().findUserByEmail(email);
		if (user.getEmail() != null) {
			request.getSession().setAttribute("errorLoginPassMessage",
					MessageManager.getProperty("message.login.already.exist"));
			return page;
		} else {
			String hashPass = PasswordService.hash(pass);
			user = new User(-1l, fname, lname, email, hashPass, RoleId.ROLE_STUDENT_ID);
			UserManager.getInstance().CreateUser(user);
			request.getSession().setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.signup.ok"));
			page = Path.PAGE__LOGIN;
		}
		return page;
	}
}

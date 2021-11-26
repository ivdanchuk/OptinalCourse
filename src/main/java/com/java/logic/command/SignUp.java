package com.java.logic.command;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;

import com.java.constant.Path;
import com.java.model.UserManager;
import com.java.model.entity.User;

public class SignUp implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) {
		String page = Path.PAGE__LOGIN;
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);

		if (!isValidEmailAddress(login)) {
			request.getSession().setAttribute("errorLoginPassMessage",
					MessageManager.getProperty("message.email.not.valid"));
			return page;
		}

		User user = UserManager.getInstance().FindUserByEmail(login);
		if (user.getEmail() != null) {
			request.getSession().setAttribute("errorLoginPassMessage",
					MessageManager.getProperty("message.login.already.exist"));
			return page;
		} else {
			page = Path.PAGE__NEW_USER;
		}
		return page;
	}

	public static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}
}

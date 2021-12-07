package com.java.model.command.login;

import javax.servlet.http.HttpServletRequest;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.entity.User;
import com.java.model.service.SessionService;
import com.java.model.service.UserService;
import com.java.model.service.Validator;

public class LoginCommand implements IActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) {
		return executeWithUserService(request, new UserService());
	}

	public String executeWithUserService(HttpServletRequest request, UserService userService) {
		String page = Path.PAGE__LOGIN;
		String email = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		StringBuilder message = new StringBuilder();

		if (!Validator.isValidEmailAddress(email)) {
			page = Path.PAGE__ERROR_PAGE;
			message.append("Email is not valid!");
			request.getSession().setAttribute("errorMessage", message.toString());
			return page;
		}

		User user = userService.getAuthorizedUser(email, pass, message);

		if (user != null) {
			SessionService.setCurrentUser(request, user);
			SessionService.setTutors(request);
			SessionService.setCourses(request);
			SessionService.setTopics(request);
			SessionService.setRolesForCurrentUser(request, user);

			request.getSession().setAttribute("defaultLocale", "en");
			page = Path.PAGE__MAIN;
		} else {
			request.getSession().setAttribute("errorLoginPassMessage", message.toString());
//			request.getSession().setAttribute("errorLoginPassMessage",
//					MessageManager.getProperty("message.loginnotexist"));
		}
		return page;
	}
}

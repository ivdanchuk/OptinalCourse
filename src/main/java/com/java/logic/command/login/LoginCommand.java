package com.java.logic.command;

import javax.servlet.http.HttpServletRequest;

import com.java.constant.Path;
import com.java.model.entity.User;
import com.java.service.SessionService;
import com.java.service.UserService;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
//	String message = "Wrong login or password";

	@Override
	public String execute(HttpServletRequest request) {
		StringBuilder message = new StringBuilder();
		String page = Path.PAGE__LOGIN;
		String email = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		User user = UserService.getValidUser(email, pass, message);
		if (user != null) {
			UserService.setCurrentUser(user, request);
			SessionService.setTutors(request);
			SessionService.setCourses(request);
			SessionService.setNotStartedCourses(request);
			SessionService.setTopics(request);
			SessionService.setTopics(request);
			SessionService.setRolesForCurrentUser(request, user);

			request.getSession().setAttribute("defaultLocale", "en");
			page = Path.PAGE__MAIN;
		} else {
			page = Path.PAGE__ERROR_PAGE;
			request.getSession().setAttribute("errorMessage", message.toString());
			// request.getSession().setAttribute("errorLoginPassMessage",
			// MessageManager.getProperty("message.loginnotexist"));
		}
		return page;
	}
}

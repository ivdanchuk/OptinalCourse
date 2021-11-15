package com.java.logic.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.java.controller.Path;
import com.java.model.RoleManager;
import com.java.model.UserManager;
import com.java.model.entity.Role;
import com.java.model.entity.User;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);

		List<User> dbUsers = new ArrayList<>();
		dbUsers = UserManager.getInstance().listAllUsers();
		Role currentRole = null;

		User currentUser = LoginLogic.checkLogin(login, pass, dbUsers);
		if (currentUser != null) {
			currentRole = RoleManager.getInstance().FindRoleById(currentUser.getRole_id());
			request.getSession().setAttribute("currentUser", currentUser);
			request.getSession().setAttribute("currentRole", currentRole);
			// page = ConfigurationManager.getProperty("....");
			page = Path.PAGE__MAIN;
		} else {
			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
			page = Path.PAGE__LOGIN;
			// page = ConfigurationManager.getProperty("....");
		}
		return page;
	}
}

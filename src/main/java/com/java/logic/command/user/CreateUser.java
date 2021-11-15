package com.java.logic.command.user;

import javax.servlet.http.HttpServletRequest;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.UserManager;
import com.java.model.entity.User;

public class CreateUser implements ActionCommand {
	private static final String PARAM_NAME_ID = "id";
	private static final String PARAM_NAME_F_NAME = "f_name";
	private static final String PARAM_NAME_L_NAME = "l_name";
	private static final String PARAM_NAME_EMAIl = "email";
	private static final String PARAM_NAME_PASSWORD = "password";
	private static final String PARAM_NAME_ROLE_ID = "role_id";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String fname = request.getParameter(PARAM_NAME_F_NAME);
		String lname = request.getParameter(PARAM_NAME_L_NAME);
		String email = request.getParameter(PARAM_NAME_EMAIl);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		String roleId = request.getParameter(PARAM_NAME_ROLE_ID);
		User user = new User(-1l, fname, lname, email, pass, 2);
		UserManager.getInstance().CreateUser(user);
		page = Path.COMMAND__READ_USERS;

//		if (LoginLogic.checkLogin(login, pass)) {
//			request.setAttribute("user", login);
//			page = ConfigurationManager.getProperty("path.page.main");
//		} else {
//			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
//			page = ConfigurationManager.getProperty("path.page.login");
//		}
		return page;
	}
}

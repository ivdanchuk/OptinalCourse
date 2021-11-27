package com.java.logic.command.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.config.MessageManager;
import com.java.constant.Path;
import com.java.controller.WebController;
import com.java.logic.command.ActionCommand;
import com.java.model.UserManager;
import com.java.model.entity.User;
import com.java.service.SessionService;

public class CreateUser implements ActionCommand {
	private static final String PARAM_NAME_ID = "id";
	private static final String PARAM_NAME_F_NAME = "f_name";
	private static final String PARAM_NAME_L_NAME = "l_name";
	private static final String PARAM_NAME_EMAIl = "email";
	private static final String PARAM_NAME_PASSWORD = "password";
	private static final String PARAM_NAME_ROLE_ID = "role_id";
	private static final Logger Log = LogManager.getLogger(WebController.class);

	@Override
	public String execute(HttpServletRequest request) {
		String page = Path.PAGE__ERROR_PAGE;
		String fname = request.getParameter(PARAM_NAME_F_NAME);
		String lname = request.getParameter(PARAM_NAME_L_NAME);
		String email = request.getParameter(PARAM_NAME_EMAIl);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		String roleId = request.getParameter(PARAM_NAME_ROLE_ID);

		User user = UserManager.getInstance().FindUserByEmail(email);
		if (user.getEmail() != null) {
			String message = "CreateUser#execute " + "User with email " + email + " already exists";
			Log.error(message);
			request.getSession().setAttribute("errorMessage", "User with email " + email + " already exist");
			return page;
		}

		if (roleId != null) {
			user = new User(-1l, fname, lname, email, pass, Long.parseLong(roleId));
			UserManager.getInstance().CreateUser(user);
			SessionService.setTutors(request);
			page = Path.COMMAND__READ_USERS2;
		} else {
			Log.error("CreateUser#execute" + "Can't create user, see logs for details.");
			request.getSession().setAttribute("errorMessage",
					MessageManager.getProperty("Can't create user, see logs for details."));
		}
		return page;
	}
}

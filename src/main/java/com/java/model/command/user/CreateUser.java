package com.java.model.command.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.command.IActionCommand;
import com.java.model.config.MessageManager;
import com.java.model.constant.Path;
import com.java.model.dao.manager.UserManager;
import com.java.model.entity.User;
import com.java.model.service.PasswordService;
import com.java.model.service.SessionService;
import com.java.model.service.Validator;

public class CreateUser implements IActionCommand {
	private static final Logger Log = LogManager.getLogger(CreateUser.class);

	private static final String PARAM_NAME_ID = "id";
	private static final String PARAM_NAME_F_NAME = "f_name";
	private static final String PARAM_NAME_L_NAME = "l_name";
	private static final String PARAM_NAME_EMAIl = "email";
	private static final String PARAM_NAME_PASSWORD = "password";
	private static final String PARAM_NAME_ROLE_ID = "role_id";

	@Override
	public String execute(HttpServletRequest request) {
		String page = Path.PAGE__ERROR_PAGE;

		String fname = request.getParameter(PARAM_NAME_F_NAME);
		String lname = request.getParameter(PARAM_NAME_L_NAME);
		String email = request.getParameter(PARAM_NAME_EMAIl);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		String roleId = request.getParameter(PARAM_NAME_ROLE_ID);

		String message = null;
		if (!Validator.isValidEmailAddress(email)) {
			request.getSession().setAttribute("errorMessage", "Email is not valid!");
			Log.error(message);
			return page;
		}
		if ((!Validator.isValidName(fname)) || (!Validator.isValidName(lname))) {
			request.getSession().setAttribute("errorMessage", "First or Last name is not valid!");
			return page;
		}

		if (!Validator.isValidRoleID(roleId)) {
			request.getSession().setAttribute("errorMessage", "Role id is not valid!");
			return page;
		}

		User user = UserManager.getInstance().FindUserByEmail(email);
		if (user.getEmail() != null) {
			message = "CreateUser#execute " + "User with email " + email + " already exists";
			Log.error(message);
			request.getSession().setAttribute("errorMessage", "User with email " + email + " already exist");
			return page;
		}

		if (roleId != null) {
			String hashPass = PasswordService.hash(pass);
			user = new User(-1l, fname, lname, email, hashPass, Long.parseLong(roleId));
			UserManager.getInstance().CreateUser(user);

			SessionService.setTutors(request);

			page = Path.COMMAND__READ_USERS;
		} else {
			Log.error("CreateUser#execute" + "Can't create user, see logs for details.");
			request.getSession().setAttribute("errorMessage",
					MessageManager.getProperty("Can't create user, see logs for details."));
		}
		return page;
	}
}

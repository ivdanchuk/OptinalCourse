package com.java.logic.command.user;

import javax.servlet.http.HttpServletRequest;

import com.java.config.MessageManager;
import com.java.constant.Path;
import com.java.constant.RoleConstant;
import com.java.logic.command.ActionCommand;
import com.java.model.UserManager;
import com.java.model.entity.User;

public class UpdateUser implements ActionCommand {
	private static final String PARAM_NAME_ID = "userId";
	private static final String PARAM_NAME_F_NAME = "f_name";
	private static final String PARAM_NAME_L_NAME = "l_name";
	private static final String PARAM_NAME_EMAIl = "email";
	private static final String PARAM_NAME_PASSWORD = "password";
	private static final String PARAM_NAME_ROLE_ID = "role_id";

	@Override
	public String execute(HttpServletRequest request) {
		String page = Path.PAGE__ERROR_PAGE;
		Long id = Long.parseLong(request.getParameter(PARAM_NAME_ID));
		String fname = request.getParameter(PARAM_NAME_F_NAME);
		String lname = request.getParameter(PARAM_NAME_L_NAME);
		String email = request.getParameter(PARAM_NAME_EMAIl);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		int roleId = Integer.parseInt(request.getParameter(PARAM_NAME_ROLE_ID));

		User user = new User(id, fname, lname, email, pass, roleId);
		if (UserManager.getInstance().UpdateUser(user)) {
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			if (currentUser.getRole_id() == RoleConstant.ROLE_ADMIN_ID) {
				page = Path.COMMAND__READ_USERS2;
			} else {
				page = Path.PAGE__MAIN;
			}
		} else {
			request.getSession().setAttribute("errorMessage",
					MessageManager.getProperty("message.login.already.exist"));
		}
		return page;
	}
}

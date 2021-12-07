package com.java.model.command.user;

import javax.servlet.http.HttpServletRequest;

import com.java.model.command.IActionCommand;
import com.java.model.config.MessageManager;
import com.java.model.constant.Path;
import com.java.model.constant.RoleId;
import com.java.model.dao.manager.UserManager;
import com.java.model.entity.User;
import com.java.model.service.PasswordService;

public class UpdateUser implements IActionCommand {
	private static final String PARAM_NAME_ID = "userId";
	private static final String PARAM_NAME_F_NAME = "f_name";
	private static final String PARAM_NAME_L_NAME = "l_name";
	private static final String PARAM_NAME_EMAIl = "email";
	private static final String PARAM_NAME_PASSWORD = "password";
	private static final String PARAM_NAME_ROLE_ID = "role_id";
	private static final String PARAM_NAME_CHANGE_PASS = "changePass";

	@Override
	public String execute(HttpServletRequest request) {
		String page = Path.PAGE__ERROR_PAGE;

		Long id = Long.parseLong(request.getParameter(PARAM_NAME_ID));
		String fname = request.getParameter(PARAM_NAME_F_NAME);
		String lname = request.getParameter(PARAM_NAME_L_NAME);
		String email = request.getParameter(PARAM_NAME_EMAIl);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		String changePass = request.getParameter(PARAM_NAME_CHANGE_PASS);
		int roleId = Integer.parseInt(request.getParameter(PARAM_NAME_ROLE_ID));
		String hashPass = pass;
		if (changePass != null) {
			hashPass = PasswordService.hash(pass);
		}
		User user = new User(id, fname, lname, email, hashPass, roleId);
		if (UserManager.getInstance().UpdateUser(user)) {
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			if (currentUser.getRole_id() == RoleId.ROLE_ADMIN_ID) {
				page = Path.COMMAND__READ_USERS;
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

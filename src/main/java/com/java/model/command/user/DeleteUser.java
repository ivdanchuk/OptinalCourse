package com.java.model.command.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.dao.manager.UserManager;

public class DeleteUser implements IActionCommand {
	private static final String PARAM_NAME_ID = "id";
	private final static Logger log = LogManager.getLogger(UserManager.class);

	@Override
	public String execute(HttpServletRequest request) {
		String path = Path.PAGE__ERROR_PAGE;
		Long id = Long.parseLong(request.getParameter(PARAM_NAME_ID));

		if (UserManager.getInstance().DeleteUser(id)) {
			path = Path.COMMAND__READ_USERS;
		} else {
			request.getSession().setAttribute("errorMessage", "Can't delete user, see details in log");
		}
		return path;
	}
}

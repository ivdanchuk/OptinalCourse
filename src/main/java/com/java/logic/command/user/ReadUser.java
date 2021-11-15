package com.java.logic.command.user;

import javax.servlet.http.HttpServletRequest;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.logic.command.CommandEnum;
import com.java.model.UserManager;

public class ReadUser implements ActionCommand {
	private static final String PARAM_NAME_ID = "userId";

	@Override
	public String execute(HttpServletRequest request) {
		String userId = request.getParameter(PARAM_NAME_ID);
		request.setAttribute("command", CommandEnum.UPDATE_USER);
		request.setAttribute("user", UserManager.getInstance().FindUserById(Long.parseLong(userId)));
		return Path.PAGE__USER;
	}
}

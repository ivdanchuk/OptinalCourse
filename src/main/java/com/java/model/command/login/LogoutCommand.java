package com.java.model.command.login;

import javax.servlet.http.HttpServletRequest;

import com.java.model.command.IActionCommand;
import com.java.model.config.ConfigurationManager;

public class LogoutCommand implements IActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.index");
		request.getSession().invalidate();
		return page;
	}
}

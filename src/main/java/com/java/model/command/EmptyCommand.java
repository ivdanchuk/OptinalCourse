package com.java.model.command;

import javax.servlet.http.HttpServletRequest;

import com.java.model.config.ConfigurationManager;

public class EmptyCommand implements IActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		/*
		 * в случае ошибки или прямого обращения к контроллеру переадресация на страницу
		 * ввода логина
		 */
		String page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}
}

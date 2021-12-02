package com.java.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import com.java.model.constant.Path;

public class I18NCommand implements IActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String fmtLocale = "javax.servlet.jsp.jstl.fmt.locale";
		String defaultLocale = "defaultLocale";
		HttpSession session = request.getSession();

		String langParam = request.getParameter("langParam");

		if (langParam.equals("ru")) {
			Config.set(session, fmtLocale, Path.LOCALE_NAME_RU);
			session.setAttribute(defaultLocale, "ru");
		} else {
			Config.set(session, fmtLocale, "en");
			session.setAttribute(defaultLocale, Path.LOCALE_NAME_EN);
		}
		return Path.PAGE__MAIN;
	}
}
package com.java.logic.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import com.java.constant.Path;

public class I18NCommand implements ActionCommand {
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
//		session.setAttribute("lang", langParam);
		return Path.PAGE__MAIN;
//	    HttpSession session = request.getSession();
//
//	    String fmtLocale = "javax.servlet.jsp.jstl.fmt.locale";
//	    String defaultLocale = "defaultLocale";
//
//	    if (request.getParameter("ru") != null) {
//	      Config.set(session, fmtLocale, Path.LOCALE_NAME_RU);
//	      session.setAttribute(defaultLocale, "ru");
//
//	    } else {
//	      Config.set(session, fmtLocale, "en");
//	      session.setAttribute(defaultLocale, Path.LOCALE_NAME_EN);
//	    }
//
//	    User user = (User) session.getAttribute("user");
//	    return (user.getRoleId() == 1) ? "controller?action=users" : "controller?action=account";
	}
}
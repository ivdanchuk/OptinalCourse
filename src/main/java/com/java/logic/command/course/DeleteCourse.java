package com.java.logic.command.course;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.CourseManager;
import com.java.model.UserManager;

public class DeleteCourse implements ActionCommand {

	private final static Logger log = LogManager.getLogger(UserManager.class);
	private static final String PARAM_NAME_ID = "id";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		Long id = Long.parseLong(request.getParameter(PARAM_NAME_ID));
		CourseManager.getInstance().deleteCourseById(id);
		page = Path.COMMAND__READ_COURSES;

//		if (LoginLogic.checkLogin(login, pass)) {
//			request.setAttribute("user", login);
//			page = ConfigurationManager.getProperty("path.page.main");
//		} else {
//			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
//			page = ConfigurationManager.getProperty("path.page.login");
//		}
		return page;
	}
}

package com.java.logic.command.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.CourseManager;
import com.java.model.entity.Role;
import com.java.model.entity.User;

public class ReadUserCourses implements ActionCommand {
	private final static Logger log = LogManager.getLogger(ReadUserCourses.class);
	private static final String PARAM_NAME_USER_ID = "userId";
	private static final String PARAM_NAME_GET_OPTION = "getOption";

	@Override
	public String execute(HttpServletRequest request) {
		String userId = request.getParameter(PARAM_NAME_USER_ID);
		String getOption = request.getParameter(PARAM_NAME_GET_OPTION);
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		Role currentRole = (Role) request.getSession().getAttribute("currentRole");

		request.setAttribute("userId", userId);
		String path = Path.PAGE__ERROR_PAGE;

		if (getOption != null) {
			request.setAttribute("userCourses", CourseManager.getInstance()
					.findCoursesOfStudentWithStateFilter(currentUser.getId(), Integer.parseInt(getOption)));
			request.setAttribute("getOption", Integer.parseInt(getOption));

		} else {
			request.setAttribute("userCourses", CourseManager.getInstance().findAllStudentCourses(currentUser.getId()));
		}

		path = Path.PAGE__USER_COURSES;
		return path;
	}
}

package com.java.logic.command.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.logic.command.Roles;
import com.java.model.CourseManager;
import com.java.model.entity.Role;
import com.java.model.entity.User;

public class ReadUserCourses implements ActionCommand {
	private final static Logger log = LogManager.getLogger(ReadUserCourses.class);
	private static final String PARAM_NAME_USER_ID = "userId";

	@Override
	public String execute(HttpServletRequest request) {
		String userId = request.getParameter(PARAM_NAME_USER_ID);
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		Role currentRole = (Role) request.getSession().getAttribute("currentRole");
		request.setAttribute("userId", userId);

		if (currentRole.getName().equals(Roles.ROLE_TUTOR)) {
			request.setAttribute("userCourses", CourseManager.getInstance().findTutorCourses(Long.parseLong(userId)));
		} else if (currentRole.getName().equals(Roles.ROLE_STUDENT)) {
			request.setAttribute("userCourses", CourseManager.getInstance().findStudentCourses(Long.parseLong(userId)));
		}
		return Path.PAGE__USER_COURSES;
	}

}

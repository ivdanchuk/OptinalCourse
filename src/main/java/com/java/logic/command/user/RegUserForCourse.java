package com.java.logic.command.user;

import javax.servlet.http.HttpServletRequest;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.CourseManager;

public class RegUserForCourse implements ActionCommand {
	private static final String PARAM_NAME_USER_ID = "userId";
	private static final String PARAM_NAME_COURSE_ID = "courseId";

	@Override
	public String execute(HttpServletRequest request) {
		long userId = Long.parseLong(request.getParameter(PARAM_NAME_USER_ID));
		long courseId = Long.parseLong(request.getParameter("cars"));
		CourseManager.getInstance().registerCourseForUser(userId, courseId);
		return Path.COMMAND__READ_USER;
	}
}

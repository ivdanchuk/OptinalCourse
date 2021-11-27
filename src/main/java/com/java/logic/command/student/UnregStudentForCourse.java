package com.java.logic.command.user;

import javax.servlet.http.HttpServletRequest;

import com.java.constant.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.CourseManager;
import com.java.model.entity.User;

public class UnregUserForCourse implements ActionCommand {
	private static final String PARAM_NAME_COURSE_ID = "courseId";

	@Override
	public String execute(HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		long courseId = Long.parseLong(request.getParameter(PARAM_NAME_COURSE_ID));
		CourseManager.getInstance().unregisterStudentForCourse(currentUser.getId(), courseId);
		return Path.COMMAND__READ_USER_COURSES;
	}
}

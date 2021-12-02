package com.java.model.command.student;

import javax.servlet.http.HttpServletRequest;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.dao.manager.CourseManager;
import com.java.model.entity.User;

public class UnregStudentForCourse implements IActionCommand {
	private static final String PARAM_NAME_COURSE_ID = "courseId";

	@Override
	public String execute(HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		long courseId = Long.parseLong(request.getParameter(PARAM_NAME_COURSE_ID));
		CourseManager.getInstance().unregisterStudentForCourse(currentUser.getId(), courseId);
		return Path.COMMAND__READ_STUDENT_COURSES;
	}
}

package com.java.logic.command.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.java.config.MessageManager;
import com.java.constant.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.CourseManager;
import com.java.model.dto.CourseOfStudent;
import com.java.model.entity.User;

public class RegUserForCourse implements ActionCommand {
	private static final String PARAM_NAME_COURSE_ID = "courseId";

	@Override
	public String execute(HttpServletRequest request) {
		String path = Path.PAGE__ERROR_PAGE;

		User currenttUser = (User) request.getSession().getAttribute("currentUser");
		long courseId = Long.parseLong(request.getParameter(PARAM_NAME_COURSE_ID));

		boolean isNotRegistered = true;
		List<CourseOfStudent> courses = CourseManager.getInstance().findAllStudentCourses(currenttUser.getId());
		for (CourseOfStudent courseOfStudent : courses) {
			if (courseOfStudent.getId() == courseId) {
				isNotRegistered = false;
				break;
			}
		}

		if (isNotRegistered) {
			path = Path.COMMAND__READ_USER_COURSES;
			CourseManager.getInstance().registerStudentForCourse(currenttUser.getId(), courseId);
		} else {
			request.getSession().setAttribute("errorMessage", MessageManager.getProperty("message.alreadyregistered"));
		}
		return path;
	}
}

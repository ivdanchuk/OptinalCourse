package com.java.logic.command.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.CourseManager;
import com.java.model.entity.UserOfCourse;

public class readUsersOfCourse implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String courseId = request.getParameter("courseId");
		String path = Path.PAGE__ERROR_PAGE;
		if (courseId != null) {
			List<UserOfCourse> usersOfCourse = CourseManager.getInstance().findCourseUsers(Long.parseLong(courseId));
			request.getSession().setAttribute("usersOfCourse", usersOfCourse);
//			request.getSession().setAttribute("selectedCourseIdOnRegisterTutorPage", Long.parseLong(courseId));
			path = Path.PAGE__REGISTER_TUTOR;
		}
		return path;
	}

}

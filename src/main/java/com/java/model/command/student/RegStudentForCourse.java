package com.java.model.command.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.java.model.command.IActionCommand;
import com.java.model.config.MessageManager;
import com.java.model.constant.Path;
import com.java.model.dao.manager.CourseManager;
import com.java.model.dto.CourseOfStudent;
import com.java.model.entity.User;

public class RegStudentForCourse implements IActionCommand {
	private static final String PARAM_NAME_COURSE_ID = "courseId";

	@Override
	public String execute(HttpServletRequest request) {
		String path = Path.PAGE__ERROR_PAGE;
		String id = request.getParameter(PARAM_NAME_COURSE_ID);
		if (id == null) {
			request.getSession().setAttribute("errorMessage", MessageManager.getProperty("message.empty.course"));
			return path;
		}

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
			path = Path.COMMAND__READ_STUDENT_COURSES;
			CourseManager.getInstance().registerStudentForCourse(currenttUser.getId(), courseId);
		} else {
			request.getSession().setAttribute("errorMessage", MessageManager.getProperty("message.already.registered"));
		}
		return path;
	}
}

package com.java.logic.command.course;

import javax.servlet.http.HttpServletRequest;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.CourseManager;
import com.java.model.entity.Course;

public class ReadCourse implements ActionCommand {
	private static final String PARAM_NAME_ID = "id";

	@Override
	public String execute(HttpServletRequest request) {
		// Get clicked id
		String id = request.getParameter(PARAM_NAME_ID);
		Course course = CourseManager.getInstance().FindCourseById(Long.parseLong(id));
		request.setAttribute("course", course);

		return Path.PAGE__COURSE;
	}
}

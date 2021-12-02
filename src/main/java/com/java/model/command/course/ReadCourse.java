package com.java.model.command.course;

import javax.servlet.http.HttpServletRequest;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.dao.manager.CourseManager;
import com.java.model.entity.Course;

public class ReadCourse implements IActionCommand {
	private static final String PARAM_NAME_ID = "id";

	@Override
	public String execute(HttpServletRequest request) {
		String id = request.getParameter(PARAM_NAME_ID);
		Course course = CourseManager.getInstance().FindCourseById(Long.parseLong(id));
		request.setAttribute("course", course);
		return Path.PAGE__COURSE;
	}
}

package com.java.logic.command.course;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.logic.command.CommandEnum;
import com.java.model.CourseManager;
import com.java.model.entity.Course;

public class PrepareCourseRegForm implements ActionCommand {
	private static final String PARAM_NAME_USER_ID = "userId";
	private static final String PARAM_NAME_COURSE_ID = "courseId";

	@Override
	public String execute(HttpServletRequest request) {
		long userId = Long.parseLong(request.getParameter(PARAM_NAME_USER_ID));
		List<Course> courses = new ArrayList<>();
		courses = CourseManager.getInstance().listAllCourses();
		request.setAttribute("userId", userId);
		request.setAttribute("courses", courses);
		request.setAttribute("command", CommandEnum.REG_USER_FOR_COURSE);
		return Path.PAGE__USER_REG_COURSE;
	}
}

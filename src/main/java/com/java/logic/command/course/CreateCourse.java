package com.java.logic.command.course;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.CourseManager;
import com.java.model.entity.Course;

public class CreateCourse implements ActionCommand {
	private static final String PARAM_NAME_ID = "id";
	private static final String PARAM_NAME_NAME = "name";
	private static final String PARAM_NAME_DURATION = "duration";
	private static final String PARAM_NAME_START_DATE = "start_date";
	private static final String PARAM_NAME_END_DATE = "end_date";
	private static final String PARAM_NAME_TOPIC_ID = "topic_id";
	private static final String PARAM_NAME_USER_ID = "user_id";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		Long id = -1l;
		String name = request.getParameter(PARAM_NAME_NAME);
		int duration = Integer.parseInt(request.getParameter(PARAM_NAME_DURATION));
		LocalDate start_date = LocalDate.parse(request.getParameter(PARAM_NAME_START_DATE));
		LocalDate end_date = LocalDate.parse(request.getParameter(PARAM_NAME_END_DATE));
		long topic_id = Long.parseLong(request.getParameter(PARAM_NAME_TOPIC_ID));
		long user_id = Long.parseLong(request.getParameter(PARAM_NAME_USER_ID));
		Course course = new Course(id, name, duration, start_date, end_date, topic_id, user_id);
		CourseManager.getInstance().CreateCourse(course);
		page = Path.COMMAND__READ_COURSES;
		return page;
	}
}

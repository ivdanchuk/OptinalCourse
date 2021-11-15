package com.java.logic.command.course;

import javax.servlet.http.HttpServletRequest;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.logic.command.CommandEnum;
import com.java.model.CourseManager;

public class ReadCourse implements ActionCommand {
	private static final String PARAM_NAME_ID = "id";

	@Override
	public String execute(HttpServletRequest request) {
		String id = request.getParameter(PARAM_NAME_ID);
		request.setAttribute("command", CommandEnum.UPDATE_COURSE);
		request.setAttribute("course", CourseManager.getInstance().FindCourseById(Long.parseLong(id)));
		return Path.PAGE__COURSE;
	}

}

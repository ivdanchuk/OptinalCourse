package com.java.logic.command.user;

import javax.servlet.http.HttpServletRequest;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.CourseManager;

public class setMark implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String courseId = request.getParameter("courseId");
		String mark = request.getParameter("mark");
		String path = Path.PAGE__ERROR_PAGE;

		if ((userId != null) & (courseId != null)) {
			CourseManager.getInstance().setMarkForStudent(Long.parseLong(userId), Long.parseLong(courseId),
					Integer.parseInt(mark));
			path = Path.COMMAND__SHOW_TUTOR_REG_FORM;
		} else {
			String errorMessage = "setMark: userId or courseId is null";
			request.setAttribute("errorMessage", errorMessage);
		}
		return path;
	}
}

package com.java.model.command.tutor;

import javax.servlet.http.HttpServletRequest;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.dao.manager.CourseManager;

public class SetMark implements IActionCommand {

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

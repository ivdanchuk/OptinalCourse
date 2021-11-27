package com.java.logic.command.course;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.constant.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.CourseManager;
import com.java.model.UserManager;
import com.java.service.SessionService;

public class DeleteCourse implements ActionCommand {

	private final static Logger log = LogManager.getLogger(UserManager.class);
	private static final String PARAM_NAME_ID = "id";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		Long id = Long.parseLong(request.getParameter(PARAM_NAME_ID));
		if (CourseManager.getInstance().deleteCourseById(id)) {
			page = Path.COMMAND__READ_COURSES;
			SessionService.UpdateCourses(request);
		} else {
			page = Path.PAGE__ERROR_PAGE;
			request.getSession().setAttribute("errorMessage", "Can't delete row, see log for details");
		}
		return page;
	}
}

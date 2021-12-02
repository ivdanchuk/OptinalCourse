package com.java.model.command.course;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.dao.manager.CourseManager;
import com.java.model.dao.manager.UserManager;
import com.java.model.service.SessionService;

public class DeleteCourse implements IActionCommand {

	private final static Logger log = LogManager.getLogger(UserManager.class);
	private static final String PARAM_NAME_ID = "id";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		Long id = Long.parseLong(request.getParameter(PARAM_NAME_ID));
		if (CourseManager.getInstance().deleteCourseById(id)) {
			page = Path.COMMAND__READ_COURSES;

			SessionService.setCourses(request);
		} else {
			page = Path.PAGE__ERROR_PAGE;
			request.getSession().setAttribute("errorMessage", "Can't delete row, see log for details");
		}
		return page;
	}
}

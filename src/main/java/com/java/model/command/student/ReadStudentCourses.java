package com.java.model.command.student;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.dao.manager.CourseManager;
import com.java.model.entity.Role;
import com.java.model.entity.User;
import com.java.model.service.SessionService;

public class ReadStudentCourses implements IActionCommand {
	private final static Logger log = LogManager.getLogger(ReadStudentCourses.class);
	private static final String PARAM_NAME_USER_ID = "userId";
	private static final String PARAM_NAME_GET_OPTION = "getOption";

	@Override
	public String execute(HttpServletRequest request) {
		String path = Path.PAGE__ERROR_PAGE;
		String userId = request.getParameter(PARAM_NAME_USER_ID);
		String getOption = request.getParameter(PARAM_NAME_GET_OPTION);
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		Role currentRole = (Role) request.getSession().getAttribute("currentRole");
		request.setAttribute("userId", userId);

		SessionService.setCourses(request);

		if (getOption != null) {
			request.setAttribute("userCourses", CourseManager.getInstance()
					.findCoursesOfStudentWithStateFilter(currentUser.getId(), Integer.parseInt(getOption)));
			request.setAttribute("getOption", Integer.parseInt(getOption));

		} else {
			request.setAttribute("userCourses", CourseManager.getInstance().findAllStudentCourses(currentUser.getId()));
			int getAll = 0;
			request.setAttribute("getOption", getAll);
		}

		path = Path.PAGE__USER_COURSES;
		return path;
	}
}

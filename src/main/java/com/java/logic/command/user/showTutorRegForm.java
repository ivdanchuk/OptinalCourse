package com.java.logic.command.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.CourseManager;
import com.java.model.dao.CourseDaoImpl;
import com.java.model.entity.Course;
import com.java.model.entity.User;

public class showTutorRegForm implements ActionCommand {
	private static final Logger logger = LogManager.getLogger(CourseDaoImpl.class.getName());

	@Override
	public String execute(HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		String path = Path.PAGE__ERROR_PAGE;
		if (currentUser != null) {
			long userId = currentUser.getId();
			List<Course> tutorCourses = CourseManager.getInstance().findTutorCourses(userId);
			request.getSession().setAttribute("tutorCourses", tutorCourses);
			path = Path.PAGE__REGISTER_TUTOR;
		} else {
			String errorMessage = "showTutorRegForm: currentUser is null, can't execute command, redirect to error page";
			logger.error(errorMessage);
			request.setAttribute("errorMessage", errorMessage);
		}
		return path;
	}
}

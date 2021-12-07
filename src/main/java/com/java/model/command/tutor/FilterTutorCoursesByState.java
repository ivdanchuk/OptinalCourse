package com.java.model.command.tutor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.command.IActionCommand;
import com.java.model.constant.CourseStateId;
import com.java.model.constant.Path;
import com.java.model.dao.impl.CourseDaoImpl;
import com.java.model.dao.manager.CourseManager;
import com.java.model.entity.Course;
import com.java.model.entity.User;

public class FilterTutorCoursesByState implements IActionCommand {
	private static final Logger logger = LogManager.getLogger(CourseDaoImpl.class.getName());

	@Override
	public String execute(HttpServletRequest request) {
		String path = Path.PAGE__ERROR_PAGE;

		User currentUser = (User) request.getSession().getAttribute("currentUser");
		if (currentUser == null) {
			String errorMessage = "showTutorRegForm: currentUser is null, can't execute command, redirect to error page";
			logger.error(errorMessage);
			request.setAttribute("errorMessage", errorMessage);
			return path;
		}

		int CourseState = CourseStateId.COURSE_ALL;
		String CourseStateParam = request.getParameter("CourseStateId");
		if (CourseStateParam != null) {
			CourseState = Integer.parseInt(CourseStateParam);
		}
		request.getSession().setAttribute("CourseStateId", CourseState);

		long userId = currentUser.getId();
		List<Course> tutorCourses = CourseManager.getInstance().findTutorCourses(userId, CourseState);
		request.getSession().setAttribute("tutorCourses", tutorCourses);
		request.getSession().setAttribute("usersOfCourse", null);

		path = Path.PAGE__REGISTER_TUTOR;

		return path;

	}

}

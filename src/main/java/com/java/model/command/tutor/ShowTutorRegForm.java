package com.java.model.command.tutor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.dao.impl.CourseDaoImpl;
import com.java.model.dao.manager.CourseManager;
import com.java.model.dto.StudentOfCourse;
import com.java.model.entity.Course;
import com.java.model.entity.User;

public class ShowTutorRegForm implements IActionCommand {
	private static final Logger logger = LogManager.getLogger(CourseDaoImpl.class.getName());

	@Override
	public String execute(HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		String path = Path.PAGE__ERROR_PAGE;
		if (currentUser != null) {
			long userId = currentUser.getId();
			List<Course> tutorCourses = CourseManager.getInstance().findTutorCourses(userId);
			request.getSession().setAttribute("tutorCourses", tutorCourses);

			// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			String courseId = request.getParameter("courseId");
			if (courseId == null) {
				courseId = (String) request.getSession().getAttribute("courseId");
			}
			if (courseId != null) {
				List<StudentOfCourse> usersOfCourse = CourseManager.getInstance()
						.findCourseUsers(Long.parseLong(courseId));
				request.getSession().setAttribute("usersOfCourse", usersOfCourse);
			}

			path = Path.PAGE__REGISTER_TUTOR;
		} else {
			String errorMessage = "showTutorRegForm: currentUser is null, can't execute command, redirect to error page";
			logger.error(errorMessage);
			request.setAttribute("errorMessage", errorMessage);
		}
		return path;
	}
}

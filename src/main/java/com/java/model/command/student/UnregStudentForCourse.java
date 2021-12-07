package com.java.model.command.student;

import javax.servlet.http.HttpServletRequest;

import com.java.model.command.IActionCommand;
import com.java.model.constant.CourseStateId;
import com.java.model.constant.Path;
import com.java.model.dao.manager.CourseManager;
import com.java.model.entity.Course;
import com.java.model.entity.User;

public class UnregStudentForCourse implements IActionCommand {
	private static final String PARAM_NAME_COURSE_ID = "courseId";

	@Override
	public String execute(HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		long courseId = Long.parseLong(request.getParameter(PARAM_NAME_COURSE_ID));

		Course course = CourseManager.getInstance().FindCourseById(courseId);
		if (course.getState() == CourseStateId.COURSE_NOTSTARTED) {
			CourseManager.getInstance().unregisterStudentForCourse(currentUser.getId(), courseId);
			return Path.COMMAND__READ_STUDENT_COURSES;
		}
		request.setAttribute("errorMessage", "Can't unregister student for this course");
		return Path.PAGE__ERROR_PAGE;
	}
}

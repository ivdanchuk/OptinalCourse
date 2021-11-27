package com.java.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.java.constant.RoleConstant;
import com.java.model.CourseManager;
import com.java.model.UserManager;
import com.java.model.entity.Course;
import com.java.model.entity.User;

public class SessionService {
	public static void UpdateTutors(HttpServletRequest request) {
		List<User> tutors = new ArrayList<>();
		tutors = UserManager.getInstance().listAllUsersByRoleID(RoleConstant.ROLE_TUTOR_ID);
		request.getSession().setAttribute("tutors", tutors);
	}

	public static void UpdateCourses(HttpServletRequest request) {
		List<Course> courses = new ArrayList<>();
		courses = CourseManager.getInstance().findAllCourses();
		request.getSession().setAttribute("courses", courses);
	}
}

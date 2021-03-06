package com.java.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.java.model.constant.CourseStateId;
import com.java.model.constant.RoleId;
import com.java.model.dao.manager.CourseManager;
import com.java.model.dao.manager.RoleManager;
import com.java.model.dao.manager.TopicManager;
import com.java.model.dao.manager.UserManager;
import com.java.model.entity.Course;
import com.java.model.entity.CourseState;
import com.java.model.entity.Role;
import com.java.model.entity.Topic;
import com.java.model.entity.User;

public class SessionService {
	public static void setTutors(HttpServletRequest request) {
		List<User> tutors = new ArrayList<>();
		tutors = UserManager.getInstance().listAllUsersByRoleID(RoleId.ROLE_TUTOR_ID);
		request.getSession().setAttribute("tutors", tutors);
	}

	public static void setCoursesState(HttpServletRequest request) {
		List<CourseState> coursesState = new ArrayList<>();

		CourseState courseState = new CourseState(CourseStateId.COURSE_NOTSTARTED, "Not started");
		coursesState.add(courseState);

		courseState = new CourseState(CourseStateId.COURSE_STARTED, "In progress");
		coursesState.add(courseState);

		courseState = new CourseState(CourseStateId.COURSE_FINISHED, "Finished");
		coursesState.add(courseState);

		courseState = new CourseState(CourseStateId.COURSE_ALL, "All");
		coursesState.add(courseState);

		request.getSession().setAttribute("coursesState", coursesState);

	}

	public static void setCourses(HttpServletRequest request) {
		List<Course> courses = new ArrayList<>();
		courses = CourseManager.getInstance().findAllCourses();
		request.getSession().setAttribute("courses", courses);

		courses = CourseManager.getInstance().findAllNotStartedCourses();
		request.getSession().setAttribute("coursesNotStarted", courses);

		setCoursesState(request);
	}

	public static void setTopics(HttpServletRequest request) {
		List<Topic> topics = new ArrayList<>();
		topics = TopicManager.getInstance().listAllTopics();
		request.getSession().setAttribute("topics", topics);
	}

	public static void setCurrentUser(HttpServletRequest request, User currentUser) {
		request.getSession().setAttribute("currentUser", currentUser);
		setCurrentRole(request, currentUser);
	}

	public static void setCurrentRole(HttpServletRequest request, User currentUser) {
		Role role = RoleManager.getInstance().FindRoleById(currentUser.getRole_id());
		request.getSession().setAttribute("currentRole", role);
	}

	public static void setRolesForCurrentUser(HttpServletRequest request, User currentUser) {
		List<Role> roles = new ArrayList<>();
		Role role = null;
		if (currentUser.getRole_id() == RoleId.ROLE_ADMIN_ID) {
			roles = RoleManager.getInstance().listAllRoles();
			Collections.sort(roles, new Comparator<Role>() {
				@Override
				public int compare(Role r1, Role r2) {
					if (r1.getId() > r2.getId())
						return 1;
					if (r1.getId() < r2.getId())
						return -1;
					return 0;
				}
			});

		} else {
			role = RoleManager.getInstance().FindRoleById(currentUser.getRole_id());
			roles.add(role);
			request.getSession().setAttribute("role", role);
		}
		request.getSession().setAttribute("roles", roles);
	}

	public static void setRolesForNewUser(HttpServletRequest request, User currentUser) {
		List<Role> roles = new ArrayList<>();
		Role role = RoleManager.getInstance().FindRoleById(RoleId.ROLE_STUDENT_ID);
		roles.add(role);
		request.getSession().setAttribute("roles", roles);
	}
}

package com.java.logic.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.java.controller.Path;
import com.java.model.CourseManager;
import com.java.model.RoleManager;
import com.java.model.TopicManager;
import com.java.model.UserManager;
import com.java.model.entity.Course;
import com.java.model.entity.Role;
import com.java.model.entity.Topic;
import com.java.model.entity.User;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);

		List<User> dbUsers = new ArrayList<>();
		dbUsers = UserManager.getInstance().listAllUsers();

		List<Topic> topics = new ArrayList<>();
		topics = TopicManager.getInstance().listAllTopics();

		List<User> tutors = new ArrayList<>();
		tutors = UserManager.getInstance().listAllUsersByRoleID(2l);

		List<Course> courses = new ArrayList<>();
		courses = CourseManager.getInstance().listAllCourses();

		// Role currentRole = null;
		User currentUser = LoginLogic.checkLogin(login, pass, dbUsers);
		if (currentUser != null) {
			Role currentRole = RoleManager.getInstance().FindRoleById(currentUser.getRole_id());
			request.getSession().setAttribute("currentUser", currentUser);
			request.getSession().setAttribute("currentRole", currentRole);
			request.getSession().setAttribute("topics", topics);
			request.getSession().setAttribute("courses", courses);
			request.getSession().setAttribute("tutors", tutors);
			page = Path.PAGE__MAIN;
		} else {
//			request.getSession().setAttribute("errorLoginPassMessage",
//					MessageManager.getProperty("message.loginerror"));
			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
			page = Path.PAGE__LOGIN;
			// page = ConfigurationManager.getProperty("....");
		}
		return page;
	}
}

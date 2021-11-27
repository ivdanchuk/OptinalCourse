package com.java.logic.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.java.config.MessageManager;
import com.java.constant.Path;
import com.java.constant.RoleConstant;
import com.java.model.CourseManager;
import com.java.model.RoleManager;
import com.java.model.TopicManager;
import com.java.model.UserManager;
import com.java.model.entity.Course;
import com.java.model.entity.Role;
import com.java.model.entity.Topic;
import com.java.model.entity.User;
import com.java.service.SessionService;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) {
		String page = Path.PAGE__LOGIN;
		User currentUser = null;

		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		User user = UserManager.getInstance().FindUserByEmail(login);
		if (user.getEmail() == null) {
			request.getSession().setAttribute("errorLoginPassMessage",
					MessageManager.getProperty("message.loginnotexist"));
			return page;
		}

		if ((user.getEmail().equals(login)) && (user.getPassword().equals(pass))) {
			if (user.getRole_id() != RoleConstant.ROLE_BLOCED_ID) {
				currentUser = user;
				page = Path.PAGE__MAIN;
			} else {
				request.getSession().setAttribute("errorLoginPassMessage",
						MessageManager.getProperty("message.loginblocked"));
			}
		} else {
			request.getSession().setAttribute("errorLoginPassMessage",
					MessageManager.getProperty("message.loginerror"));
		}

		if (currentUser != null) {
			Role currentRole = RoleManager.getInstance().FindRoleById(currentUser.getRole_id());
			request.getSession().setAttribute("currentUser", currentUser);
			request.getSession().setAttribute("currentRole", currentRole);

			List<Topic> topics = new ArrayList<>();
			topics = TopicManager.getInstance().listAllTopics();
			request.getSession().setAttribute("topics", topics);

			SessionService.UpdateCourses(request);
//			List<Course> courses = new ArrayList<>();
//			courses = CourseManager.getInstance().findAllCourses();
//			request.getSession().setAttribute("courses", courses);

			SessionService.UpdateTutors(request);
//			List<User> tutors = new ArrayList<>();
//			tutors = UserManager.getInstance().listAllUsersByRoleID(2l);
//			request.getSession().setAttribute("tutors", tutors);

			List<Role> roles = new ArrayList<>();
			roles = RoleManager.getInstance().listAllRoles();
			request.getSession().setAttribute("roles", roles);

			List<Course> coursesNotStarted = new ArrayList<>();
			coursesNotStarted = CourseManager.getInstance().findAllNotStartedCourses();
			request.getSession().setAttribute("coursesNotStarted", coursesNotStarted);

			// By default
			request.getSession().setAttribute("defaultLocale", "en");
		}
		return page;
	}
}

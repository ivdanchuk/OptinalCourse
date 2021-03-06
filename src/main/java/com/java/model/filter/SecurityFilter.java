package com.java.model.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.constant.Path;
import com.java.model.constant.RoleId;
import com.java.model.entity.Role;

@WebFilter(urlPatterns = "/controller")

public class SecurityFilter implements Filter {
	private final static Logger log = LogManager.getLogger(EncodingFilter.class);
	// commands access
//	private static Map<Role, List<String>> accessMap = new HashMap<>();
	private static Map<String, List<String>> accessMap = new HashMap<>();
	private static List<String> commons = new ArrayList<>();
	private static List<String> outOfControl = new ArrayList<>();
	private static final String COMMANDS_ADMIN = "CREATE_COURSE READ_COURSE UPDATE_COURSE DELETE_COURSE"
			+ " CREATE_TOPIC READ_TOPIC UPDATE_TOPIC DELETE_TOPIC"
			+ " CREATE_USER UPDATE_USER DELETE_USER READ_USERS READ_USERS2 READ_STUDENT_COURSES"
			+ " REG_STUDENT_FOR_COURSE UNREG_STUDENT_FOR_COURSE show_tutor_reg_form read_users_of_course show_mark_form";

	private static final String COMMANDS_STUDENT = "REG_STUDENT_FOR_COURSE UNREG_STUDENT_FOR_COURSE READ_STUDENT_COURSES";

	private static final String COMMANDS_TUTOR = "READ_COURSE UPDATE_COURSE CREATE_COURSE" + " READ_TOPIC UPDATE_TOPIC"
			+ " show_tutor_reg_form read_users_of_course show_mark_form set_mark";

	private static final String COMMANDS_COMMON = "LOGOUT READ_USER READ_CURRENT_USER UPDATE_USER "
			+ " READ_COURSES READ_TOPICS sort_courses FILTER_TUTOR_COURSES_BY_STATE SEARCH_USER_BY_EMAIL";

	private static final String COMMANDS_OUT_OF_CONTROL = "LOGIN I18N SIGNUP";

	private static final String COMMANDS_BLOCKED = "";

	@Override
	public void init(FilterConfig config) {
		// roles
		accessMap.put(RoleId.ROLE_ADMIN_NAME, asList(COMMANDS_ADMIN));
		accessMap.put(RoleId.ROLE_STUDENT_NAME, asList(COMMANDS_STUDENT));
		accessMap.put(RoleId.ROLE_TUTOR_NAME, asList(COMMANDS_TUTOR));
		accessMap.put(RoleId.ROLE_BLOCED_NAME, asList(COMMANDS_BLOCKED));

		// commons
		commons = asList(COMMANDS_COMMON);

		// out of control
		outOfControl = asList(COMMANDS_OUT_OF_CONTROL);
		log.trace("Out of control commands --> " + outOfControl);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (accessAllowed(request)) {
			log.debug("Filter finished");
			chain.doFilter(request, response);
		} else {
			String errorMessages = "You do not have permission to access the requested resource";
			request.setAttribute("errorMessage", errorMessages);
			request.getRequestDispatcher(Path.PAGE__ERROR_PAGE).forward(request, response);
		}
	}

	private boolean accessAllowed(ServletRequest request) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String commandName = request.getParameter("command");

		if (commandName == null || commandName.isEmpty()) {
			log.error("SecurityFilter#accessAllowed: command is NULL !");
			return false;
		}

		if (outOfControl.contains(commandName)) {
			return true;
		}

		HttpSession session = httpRequest.getSession(false);
		if (session == null) {
			log.error("SecurityFilter#accessAllowed: session is NULL !");
			return false;
		}

		Role userRole = (Role) session.getAttribute("currentRole");
		if (userRole == null) {
			log.error("SecurityFilter#accessAllowed: role is NULL !");
			return false;
		}

		boolean result = accessMap.get(userRole.getName()).contains(commandName) || commons.contains(commandName);
		if (!result) {
			log.error("SecurityFilter#accessAllowed: You do not have permission to access " + commandName);
		}
		return result;
	}

	private List<String> asList(String param) {
		List<String> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(param);
		while (st.hasMoreTokens()) {
			list.add(st.nextToken().toLowerCase());
		}
		return list;
	}
}

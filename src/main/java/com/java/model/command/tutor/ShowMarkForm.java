package com.java.model.command.tutor;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.dao.impl.CourseDaoImpl;

public class ShowMarkForm implements IActionCommand {
	private static final Logger logger = LogManager.getLogger(CourseDaoImpl.class.getName());

	@Override
	public String execute(HttpServletRequest request) {
//		User currentUser = (User) request.getSession().getAttribute("currentUser");
		String userId = request.getParameter("userId");
		String courseId = request.getParameter("courseId");
		String userMark = request.getParameter("userMark");
		String path = Path.PAGE__ERROR_PAGE;
		if ((userId != null) & (courseId != null)) {
			request.getSession().setAttribute("userId", userId);
			request.getSession().setAttribute("courseId", courseId);
			request.getSession().setAttribute("userMark", userMark);
			path = Path.PAGE___SET_MARK;
		} else {
			String errorMessage = "showTutorRegForm: currentUser is null, can't execute command, redirect to error page";
			logger.error(errorMessage);
			request.setAttribute("errorMessage", errorMessage);
		}
		return path;
	}
}

package com.java.logic.command.course;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.constant.Path;
import com.java.logic.command.ActionCommand;
import com.java.service.SessionService;

public class ReadCourses implements ActionCommand {
	private final static Logger log = LogManager.getLogger(ReadCourses.class);

	@Override
	public String execute(HttpServletRequest request) {
		SessionService.setCourses(request);
		return Path.PAGE__COURSES;
	}
}

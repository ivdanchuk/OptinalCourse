package com.java.model.command.course;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.service.SessionService;

public class ReadCourses implements IActionCommand {
	private final static Logger log = LogManager.getLogger(ReadCourses.class);

	@Override
	public String execute(HttpServletRequest request) {
		SessionService.setCourses(request);
		return Path.PAGE__COURSES;
	}
}

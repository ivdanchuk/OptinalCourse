package com.java.logic.command.course;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.constant.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.CourseManager;
import com.java.model.entity.Course;

public class ReadCourses implements ActionCommand {
	private final static Logger log = LogManager.getLogger(ReadCourses.class);

	@Override
	public String execute(HttpServletRequest request) {
		List<Course> courses = new ArrayList<>();
		courses = CourseManager.getInstance().findAllCourses();
		request.setAttribute("courses", courses);
		log.debug("ReadCourses#execute " + courses);
		return Path.PAGE__COURSES;
	}

}

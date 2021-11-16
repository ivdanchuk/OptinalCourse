package com.java.logic.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.java.controller.Path;
import com.java.model.CourseManager;
import com.java.model.entity.Course;

public class SortCourses implements ActionCommand {
	public static final String PARAM_BY_NAME_TOPIC_ID = "topicId";
	public static final String PARAM_BY_NAME_TUTOR_ID = "tutorId";
	public static final String PARAM_BY_NAME_SORT_OPTION = "sortOption";

	@Override
	public String execute(HttpServletRequest request) {
//		sort_courses
//		topicId
//		tutorId
//		sortOption SortbyName SortbyDuration SortbyCount
//		SELECT * from courses
//		where (user_id =2)and (topic_id=2) order by counter ASC

		long topicId = Long.parseLong(request.getParameter(PARAM_BY_NAME_TOPIC_ID));
		long tutorId = Long.parseLong(request.getParameter(PARAM_BY_NAME_TUTOR_ID));
		String sortOption = request.getParameter(PARAM_BY_NAME_SORT_OPTION);
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * from courses ");

		if ((topicId | tutorId) > 0) {
			sb.append("WHERE ");
		}
		if (topicId > 0) {
			sb.append("(topic_id=" + topicId + ")");
		}
		if ((topicId > 0) & (tutorId > 0)) {
			sb.append("and ");
		}

		if (tutorId > 0) {
			sb.append("(user_id=" + tutorId + ")");
		}
		if ("SortbyName".equals(sortOption)) {
			sb.append(" order by name");

		}

		List<Course> courses = new ArrayList<>();
		String query = sb.toString();
		courses = CourseManager.getInstance().executeSqlQuery(query);

		request.setAttribute("courses", courses);
		return Path.PAGE__COURSES;
	}
}

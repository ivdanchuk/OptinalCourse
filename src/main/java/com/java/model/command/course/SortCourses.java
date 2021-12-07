package com.java.model.command.course;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.dao.manager.CourseManager;
import com.java.model.entity.Course;

public class SortCourses implements IActionCommand {
	public static final String PARAM_BY_NAME_TOPIC_ID = "topicId";
	public static final String PARAM_BY_NAME_TUTOR_ID = "tutorId";
	public static final String PARAM_BY_NAME_SORT_OPTION = "sortOption";

	@Override
	public String execute(HttpServletRequest request) {

		long topicId = Long.parseLong(request.getParameter(PARAM_BY_NAME_TOPIC_ID));
		request.getSession().setAttribute("topicIdForSorting", topicId);

		long tutorId = Long.parseLong(request.getParameter(PARAM_BY_NAME_TUTOR_ID));
		request.getSession().setAttribute("tutorIdForSorting", tutorId);

		String sortOption = request.getParameter(PARAM_BY_NAME_SORT_OPTION);
		request.getSession().setAttribute("sortOptionForSorting", sortOption);

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * from courses ");

		if ((topicId | tutorId) != 0) {
			sb.append("WHERE ");
		}
		if (topicId > 0) {
			sb.append("(topic_id=" + topicId + ")");
		}
		if ((topicId > 0) && (tutorId > 0)) {
			sb.append("and ");
		}

		if (tutorId > 0) {
			sb.append("(user_id=" + tutorId + ")");
		}

		if (sortOption == null) {
			sb.append(" order by name");
		} else {
			if ("SortbyName".equals(sortOption)) {
				sb.append(" order by name");
			} else if ("SortbyDuration".equals(sortOption)) {
				sb.append(" order by duration");
			} else if ("SortbyCount".equals(sortOption)) {
				sb.append(" order by counter");
			}
		}

		List<Course> courses = new ArrayList<>();
		String query = sb.toString();
		courses = CourseManager.getInstance().executeSqlQuery(query);

		request.setAttribute("courses", courses);
		return Path.PAGE__COURSES;
	}
}

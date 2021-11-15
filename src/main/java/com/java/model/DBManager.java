package com.java.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.entity.Course;
import com.java.model.entity.User;

public class DBManager {
	private static final Logger logger = LogManager.getLogger(DBManager.class.getName());
	private static final String SQL_INSERT_COURSE_FOR_USER = "INSERT INTO M2M_USERS_COURSES (user_id,course_id) VALUES (?,?)";

	public void createCourseForUser(Connection conn, Course course, User user) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_INSERT_COURSE_FOR_USER);
			ps.setLong(1, user.getId());
			ps.setLong(2, course.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

package com.java.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.DaoException;
import com.java.model.entity.Course;
import com.java.model.entity.User;

public class UserCourseImpl {
	private Logger logger = LogManager.getLogger(UserCourseImpl.class);
	private static final String SQL_Insert_User_Course = "INSERT INTO m2m_users_cources (user_id,course_id) values (?,?)";

	public void setCourseForUSer(Connection con, User user, Course course) throws DaoException {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(SQL_Insert_User_Course);
			ps.setLong(1, user.getId());
			ps.setLong(2, course.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.fatal("UserCourseImpl#setCourseForUSer: SQLException");
			throw new DaoException("UserCourseImpl#findAll:can't execute setCourseForUSer method", e);
		}
	}
}

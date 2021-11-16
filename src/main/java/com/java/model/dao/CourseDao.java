package com.java.model.dao;

import java.sql.Connection;
import java.util.List;

import com.java.model.DaoException;
import com.java.model.entity.Course;

public interface CourseDao extends BaseDao<Long, Course> {
	public List<Course> findStudentCourses(Connection conn, long userId) throws DaoException;

	public void registerCourseForUser(Connection conn, long userId, long courseId) throws DaoException;

	List<Course> findTutorCourses(Connection conn, long userId) throws DaoException;

	void deleteCourseForUser(Connection conn, long userId, long courseId) throws DaoException;

	List<Course> executeSqlQuery(Connection conn, String SQL) throws DaoException;

}

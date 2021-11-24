package com.java.model.dao;

import java.sql.Connection;
import java.util.List;

import com.java.model.DaoException;
import com.java.model.dto.CourseOfStudent;
import com.java.model.dto.StudentOfCourse;
import com.java.model.entity.Course;

public interface CourseDao extends BaseDao<Long, Course> {
	public List<CourseOfStudent> findAllStudentCourses(Connection conn, long userId) throws DaoException;

	public void registerStudentForCourse(Connection conn, long userId, long courseId) throws DaoException;

	List<Course> findTutorCourses(Connection conn, long userId) throws DaoException;

	void unregisterStudentForCourse(Connection conn, long userId, long courseId) throws DaoException;

	List<Course> executeSqlQuery(Connection conn, String SQL) throws DaoException;

	List<StudentOfCourse> findCourseUsers(Connection conn, long courseId) throws DaoException;

	void setMarkForStudent(Connection conn, long userId, long courseId, int mark) throws DaoException;

	List<CourseOfStudent> findCoursesOfStudentWithStateFilter(Connection conn, long userId, int state) throws DaoException;

	List<Course> findAllNotStartedCourses(Connection conn) throws DaoException;

}

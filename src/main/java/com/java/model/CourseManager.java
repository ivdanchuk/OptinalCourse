package com.java.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.dao.CourseDaoImpl;
import com.java.model.entity.Course;

public class CourseManager {
	private static CourseManager instance;
	private final static Logger log = LogManager.getLogger(CourseManager.class);

	private ConnectionPool connectionPool;
	private CourseDaoImpl courseDaoImpl;

	private CourseManager() {
		connectionPool = ConnectionPool.getInstance();
		courseDaoImpl = CourseDaoImpl.getInstance();
	}

	public static synchronized CourseManager getInstance() {
		if (instance == null) {
			instance = new CourseManager();
		}
		return instance;
	}

	public List<Course> listAllCourses() {
		Connection conn = null;
		List<Course> courses = new ArrayList<>();
		try {
			conn = connectionPool.getConnection();
			courses = courseDaoImpl.findAll(conn);
		} catch (DaoException e) {
			log.error("CourseManager#listAllCourses: can't list courses");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("CourseManager#listAllCourses: can't close connection");
			}
		}
		return courses;
	}

	public List<Course> findTutorCourses(long userId) {
		Connection conn = null;
		List<Course> userCourses = new ArrayList<>();
		try {
			conn = connectionPool.getConnection();
			userCourses = courseDaoImpl.findTutorCourses(conn, userId);
		} catch (DaoException e) {
			log.error("CourseManager#findTutorCourses: can't find tutor's courses");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("CourseManager#findTutorCourses: can't close connection");
			}
		}
		return userCourses;
	}

	public List<Course> findStudentCourses(long userId) {
		Connection conn = null;
		List<Course> userCourses = new ArrayList<>();
		try {
			conn = connectionPool.getConnection();
			userCourses = courseDaoImpl.findStudentCourses(conn, userId);
		} catch (DaoException e) {
			log.error("CourseManager#findUserCourses: can't find user's courses");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("CourseManager#findUserCourses: can't close connection");
			}
		}
		return userCourses;
	}

	public void registerCourseForUser(long userId, long courseId) {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			courseDaoImpl.registerCourseForUser(conn, userId, courseId);
		} catch (DaoException e) {
			log.error("CourseManager#registerCourseForUser: can't register course", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("CourseManager#registerCourseForUser: can't close connection", e);
			}
		}
	}

	public void CreateCourse(Course course) {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			courseDaoImpl.create(conn, course);
		} catch (DaoException e) {
			log.error("CourseManager#CreateCourse: can't create course", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("CourseManager#CreateCourse: can't close connection", e);
			}
		}
	}

	public void UpdateCourse(Course course) {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			courseDaoImpl.update(conn, course);
		} catch (DaoException e) {
			log.error("CourseManager#UpdateCourse: can't update course", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("CourseManager#UpdateCourse: can't close connection", e);
			}
		}
	}

	public void DeleteCourse(long id) {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			courseDaoImpl.deleteById(conn, id);
		} catch (DaoException e) {
			log.error("CourseManager#DeleteCourse: can't delete course", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("CourseManager#DeleteCourse: can't close connection", e);
			}
		}
	}

	public Course FindCourseById(long id) {
		Course course = new Course();
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			course = courseDaoImpl.findEntityById(conn, id);
		} catch (DaoException e) {
			log.error("CourseManager#FindCourseById: can't find course", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("CourseManager#FindCourseById: can't close connection", e);
			}
		}
		return course;
	}
}

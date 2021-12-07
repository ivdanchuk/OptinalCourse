package com.java.model.dao.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.dao.impl.CourseDaoImpl;
import com.java.model.db.ConnectionPool;
import com.java.model.dto.CourseOfStudent;
import com.java.model.dto.StudentOfCourse;
import com.java.model.entity.Course;
import com.java.model.exception.DaoException;

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

	public List<Course> executeSqlQuery(String SqlQuery) {
		Connection conn = null;
		List<Course> courses = new ArrayList<>();
		try {
			conn = connectionPool.getConnection();
			courses = courseDaoImpl.executeSqlQuery(conn, SqlQuery);
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

	public List<Course> findAllNotStartedCourses() {
		Connection conn = null;
		List<Course> courses = new ArrayList<>();
		try {
			conn = connectionPool.getConnection();
			courses = courseDaoImpl.findAllNotStartedCourses(conn);
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

	public List<Course> findAllCourses() {
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

	public List<Course> findTutorCourses(long userId, int state) {
		Connection conn = null;
		List<Course> userCourses = new ArrayList<>();
		try {
			conn = connectionPool.getConnection();
			userCourses = courseDaoImpl.findTutorCourses(conn, userId, state);
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

	public List<StudentOfCourse> findCourseUsers(long courseId) {
		Connection conn = null;
		List<StudentOfCourse> usersOfCourse = new ArrayList<>();
		try {
			conn = connectionPool.getConnection();
			usersOfCourse = courseDaoImpl.findCourseUsers(conn, courseId);
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
		return usersOfCourse;
	}

	public List<CourseOfStudent> findCoursesOfStudentWithStateFilter(long userId, int state) {
		Connection conn = null;
		List<CourseOfStudent> userCourses = new ArrayList<>();
		try {
			conn = connectionPool.getConnection();
			userCourses = courseDaoImpl.findCoursesOfStudentWithStateFilter(conn, userId, state);
		} catch (DaoException e) {
			log.error("CourseManager#findCoursesForStudentStateFilter: can't find user's courses");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("CourseManager#findCoursesForStudentStateFilter: can't close connection");
			}
		}
		return userCourses;
	}

	public List<CourseOfStudent> findAllStudentCourses(long userId) {
		Connection conn = null;
		List<CourseOfStudent> userCourses = new ArrayList<>();
		try {
			conn = connectionPool.getConnection();
			userCourses = courseDaoImpl.findAllStudentCourses(conn, userId);
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

	public void unregisterStudentForCourse(long userId, long courseId) {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			courseDaoImpl.unregisterStudentForCourse(conn, userId, courseId);
		} catch (DaoException e) {
			log.error("CourseManager#deleteCourseForUser: can't register course", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("CourseManager#deleteCourseForUser: can't close connection", e);
			}
		}
	}

	public void registerStudentForCourse(long userId, long courseId) {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			courseDaoImpl.registerStudentForCourse(conn, userId, courseId);
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

	public void setMarkForStudent(long userId, long courseId, int mark) {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			courseDaoImpl.setMarkForStudent(conn, userId, courseId, mark);
		} catch (DaoException e) {
			log.error("CourseManager#SetMark: can't set mark", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("CourseManager#SetMark: can't close connection", e);
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

	public boolean deleteCourseById(long id) {
		Connection conn = null;
		boolean result = false;
		try {
			conn = connectionPool.getConnection();
			courseDaoImpl.deleteById(conn, id);
			result = true;
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
		return result;
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

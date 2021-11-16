package com.java.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.DaoException;
import com.java.model.entity.Course;

public class CourseDaoImpl implements CourseDao {
	private static final Logger logger = LogManager.getLogger(CourseDaoImpl.class.getName());
	private static CourseDaoImpl instance;

	public static final String SQL_SELECT_ALL_COURSES = "SELECT * FROM COURSES";
	public static final String SQL_SELECT_COURSE = "SELECT * FROM COURSES WHERE id=?";
	public static final String SQL_DELETE_COURSE_BY_ID = "DELETE FROM COURSES WHERE id=?";
	public static final String SQL_UPDATE_COURSE_BY_ID = "UPDATE COURSES SET name=?,duration=?,start_date=?,end_date=?,topic_id=?,user_id=?  WHERE id=?";
	public static final String SQL_INSERT_COURSE = "INSERT INTO COURSES (name,duration,start_date,end_date,topic_id,user_id)values (?,?,?,?,?,?)";
	public static final String SQL_SELECT_STUDENT_COURSES = "SELECT * FROM courses WHERE id in \r\n"
			+ "(SELECT course_id FROM m2m_users_courses where user_id=?)";
	public static final String SQL_SELECT_TUTOR_COURSES = "SELECT * FROM courses WHERE user_id=?";

	public static final String SQL_INSERT_COURSE_FOR_USER = "insert into m2m_users_courses (user_id,course_id) values (?,?)";
	private static final String SQL_DELETE_COURSE_FOR_USER = "delete from m2m_users_courses where (user_id=?)and(course_id=?)";

//	SELECT * from courses
//	where (user_id =2)and (topic_id=2) order by counter ASC
	private CourseDaoImpl() {
	}

	public static CourseDaoImpl getInstance() {
		if (instance == null) {
			instance = new CourseDaoImpl();
		}
		return instance;
	}

	@Override
	public List<Course> executeSqlQuery(Connection conn, String SQL) throws DaoException {
		List<Course> courses = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("id"));
				course.setName(rs.getString("name"));
				course.setStart_date(rs.getDate("start_date").toLocalDate());
				course.setEnd_date(rs.getDate("end_date").toLocalDate());
				course.setDuration(rs.getInt("duration"));
				course.setTopic_id(rs.getLong("topic_id"));
				course.setUser_id(rs.getLong("user_id"));
				course.setCounter(rs.getLong("counter"));
				courses.add(course);
			}
		} catch (SQLException e) {
			logger.fatal("CourseDao#findAll SQLException");
			throw new DaoException("CourseDao#findAll:can't execute findAll method", e);
		} finally {
			close(st);
			close(rs);
		}
		return courses;
	}

	@Override
	public List<Course> findAll(Connection conn) throws DaoException {
		List<Course> courses = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL_SELECT_ALL_COURSES);
			while (rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("id"));
				course.setName(rs.getString("name"));
				course.setStart_date(rs.getDate("start_date").toLocalDate());
				course.setEnd_date(rs.getDate("end_date").toLocalDate());
				course.setDuration(rs.getInt("duration"));
				course.setTopic_id(rs.getLong("topic_id"));
				course.setUser_id(rs.getLong("user_id"));
				course.setCounter(rs.getLong("counter"));
				courses.add(course);
			}
		} catch (SQLException e) {
			logger.fatal("CourseDao#findAll SQLException");
			throw new DaoException("CourseDao#findAll:can't execute findAll method", e);
		} finally {
			close(st);
			close(rs);
		}
		return courses;
	}

	@Override
	public Course findEntityById(Connection conn, Long id) throws DaoException {
		Course course = new Course();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_COURSE);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				course.setId(rs.getInt("id"));
				course.setName(rs.getString("name"));
				course.setStart_date(rs.getDate("start_date").toLocalDate());
				course.setEnd_date(rs.getDate("end_date").toLocalDate());
				course.setDuration(rs.getInt("duration"));
				course.setTopic_id(rs.getLong("topic_id"));
				course.setUser_id(rs.getLong("user_id"));
				course.setCounter(rs.getLong("counter"));
			}
		} catch (SQLException e) {
			logger.fatal("CourseDao#findEntity SQLException");
			throw new DaoException("CourseDao#can'course execute findEntity method", e);
		} finally {
			close(ps);
			close(rs);
		}
		return course;
	}

	@Override
	public Course findEntity(Connection conn, Course t) throws DaoException {
		return findEntityById(conn, t.getId());
	}

	@Override
	public void delete(Connection conn, Course t) throws DaoException {
		deleteById(conn, t.getId());
	}

	@Override
	public void deleteById(Connection conn, Long id) throws DaoException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_DELETE_COURSE_BY_ID);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("CourseDao#can't execute delete method", e);
		} finally {
			close(ps);
		}
	}

	@Override
	public void deleteCourseForUser(Connection conn, long userId, long courseId) throws DaoException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_DELETE_COURSE_FOR_USER);
			ps.setLong(1, userId);
			ps.setLong(2, courseId);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("CourseDao#deleteCourseForUser can't execute create method", e);
		} finally {
			close(rs);
			close(ps);
		}

	}

	@Override
	public void registerCourseForUser(Connection conn, long userId, long courseId) throws DaoException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_INSERT_COURSE_FOR_USER, Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, userId);
			ps.setLong(2, courseId);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				// Ключ нужен ?
				// t.setId(rs.getLong(1));
			}
		} catch (SQLException e) {
			throw new DaoException("CourseDao#can't execute create method", e);
		} finally {
			close(rs);
			close(ps);
		}
	}

	@Override
	public void create(Connection conn, Course t) throws DaoException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_INSERT_COURSE, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, t.getName());
			ps.setInt(2, t.getDuration());
			ps.setDate(3, DAOUtil.toSqlDate(t.getStart_date()));
			ps.setDate(4, DAOUtil.toSqlDate(t.getEnd_date()));
			ps.setLong(5, t.getTopic_id());
			ps.setLong(6, t.getUser_id());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				t.setId(rs.getLong(1));
			}
		} catch (SQLException e) {
			throw new DaoException("CourseDao#can't execute create method", e);
		} finally {
			close(rs);
			close(ps);
		}
	}

	@Override
	public void update(Connection conn, Course t) throws DaoException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_UPDATE_COURSE_BY_ID);
			ps.setString(1, t.getName());
			ps.setInt(2, t.getDuration());
			ps.setDate(3, DAOUtil.toSqlDate(t.getStart_date()));
			ps.setDate(4, DAOUtil.toSqlDate(t.getEnd_date()));
			ps.setLong(5, t.getTopic_id());
			ps.setLong(6, t.getUser_id());
			ps.setLong(7, t.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("CourseDao#can't execute update method", e);
		} finally {
			close(rs);
			close(ps);
		}
	}

	@Override
	public List<Course> findTutorCourses(Connection conn, long userId) throws DaoException {
		List<Course> userCourses = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_TUTOR_COURSES);
			ps.setLong(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("id"));
				course.setName(rs.getString("name"));
				course.setStart_date(rs.getDate("start_date").toLocalDate());
				course.setEnd_date(rs.getDate("end_date").toLocalDate());
				course.setDuration(rs.getInt("duration"));
				course.setTopic_id(rs.getLong("topic_id"));
				course.setUser_id(rs.getLong("user_id"));
				course.setCounter(rs.getLong("counter"));
				userCourses.add(course);
			}
		} catch (SQLException e) {
			logger.fatal("CourseDao#findTutorCourses SQLException");
			throw new DaoException("CourseDao#findTutorCourses:can't execute findTutorCourses method", e);
		} finally {
			close(ps);
			close(rs);
		}
		return userCourses;
	}

	@Override
	public List<Course> findStudentCourses(Connection conn, long userId) throws DaoException {
		List<Course> userCourses = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_STUDENT_COURSES);
			ps.setLong(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("id"));
				course.setName(rs.getString("name"));
				course.setStart_date(rs.getDate("start_date").toLocalDate());
				course.setEnd_date(rs.getDate("end_date").toLocalDate());
				course.setDuration(rs.getInt("duration"));
				course.setTopic_id(rs.getLong("topic_id"));
				course.setUser_id(rs.getLong("user_id"));
				course.setCounter(rs.getLong("counter"));
				userCourses.add(course);
			}
		} catch (SQLException e) {
			logger.fatal("CourseDao#findUserCourses SQLException");
			throw new DaoException("CourseDao#findUserCourses:can't execute findStudentCourses method", e);
		} finally {
			close(ps);
			close(rs);
		}
		return userCourses;
	}

}

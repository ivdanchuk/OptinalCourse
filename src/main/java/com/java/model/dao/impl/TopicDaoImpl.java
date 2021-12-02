package com.java.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.dao.TopicDao;
import com.java.model.entity.Topic;
import com.java.model.exception.DaoException;

public class TopicDaoImpl implements TopicDao {
	private static final Logger logger = LogManager.getLogger(TopicDao.class.getName());
	public static final String SQL_SELECT_ALL_TOPICS = "SELECT * FROM TOPICS";
	public static final String SQL_SELECT_TOPIC = "SELECT * FROM TOPICS WHERE id=?";
	public static final String SQL_DELETE_TOPIC_BY_ID = "DELETE FROM TOPICS WHERE id=?";
	public static final String SQL_UPDATE_TOPIC_BY_ID = "UPDATE TOPICS SET name=? WHERE id=?";
	public static final String SQL_INSERT_TOPIC = "INSERT INTO TOPICS (name) values (?)";

	private static TopicDaoImpl instance;

	private TopicDaoImpl() {
	}

	public static TopicDaoImpl getInstance() {
		if (instance == null) {
			instance = new TopicDaoImpl();
		}
		return instance;
	}

	@Override
	public List<Topic> findAll(Connection conn) throws DaoException {
		List<Topic> topics = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL_SELECT_ALL_TOPICS);
			while (rs.next()) {
				Topic topic = new Topic();
				topic.setId(rs.getInt("id"));
				topic.setName(rs.getString("name"));
				topics.add(topic);
			}
		} catch (SQLException e) {
			logger.fatal("UserDao#findAll SQLException");
			throw new DaoException("TopicDao#findAll:can't execute findAll method", e);
		} finally {
			close(st);
			close(rs);
		}
		return topics;
	}

	@Override
	public Topic findEntityById(Connection conn, Long id) throws DaoException {
		Topic topic = new Topic();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_TOPIC);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				topic.setId(rs.getLong("id"));
				topic.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			logger.fatal("TopicDao#findEntityById SQLException");
			throw new DaoException("TopicDao#findEntityById: can't execute findEntityById method", e);
		} finally {
			close(ps);
			close(rs);
		}
		return topic;
	}

	@Override
	public Topic findEntity(Connection conn, Topic t) throws DaoException {
		return findEntityById(conn, t.getId());
	}

	@Override
	public void deleteById(Connection conn, Long id) throws DaoException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_DELETE_TOPIC_BY_ID);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.fatal("UserDao#delete SQLException");
			throw new DaoException("TopicDao#can't execute delete method", e);
		} finally {
			close(ps);
		}
	}

	@Override
	public void delete(Connection conn, Topic t) throws DaoException {
		deleteById(conn, t.getId());
	}

	@Override
	public void create(Connection conn, Topic t) throws DaoException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_INSERT_TOPIC, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, t.getName());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				t.setId(rs.getLong(1));
			}
		} catch (SQLException e) {
			logger.fatal("UserDao#create SQLException");
			throw new DaoException("TopicDao#can't execute create method", e);
		} finally {
			close(rs);
			close(ps);
		}
	}

	@Override
	public void update(Connection conn, Topic t) throws DaoException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_UPDATE_TOPIC_BY_ID);
			ps.setString(1, t.getName());
			ps.setLong(2, t.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.fatal("UserDao#update SQLException");
			throw new DaoException("TopicDao#can't execute update method", e);
		} finally {
			close(rs);
			close(ps);
		}
	}
}

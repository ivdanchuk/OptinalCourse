package com.java.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.ConnectionPool;
import com.java.model.DaoException;
import com.java.model.dao.TopicDaoImpl;
import com.java.model.entity.Topic;

public class TopicManager {
	private static TopicManager instance;
	private final static Logger log = LogManager.getLogger(TopicManager.class);

	private ConnectionPool connectionPool;
	private TopicDaoImpl topicDaoImpl;

	private TopicManager() {
		connectionPool = ConnectionPool.getInstance();
		topicDaoImpl = TopicDaoImpl.getInstance();
	}

	public static synchronized TopicManager getInstance() {
		if (instance == null) {
			instance = new TopicManager();
		}
		return instance;
	}

	public List<Topic> listAllTopics() {
		Connection conn = null;
		List<Topic> topics = new ArrayList<>();
		try {
			conn = connectionPool.getConnection();
			topics = topicDaoImpl.findAll(conn);
		} catch (DaoException e) {
			log.error("TopicManager#listAllTopics: can't list topics");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("TopicManager#listAllTopics: can't close connection");
			}
		}
		return topics;
	}

	public void CreateTopic(Topic topic) {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			topicDaoImpl.create(conn, topic);
		} catch (DaoException e) {
			log.error("TopicManager#CreateTopic: can't create topic", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("TopicManager#CreateTopic: can't close connection", e);
			}
		}
	}

	public void UpdateTopic(Topic topic) {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			topicDaoImpl.update(conn, topic);
		} catch (DaoException e) {
			log.error("TopicManager#UpdateTopic: can't update topic", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("TopicManager#UpdateTopic: can't close connection", e);
			}
		}
	}

	public void DeleteTopic(long id) {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			topicDaoImpl.deleteById(conn, id);
		} catch (DaoException e) {
			log.error("TopicManager#DeleteTopic: can't delete topic", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("TopicManager#DeleteTopic: can't close connection", e);
			}
		}
	}

	public Topic FindTopicById(long id) {
		Topic topic = new Topic();
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			topic = topicDaoImpl.findEntityById(conn, id);
		} catch (DaoException e) {
			log.error("TopicManager#FindTopicById: can't find topic", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("TopicManager#FindTopicById: can't close connection", e);
			}
		}
		return topic;
	}
}

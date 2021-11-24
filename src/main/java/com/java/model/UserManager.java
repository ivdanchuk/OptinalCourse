package com.java.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.dao.UserDaoImpl;
import com.java.model.entity.User;

public class UserManager {
	private static UserManager instance;
	private final static Logger log = LogManager.getLogger(UserManager.class);

	private ConnectionPool connectionPool;
	private UserDaoImpl userDaoImpl;

	private UserManager() {
		connectionPool = ConnectionPool.getInstance();
		userDaoImpl = UserDaoImpl.getInstance();
	}

	public static synchronized UserManager getInstance() {
		if (instance == null) {
			instance = new UserManager();
		}
		return instance;
	}

	public List<User> listAllUsersByRoleID(long roleId) {
		Connection conn = null;
		List<User> users = new ArrayList<>();
		try {
			conn = connectionPool.getConnection();
			users = userDaoImpl.findUsersByRoleId(conn, roleId);
		} catch (DaoException e) {
			log.error("UserManager#listAllUsers: can't list users");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("UserManager#listAllUsers: can't close connection");
			}
		}
		return users;
	}

	public List<User> listAllUsersFromTo(long from, long to) {
		Connection conn = null;
		List<User> users = new ArrayList<>();
		try {
			conn = connectionPool.getConnection();
			users = userDaoImpl.findAllFromTo(conn, from, to);
		} catch (DaoException e) {
			log.error("UserManager#listAllUsersFromTo: can't list users");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("UserManager#listAllUsersFromTo: can't close connection");
			}
		}
		return users;
	}

	public List<User> listAllUsers() {
		Connection conn = null;
		List<User> users = new ArrayList<>();
		try {
			conn = connectionPool.getConnection();
			users = userDaoImpl.findAll(conn);
		} catch (DaoException e) {
			log.error("UserManager#listAllUsers: can't list users");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("UserManager#listAllUsers: can't close connection");
			}
		}
		return users;
	}

	public void CreateUser(User user) {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			userDaoImpl.create(conn, user);
		} catch (DaoException e) {
			log.error("UserManager#CreateUser: can't create user", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("UserManager#CreateUser: can't close connection", e);
			}
		}
	}

	public void UpdateUser(User user) {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			userDaoImpl.update(conn, user);
		} catch (DaoException e) {
			log.error("UserManager#UpdateUser: can't update user", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("UserManager#UpdateUser: can't close connection", e);
			}
		}
	}

	public void DeleteUser(long id) {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			userDaoImpl.deleteById(conn, id);
		} catch (DaoException e) {
			log.error("UserManager#DeleteUser: can't delete user", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("UserManager#DeleteUser: can't close connection", e);
			}
		}
	}

	public User FindUserByEmail(String email) {
		User user = new User();
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			user = userDaoImpl.findUserByEmail(conn, email);
		} catch (DaoException e) {
			log.error("UserManager#FindUserByEmail: can't find user", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("UserManager#FindUserById: can't close connection", e);
			}
		}
		return user;
	}

	public User FindUserById(long id) {
		User user = new User();
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			user = userDaoImpl.findEntityById(conn, id);
		} catch (DaoException e) {
			log.error("UserManager#FindUserById: can't find user", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("UserManager#FindUserById: can't close connection", e);
			}
		}
		return user;
	}
}

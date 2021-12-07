package com.java.model.dao.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.dao.impl.UserDaoImpl;
import com.java.model.db.ConnectionPool;
import com.java.model.entity.User;
import com.java.model.exception.DaoException;

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

	public Long RowCount() {
		Long rowCount = 0l;
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			rowCount = userDaoImpl.getRowCount(conn);
		} catch (DaoException e) {
			log.error("UserManager#RowCount: can't get row count");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("UserManager#RowCount: can't get row count");
			}
		}
		return rowCount;
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

	public boolean UpdateUser(User user) {
		Connection conn = null;
		boolean result = false;
		try {
			conn = connectionPool.getConnection();
			userDaoImpl.update(conn, user);
			result = true;
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
		return result;
	}

	public boolean DeleteUser(long id) {
		Connection conn = null;
		boolean result = false;
		try {
			conn = connectionPool.getConnection();
			userDaoImpl.deleteById(conn, id);
			result = true;
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
		return result;
	}

	public User findUserByEmail(String email) {
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

	public List<User> findUserByEmailLike(String email) {
		List<User> users = new ArrayList<>();
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			users = userDaoImpl.findUserByEmailLike(conn, email);
		} catch (DaoException e) {
			log.error("UserManager#FindUserByEmailLike: can't find user", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("UserManager#FindUserByIdLike: can't close connection", e);
			}
		}
		return users;
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

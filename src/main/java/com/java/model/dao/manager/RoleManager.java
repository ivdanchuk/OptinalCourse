package com.java.model.dao.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.dao.impl.RoleDaoImpl;
import com.java.model.db.ConnectionPool;
import com.java.model.entity.Role;
import com.java.model.exception.DaoException;

public class RoleManager {
	private static RoleManager instance;
	private final static Logger log = LogManager.getLogger(RoleManager.class);

	private ConnectionPool connectionPool;
	private RoleDaoImpl roleDaoImpl;

	private RoleManager() {
		connectionPool = ConnectionPool.getInstance();
		roleDaoImpl = RoleDaoImpl.getInstance();
	}

	public static synchronized RoleManager getInstance() {
		if (instance == null) {
			instance = new RoleManager();
		}
		return instance;
	}

	public List<Role> listAllRoles() {
		Connection conn = null;
		List<Role> topics = new ArrayList<>();
		try {
			conn = connectionPool.getConnection();
			topics = roleDaoImpl.findAll(conn);
		} catch (DaoException e) {
			log.error("RoleManager#listAllRoles: can't list topics");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("RoleManager#listAllRoles: can't close connection");
			}
		}
		return topics;
	}

	public void CreateRole(Role topic) {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			roleDaoImpl.create(conn, topic);
		} catch (DaoException e) {
			log.error("RoleManager#CreateRole: can't create topic", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("RoleManager#CreateRole: can't close connection", e);
			}
		}
	}

	public void UpdateRole(Role topic) {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			roleDaoImpl.update(conn, topic);
		} catch (DaoException e) {
			log.error("RoleManager#UpdateRole: can't update topic", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("RoleManager#UpdateRole: can't close connection", e);
			}
		}
	}

	public void DeleteRole(long id) {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			roleDaoImpl.deleteById(conn, id);
		} catch (DaoException e) {
			log.error("RoleManager#DeleteRole: can't delete topic", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("RoleManager#DeleteRole: can't close connection", e);
			}
		}
	}

	public Role FindRoleById(long id) {
		Role role = new Role();
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
			role = roleDaoImpl.findEntityById(conn, id);
		} catch (DaoException e) {
			log.error("RoleManager#FindRoleById: can't find topic", e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error("RoleManager#FindRoleById: can't close connection", e);
			}
		}
		return role;
	}
}

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
import com.java.model.entity.Role;

public class RoleDaoImpl implements RoleDao {
	private static final Logger logger = LogManager.getLogger(RoleDao.class.getName());
	public static final String SQL_SELECT_ALL_ROLES = "SELECT * FROM ROLES";
	public static final String SQL_SELECT_ROLE = "SELECT * FROM ROLES WHERE id=?";
	public static final String SQL_DELETE_ROLE_BY_ID = "DELETE FROM ROLES WHERE id=?";
	public static final String SQL_UPDATE_ROLE_BY_ID = "UPDATE ROLES SET name=? WHERE id=?";
	public static final String SQL_INSERT_ROLE = "INSERT INTO ROLES (name) values (?)";
	private static RoleDaoImpl instance;

	private RoleDaoImpl() {
	}

	public static RoleDaoImpl getInstance() {
		if (instance == null) {
			instance = new RoleDaoImpl();
		}
		return instance;
	}

	@Override
	public List<Role> findAll(Connection conn) throws DaoException {
		List<Role> roles = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL_SELECT_ALL_ROLES);
			while (rs.next()) {
				Role role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				roles.add(role);
			}
		} catch (SQLException e) {
			logger.fatal("RoleDao#findAll SQLException");
			throw new DaoException("RoleDao#findAll:can't execute findAll method", e);
		} finally {
			close(st);
			close(rs);
		}
		return roles;
	}

	@Override
	public Role findEntityById(Connection conn, Long id) throws DaoException {
		Role role = new Role();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_ROLE);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				role.setId(rs.getLong("id"));
				role.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			logger.fatal("RoleDao#findEntityById SQLException");
			throw new DaoException("RoleDao#findEntityById: can't execute findEntityById method", e);
		} finally {
			close(ps);
			close(rs);
		}
		return role;
	}

	@Override
	public Role findEntity(Connection conn, Role t) throws DaoException {
		return findEntityById(conn, t.getId());
	}

	@Override
	public void deleteById(Connection conn, Long id) throws DaoException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_DELETE_ROLE_BY_ID);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.fatal("RoleDao#delete SQLException");
			throw new DaoException("RoleDao#can't execute delete method", e);
		} finally {
			close(ps);
		}
	}

	@Override
	public void delete(Connection conn, Role t) throws DaoException {
		deleteById(conn, t.getId());
	}

	@Override
	public void create(Connection conn, Role t) throws DaoException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_INSERT_ROLE, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, t.getName());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				t.setId(rs.getLong(1));
			}
		} catch (SQLException e) {
			logger.fatal("RoleDao#create SQLException");
			throw new DaoException("RoleDao#can't execute create method", e);
		} finally {
			close(rs);
			close(ps);
		}
	}

	@Override
	public void update(Connection conn, Role t) throws DaoException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_UPDATE_ROLE_BY_ID);
			ps.setString(1, t.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.fatal("RoleDao#update SQLException");
			throw new DaoException("RoleDao#can't execute update method", e);
		} finally {
			close(rs);
			close(ps);
		}
	}
}

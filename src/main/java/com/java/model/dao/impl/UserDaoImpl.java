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

import com.java.model.dao.UserDao;
import com.java.model.entity.User;
import com.java.model.exception.DaoException;

public class UserDaoImpl implements UserDao {
	private static UserDaoImpl instance;
	private static final Logger logger = LogManager.getLogger(UserDaoImpl.class.getName());
	public static final String SQL_SELECT_USERS_BY_ROLE_ID = "SELECT * FROM users where role_id=?";
	public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM USERS";
	public static final String SQL_SELECT_LIMIT_USERS = "SELECT * FROM USERS LIMIT ?,?";

	public static final String SQL_SELECT_USER_BY_EMAIL = "SELECT * FROM USERS WHERE email=?";
	public static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM USERS WHERE id=?";
	public static final String SQL_DELETE_USER_BY_ID = "DELETE FROM USERS WHERE id=?";
	public static final String SQL_UPDATE_USER_BY_ID = "UPDATE USERS SET f_name=?,l_name=?,email=?,password=?,role_id=?  WHERE id=?";
	public static final String SQL_INSERT_USER = "INSERT INTO USERS (f_name,l_name,email,password,role_id)values (?,?,?,?,?)";
	public static final String SQL_GET_ROWCOUNT = "SELECT COUNT(*) FROM users;";

	private UserDaoImpl() {
	}

	public static UserDaoImpl getInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}

	@Override
	public Long getRowCount(Connection conn) throws DaoException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Long rowCount = 0l;
		try {
			ps = conn.prepareStatement(SQL_GET_ROWCOUNT);
			rs = ps.executeQuery();
			if (rs.next()) {
				rowCount = rs.getLong(1);
			}
		} catch (SQLException e) {
			logger.fatal("UserDao#getRowCount SQLException");
			throw new DaoException("UserDao#RowCount:can't execute RowCount method", e);
		} finally {
			close(ps);
			close(rs);
		}
		return rowCount;
	}

	@Override
	public List<User> findAllFromTo(Connection conn, long from, long to) throws DaoException {
		List<User> users = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_LIMIT_USERS);
			ps.setLong(1, from);
			ps.setLong(2, to);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setF_name(rs.getString("f_name"));
				user.setL_name(rs.getString("l_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole_id(rs.getLong("role_id"));
				users.add(user);
			}
		} catch (SQLException e) {
			logger.fatal("UserDao#findAll SQLException");
			throw new DaoException("UserDao#findAll:can't execute findAll method", e);
		} finally {
			close(ps);
			close(rs);
		}
		return users;
	}

	@Override
	public List<User> findAll(Connection conn) throws DaoException {
		List<User> users = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL_SELECT_ALL_USERS);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setF_name(rs.getString("f_name"));
				user.setL_name(rs.getString("l_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole_id(rs.getLong("role_id"));
				users.add(user);
			}
		} catch (SQLException e) {
			logger.fatal("UserDao#findAll SQLException");
			throw new DaoException("UserDao#findAll:can't execute findAll method", e);
		} finally {
			close(st);
			close(rs);
		}
		return users;
	}

	@Override
	public List<User> findUsersByRoleId(Connection conn, Long roleId) throws DaoException {
		List<User> users = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_USERS_BY_ROLE_ID);
			ps.setLong(1, roleId);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setF_name(rs.getString("f_name"));
				user.setL_name(rs.getString("l_name"));
				user.setEmail(rs.getString("email"));
				// user.setPassword(rs.getString("password"));
				user.setRole_id(rs.getLong("role_id"));
				users.add(user);
			}
		} catch (SQLException e) {
			logger.fatal("UserDao#findUsersByRoleId SQLException");
			throw new DaoException("UserDao#can't execute findUsersByRoleId method", e);
		} finally {
			close(ps);
			close(rs);
		}
		return users;
	}

	@Override
	public User findUserByEmail(Connection conn, String email) throws DaoException {
		User user = new User();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_USER_BY_EMAIL);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getLong("id"));
				user.setF_name(rs.getString("f_name"));
				user.setL_name(rs.getString("l_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole_id(rs.getLong("role_id"));
			}
		} catch (SQLException e) {
			logger.fatal("UserDao#findUserByEmail SQLException");
			throw new DaoException("UserDao#can't execute findUserByEmail method", e);
		} finally {
			close(ps);
			close(rs);
		}
		return user;
	}

	@Override
	public User findEntityById(Connection conn, Long id) throws DaoException {
		User user = new User();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_USER_BY_ID);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getLong("id"));
				user.setF_name(rs.getString("f_name"));
				user.setL_name(rs.getString("l_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole_id(rs.getLong("role_id"));
			}
		} catch (SQLException e) {
			logger.fatal("UserDao#findEntityById SQLException");
			throw new DaoException("UserDao#can't execute findEntityById method", e);
		} finally {
			close(ps);
			close(rs);
		}
		return user;
	}

	@Override
	public User findEntity(Connection conn, User t) throws DaoException {
		return findEntityById(conn, t.getId());
	}

	@Override
	public void delete(Connection conn, User t) throws DaoException {
		long id = t.getId();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_DELETE_USER_BY_ID);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("UserDao#can't execute delete method", e);
		} finally {
			close(ps);
		}
	}

	@Override
	public void deleteById(Connection conn, Long id) throws DaoException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_DELETE_USER_BY_ID);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("UserDao#can't execute deleteById method", e);
		} finally {
			close(ps);
		}
	}

	@Override
	public void create(Connection conn, User t) throws DaoException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, t.getF_name());
			ps.setString(2, t.getL_name());
			ps.setString(3, t.getEmail());
			ps.setString(4, t.getPassword());
			ps.setLong(5, t.getRole_id());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				t.setId(rs.getLong(1));
			}
		} catch (SQLException e) {
			throw new DaoException("UserDao#can't execute create method", e);
		} finally {
			close(rs);
			close(ps);
		}
	}

	@Override
	public void update(Connection conn, User t) throws DaoException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_UPDATE_USER_BY_ID);
			ps.setString(1, t.getF_name());
			ps.setString(2, t.getL_name());
			ps.setString(3, t.getEmail());
			ps.setString(4, t.getPassword());
			ps.setLong(5, t.getRole_id());
			ps.setLong(6, t.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("UserDao#can't execute update method", e);
		} finally {
			close(rs);
			close(ps);
		}
	}

}

package com.java.model.dao;

import java.sql.Connection;
import java.util.List;

import com.java.model.entity.User;
import com.java.model.exception.DaoException;

public interface UserDao extends BaseDao<Long, User> {

	List<User> findUsersByRoleId(Connection conn, Long roleId) throws DaoException;

	List<User> findAllFromTo(Connection conn, long from, long to) throws DaoException;

	User findUserByEmail(Connection conn, String email) throws DaoException;

	Long getRowCount(Connection conn) throws DaoException;

	List<User> findUserByEmailLike(Connection conn, String emailLike) throws DaoException;

}

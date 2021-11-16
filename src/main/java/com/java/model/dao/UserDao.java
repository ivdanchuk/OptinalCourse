package com.java.model.dao;

import java.sql.Connection;
import java.util.List;

import com.java.model.DaoException;
import com.java.model.entity.User;

public interface UserDao extends BaseDao<Long, User> {

	List<User> findUsersByRoleId(Connection conn, Long roleId) throws DaoException;
}

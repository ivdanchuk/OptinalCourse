package com.java.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.java.model.entity.Entity;
import com.java.model.exception.DaoException;

public interface BaseDao<K, T extends Entity> {
	List<T> findAll(Connection conn) throws DaoException;

	T findEntityById(Connection conn, K id) throws DaoException;;

	T findEntity(Connection conn, T t) throws DaoException;;

	void delete(Connection conn, T t) throws DaoException;

	void deleteById(Connection conn, K id) throws DaoException;

	void create(Connection conn, T t) throws DaoException;

	void update(Connection conn, T t) throws DaoException;

	default void close(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			System.out.println("Logger: can't close sql statement");
		}
	}

	default void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("Logger: can't close sql resultset");
		}
	}

}

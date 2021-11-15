package com.java.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {
	private static DataSource ds;
	private static ConnectionPool instance;

	private ConnectionPool() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/db_a");
		} catch (NamingException e) {
			throw new IllegalStateException("ConnectionPool#ConnectionPool:can't initialize DataSource", e);
		}

	}

	public static synchronized ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new IllegalStateException("ConnectionPool#getConnection: can't get connection", e);
		}
		return conn;
	}
}

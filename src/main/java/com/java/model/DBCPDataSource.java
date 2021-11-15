package com.java.model;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBCPDataSource {

	private static BasicDataSource ds = new BasicDataSource();

	private DBCPDataSource() {
	}

	static {
//		Properties props = new Properties();
//		InputStream inputStream;
//		try {
//			inputStream = new FileInputStream("app.properties");
//			props.load(inputStream);
//		} catch (IOException e) {
//			System.out.println("Property file not found");
//		}
//		ds.setUrl(props.getProperty("connection.url"));
//		ds.setUsername(props.getProperty("user"));
//		ds.setPassword(props.getProperty("password"));

		ds.setUrl("jdbc:mysql://localhost:3306/db_a");
		ds.setUsername("user");
		ds.setPassword("123");
		ds.setMinIdle(5);
		ds.setMaxIdle(10);
		ds.setMaxOpenPreparedStatements(100);
	}

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return ds.getConnection();
		} catch (SQLException | ClassNotFoundException e) {
			throw new IllegalStateException("Can't initialize connection", e);
		}
	}
}

package com.java.model.dao.impl;

import java.time.LocalDate;

public class DAOUtil {

	public static java.sql.Date toSqlDate(LocalDate date) {
		if (date == null) {
			return null;
		}
		return java.sql.Date.valueOf(date);
	}
}

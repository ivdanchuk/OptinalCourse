package com.java.model.config;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigurationManager {
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config", Locale.ROOT);

	// класс извлекает информацию из файла config.properties
	private ConfigurationManager() {
	}

	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}

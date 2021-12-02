package com.java.model.config;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManager {
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", Locale.ROOT);

	private MessageManager() {
	}

	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}

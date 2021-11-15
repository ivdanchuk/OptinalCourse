package com.java.logic.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.controller.WebController;

public class ActionFactory {
	private static final Logger Log = LogManager.getLogger(WebController.class);

	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand();
		String command = request.getParameter("command");
		Log.debug("ActionFactory: command is " + command);

		if (command == null || command.isEmpty()) {
			return current;
		}

		try {
			CommandEnum currentEnum = CommandEnum.valueOf(command.toUpperCase());
			current = currentEnum.getCurrentCommand();
			Log.debug("ActionFactory: command object is " + current);
		} catch (IllegalArgumentException e) {
			Log.error("ActionFactory: IllegalArgumentException with " + current, e);
			request.setAttribute("wrongAction", command + MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}
}
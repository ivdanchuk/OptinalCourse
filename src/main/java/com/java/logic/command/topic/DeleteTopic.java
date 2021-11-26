package com.java.logic.command.topic;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.constant.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.TopicManager;
import com.java.model.UserManager;

public class DeleteTopic implements ActionCommand {
	private final static Logger log = LogManager.getLogger(UserManager.class);
	private static final String PARAM_NAME_ID = "id";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		Long id = Long.parseLong(request.getParameter(PARAM_NAME_ID));
		TopicManager.getInstance().DeleteTopic(id);
		page = Path.COMMAND__READ_TOPICS;

		return page;
	}

}

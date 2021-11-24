package com.java.logic.command.topic;

import javax.servlet.http.HttpServletRequest;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.TopicManager;

public class ReadTopic implements ActionCommand {
	private static final String PARAM_NAME_ID = "id";

	@Override
	public String execute(HttpServletRequest request) {
		String id = request.getParameter(PARAM_NAME_ID);
		request.setAttribute("command", "update_topic");
		request.setAttribute("topic", TopicManager.getInstance().FindTopicById(Long.parseLong(id)));
		return Path.PAGE__TOPIC;
	}

}

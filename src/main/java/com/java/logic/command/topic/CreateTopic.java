package com.java.logic.command.topic;

import javax.servlet.http.HttpServletRequest;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.TopicManager;
import com.java.model.entity.Topic;

public class CreateTopic implements ActionCommand {
	private static final String PARAM_NAME_ID = "id";
	private static final String PARAM_NAME_NAME = "name";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String name = request.getParameter(PARAM_NAME_NAME);
		Topic topic = new Topic(-1l, name);
		TopicManager.getInstance().CreateTopic(topic);
		page = Path.COMMAND__READ_TOPICS;
		return page;
	}
}

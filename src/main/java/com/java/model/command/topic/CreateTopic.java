package com.java.model.command.topic;

import javax.servlet.http.HttpServletRequest;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.dao.manager.TopicManager;
import com.java.model.entity.Topic;
import com.java.model.service.SessionService;

public class CreateTopic implements IActionCommand {
	private static final String PARAM_NAME_ID = "id";
	private static final String PARAM_NAME_NAME = "name";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String name = request.getParameter(PARAM_NAME_NAME);
		Topic topic = new Topic(-1l, name);
		TopicManager.getInstance().CreateTopic(topic);
		page = Path.COMMAND__READ_TOPICS;

		SessionService.setTopics(request);
		return page;
	}
}

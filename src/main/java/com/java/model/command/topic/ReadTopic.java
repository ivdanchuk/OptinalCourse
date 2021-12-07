package com.java.model.command.topic;

import javax.servlet.http.HttpServletRequest;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.dao.manager.TopicManager;

public class ReadTopic implements IActionCommand {
	private static final String PARAM_NAME_ID = "id";

	@Override
	public String execute(HttpServletRequest request) {
		String id = request.getParameter(PARAM_NAME_ID);
		request.setAttribute("command", "update_topic");
		request.setAttribute("topic", TopicManager.getInstance().FindTopicById(Long.parseLong(id)));
		return Path.PAGE__TOPIC;
	}

}

package com.java.model.command.topic;

import javax.servlet.http.HttpServletRequest;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.dao.manager.TopicManager;
import com.java.model.entity.Topic;
import com.java.model.service.SessionService;

public class UpdateTopic implements IActionCommand {
	private static final String PARAM_NAME_ID = "id";
	private static final String PARAM_NAME_NAME = "name";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		Long id = Long.parseLong(request.getParameter(PARAM_NAME_ID));
		String name = request.getParameter(PARAM_NAME_NAME);
		Topic topic = new Topic(id, name);
		TopicManager.getInstance().UpdateTopic(topic);
		page = Path.COMMAND__READ_TOPICS;

//		if (LoginLogic.checkLogin(login, pass)) {
//			request.setAttribute("user", login);
//			page = ConfigurationManager.getProperty("path.page.main");
//		} else {
//			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
//			page = ConfigurationManager.getProperty("path.page.login");
//		}
		SessionService.setTopics(request);
		return page;
	}
}

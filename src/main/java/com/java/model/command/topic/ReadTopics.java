package com.java.model.command.topic;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.service.SessionService;

public class ReadTopics implements IActionCommand {
	private final static Logger log = LogManager.getLogger(ReadTopics.class);

	@Override
	public String execute(HttpServletRequest request) {

		SessionService.setTopics(request);
//		log.debug("ReadTopics#execute " + topics);
		return Path.PAGE__TOPICS;
	}
}

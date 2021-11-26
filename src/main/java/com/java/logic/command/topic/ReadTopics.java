package com.java.logic.command.topic;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.constant.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.TopicManager;
import com.java.model.entity.Topic;

public class ReadTopics implements ActionCommand {
	private final static Logger log = LogManager.getLogger(ReadTopics.class);

	@Override
	public String execute(HttpServletRequest request) {
//		http://localhost:8080/w2/controller?command=read_topics
		List<Topic> topics = new ArrayList<>();
		topics = TopicManager.getInstance().listAllTopics();
		request.setAttribute("topics", topics);
		log.debug("ReadTopics#execute " + topics);
		return Path.PAGE__TOPICS;
	}
}

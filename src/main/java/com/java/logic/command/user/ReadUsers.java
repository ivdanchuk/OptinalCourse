package com.java.logic.command.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.constant.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.UserManager;
import com.java.model.entity.User;

public class ReadUsers implements ActionCommand {
	private final static Logger log = LogManager.getLogger(UserManager.class);

	@Override
	public String execute(HttpServletRequest request) {
		List<User> users = new ArrayList<>();
		users = UserManager.getInstance().listAllUsers();
		request.setAttribute("users", users);
		log.debug("ListUser#execute " + users);
		return Path.PAGE__USERS;
	}
}

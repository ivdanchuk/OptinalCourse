package com.java.logic.command.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.UserManager;
import com.java.model.entity.User;

public class ReadUsers2 implements ActionCommand {
	private final static Logger log = LogManager.getLogger(UserManager.class);

	@Override
	public String execute(HttpServletRequest request) {
		// !
		int rowsInTable = 12;
		int rowsOnPage = 5;
		int pages = rowsInTable / rowsOnPage;
		if ((rowsInTable % rowsOnPage) != 0) {
			pages++;
		}
		int pageNumber = 0;
		int selectTo = 0;
		int selectFrom = 0;

		String page = request.getParameter("page");
		if (page != null) {
			pageNumber = Integer.parseInt(page);
		} else {
			pageNumber = 1;
		}

		List<User> users = new ArrayList<>();
		if (pageNumber == 1) {
			selectFrom = pageNumber * rowsOnPage - rowsOnPage;
		} else {
			selectFrom = pageNumber * rowsOnPage - rowsOnPage - 1;
		}
		users = UserManager.getInstance().listAllUsersFromTo(selectFrom, rowsOnPage);
		// log.debug("ListUser#execute " + users);

		request.setAttribute("users", users);
		request.setAttribute("pages", pages);
		request.setAttribute("selectedPage", pageNumber);

		return Path.PAGE__USERS;
	}
}

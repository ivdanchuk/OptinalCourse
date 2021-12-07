package com.java.model.command.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.dao.manager.UserManager;
import com.java.model.entity.User;
import com.java.model.service.UserPaginationService;

public class ReadUsers implements IActionCommand {
	private final static Logger log = LogManager.getLogger(UserManager.class);

	@Override
	public String execute(HttpServletRequest request) {
		int totalPages = UserPaginationService.calculateTotalPages();
		int pageNumber = UserPaginationService.defineCurrentPageNumber(request, totalPages);

		int selectFrom = pageNumber * Path.ROWS_ON_PAGE - Path.ROWS_ON_PAGE;
		List<User> users = new ArrayList<>();
		users = UserManager.getInstance().listAllUsersFromTo(selectFrom, Path.ROWS_ON_PAGE);
		request.setAttribute("users", users);

		request.setAttribute("pages", totalPages);
		request.setAttribute("selectedPage", pageNumber);
		log.debug("ReadUsers#execute: " + "show page # " + pageNumber);

		return Path.PAGE__USERS;
	}
}

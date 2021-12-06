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

public class ReadUsers implements IActionCommand {
	private final static Logger log = LogManager.getLogger(UserManager.class);

	@Override
	public String execute(HttpServletRequest request) {
		long rowsInTable = UserManager.getInstance().RowCount();
		int rowsOnPage = Path.ROWS_ON_PAGE;
		long pages = rowsInTable / rowsOnPage;
		if ((rowsInTable % rowsOnPage) != 0) {
			pages++;
		}
		int pageNumber = 0;
		int selectTo = 0;
		int selectFrom = 0;

		String page = request.getParameter("page");
		if (page != null) {
			pageNumber = Integer.parseInt(page);
			request.getSession().setAttribute("UsersPageNum", pageNumber);
		} else {
			Integer pageInSession = (Integer) request.getSession().getAttribute("UsersPageNum");
			if (pageInSession != null) {
				pageNumber = pageInSession;
				if (pageNumber > pages) {
					pageNumber--;
				}
			} else {
				pageNumber = 1;
			}
		}

		selectFrom = pageNumber * rowsOnPage - rowsOnPage;
		List<User> users = new ArrayList<>();
		users = UserManager.getInstance().listAllUsersFromTo(selectFrom, rowsOnPage);
		request.setAttribute("users", users);

		request.setAttribute("pages", pages);
		request.setAttribute("selectedPage", pageNumber);
		// log.debug("ListUser#execute " + users);

		return Path.PAGE__USERS;
	}
}

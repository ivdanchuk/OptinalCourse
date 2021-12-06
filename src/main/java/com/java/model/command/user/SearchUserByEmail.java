package com.java.model.command.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.dao.manager.UserManager;
import com.java.model.entity.User;

public class SearchUserByEmail implements IActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String email = request.getParameter("email");

		List<User> users = new ArrayList<>();
		users = UserManager.getInstance().FindUserByEmailLike(email + "%");
		request.setAttribute("users", users);

		long rowsInTable = users.size();
		int rowsOnPage = Path.ROWS_ON_PAGE;

		long pages = rowsInTable / rowsOnPage;
		if ((rowsInTable % rowsOnPage) != 0) {
			pages++;
		}

		request.setAttribute("pages", pages);
		request.setAttribute("selectedPage", 1);

		return Path.PAGE__USERS;
	}
}

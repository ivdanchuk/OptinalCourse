package com.java.model.service;

import javax.servlet.http.HttpServletRequest;

import com.java.model.constant.Path;
import com.java.model.dao.manager.UserManager;

public class UserPaginationService {

	public static int calculateTotalPages() {
		long rowsInTable = UserManager.getInstance().RowCount();
		int rowsOnPage = Path.ROWS_ON_PAGE;
		int pages = (int) (rowsInTable / rowsOnPage);
		if ((rowsInTable % rowsOnPage) != 0) {
			pages++;
		}
		return pages;
	}

	public static int defineCurrentPageNumber(HttpServletRequest request, int totalPages) {
		int pageNumber = 0;
		String page = request.getParameter("page");
		if (page != null) {
			pageNumber = Integer.parseInt(page);
			request.getSession().setAttribute("UsersPageNum", pageNumber);
		} else {
			Integer pageInSession = (Integer) request.getSession().getAttribute("UsersPageNum");
			if (pageInSession != null) {
				pageNumber = pageInSession;
				if (pageNumber > totalPages) {
					pageNumber--;
				}
			} else {
				pageNumber = 1;
			}
		}
		return pageNumber;
	}
}

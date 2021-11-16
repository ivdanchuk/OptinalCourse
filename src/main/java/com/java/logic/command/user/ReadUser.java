package com.java.logic.command.user;

import javax.servlet.http.HttpServletRequest;

import com.java.controller.Path;
import com.java.logic.command.ActionCommand;
import com.java.model.RoleManager;
import com.java.model.UserManager;
import com.java.model.entity.Role;
import com.java.model.entity.User;

public class ReadUser implements ActionCommand {
	private static final String PARAM_NAME_ID = "userId";

	@Override
	public String execute(HttpServletRequest request) {
		// Click on user give us new user ID (selected id)
		String userId = request.getParameter(PARAM_NAME_ID);
		User selectedUser = (User) request.getSession().getAttribute("selectedUser");
		if (selectedUser == null) {
			selectedUser = UserManager.getInstance().FindUserById(Long.parseLong(userId));
		}
		Role role = RoleManager.getInstance().FindRoleById(selectedUser.getRole_id());
		request.getSession().setAttribute("currentRole", role);
		request.getSession().setAttribute("currentUser", selectedUser);
		return Path.PAGE__USER;
	}
}

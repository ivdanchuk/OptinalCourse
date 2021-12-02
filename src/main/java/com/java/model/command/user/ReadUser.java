package com.java.model.command.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.command.IActionCommand;
import com.java.model.constant.Path;
import com.java.model.constant.RoleConstant;
import com.java.model.dao.manager.RoleManager;
import com.java.model.dao.manager.UserManager;
import com.java.model.entity.Role;
import com.java.model.entity.User;
import com.java.model.filter.EncodingFilter;

public class ReadUser implements IActionCommand {
	private final static Logger log = LogManager.getLogger(EncodingFilter.class);
	private static final String PARAM_NAME_ID = "userIdForUpdate";

	@Override
	public String execute(HttpServletRequest request) {
		String path = Path.PAGE__ERROR_PAGE;
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		Role currentRole = (Role) request.getSession().getAttribute("currentRole");
		if ((currentUser == null) | (currentRole == null)) {
			String errorMessage = "Command#ReadUser: currentUser or currentRole is null !";
			log.error(errorMessage);
			return path;
		}

		path = Path.PAGE__USER;
		if (RoleConstant.ROLE_ADMIN_ID != currentRole.getId()) {
			currentUser = UserManager.getInstance().FindUserById(currentUser.getId());
			currentRole = RoleManager.getInstance().FindRoleById(currentUser.getRole_id());
			request.getSession().setAttribute("selectedUser", currentUser);
			request.getSession().setAttribute("selectedRole", currentRole);
		} else {
			String userIdForUpdate = request.getParameter(PARAM_NAME_ID);
			if (userIdForUpdate != null) {
				request.getSession().setAttribute("userIdForUpdate", userIdForUpdate);
			} else {
				userIdForUpdate = (String) request.getSession().getAttribute("userIdForUpdate");
			}
			User selectedUser = UserManager.getInstance().FindUserById(Long.parseLong(userIdForUpdate));
			Role selectedRole = RoleManager.getInstance().FindRoleById(selectedUser.getRole_id());
			request.getSession().setAttribute("selectedUser", selectedUser);
			request.getSession().setAttribute("selectedRole", selectedRole);
		}
		return path;
	}
}

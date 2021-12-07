package com.java.model.command;

import javax.servlet.http.HttpServletRequest;

public interface IActionCommand {
	String execute(HttpServletRequest request);
}

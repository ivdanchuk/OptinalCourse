package com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.model.command.ActionFactory;
import com.java.model.command.IActionCommand;
import com.java.model.config.ConfigurationManager;
import com.java.model.config.MessageManager;

@WebServlet("/controller")
public class WebController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger Log = LogManager.getLogger(WebController.class);

	public WebController() {
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String address = null;
		ActionFactory client = new ActionFactory();
		IActionCommand command = client.defineCommand(req);
		address = command.execute(req);
		Log.debug("WebController#doGet address:" + address);
		req.getRequestDispatcher(address).forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String address = null;
		ActionFactory client = new ActionFactory();
		IActionCommand command = client.defineCommand(req);
		address = command.execute(req);
		if (address != null) {
			Log.debug("WebController#doPost address:" + address);
			resp.sendRedirect(address);
		} else {
			Log.error("WebController#doPost address:" + " null !");
			address = ConfigurationManager.getProperty("path.page.index");
			req.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
			resp.sendRedirect(address);
		}
	}
}

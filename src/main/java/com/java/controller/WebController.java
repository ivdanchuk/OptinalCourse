package com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.config.ConfigurationManager;
import com.java.config.MessageManager;
import com.java.logic.command.ActionCommand;
import com.java.logic.command.ActionFactory;

@WebServlet("/controller")
public class WebController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger Log = LogManager.getLogger(WebController.class);

	public WebController() {
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String address = null;
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(req);
		// page = null; ?
		address = command.execute(req);
		Log.debug("WebController#doGet address:" + address);
		req.getRequestDispatcher(address).forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String address = null;
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(req);
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

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = null;
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);

		// page = null ?;
		page = command.execute(request);
		Log.debug("Controller#processRequest page:" + page);
//		return page;
		if (page != null) {
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
//			dispatcher.forward(request, response);
			request.getRequestDispatcher(page).forward(request, response);

		} else {
			page = ConfigurationManager.getProperty("path.page.index");
			request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
			response.sendRedirect(request.getContextPath() + page);
		}
	}
}

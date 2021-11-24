package com.java.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class ContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		String path = ctx.getRealPath("/WEB-INF/log4j2.log");
		System.setProperty("logFile", path);

		final Logger log = LogManager.getLogger(ContextListener.class);
		log.warn("log file path: = " + path);

		String localesValue = ctx.getInitParameter("locales");
		if (localesValue == null || localesValue.isEmpty()) {
			log.warn("'locales' init parameter is empty, the default encoding will be used");
		} else {
			List<String> locales = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(localesValue);
			while (st.hasMoreTokens()) {
				String localeName = st.nextToken();
				locales.add(localeName);
			}

			log.debug("Application attribute set: locales --> " + locales);
			ctx.setAttribute("locales", locales);
		}
	}
}

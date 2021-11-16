package com.java.logic;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter(urlPatterns = { "/*" }, initParams = { @WebInitParam(name = "encoding", value = "utf-8") })
public class EncodingFilter implements Filter {
	private final static Logger log = LogManager.getLogger(EncodingFilter.class);
	private String encoding;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String requestEncoding = request.getCharacterEncoding();

		if (requestEncoding == null) {
			log.trace("EncodingFilter#doFilter: request encoding is null, set encoding as: " + encoding);
			request.setCharacterEncoding(encoding);
		}

		// Set the default response content type and encoding
//        response.setContentType("text/html; charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");

		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) {
		encoding = config.getInitParameter("encoding");
		log.trace("EncodingFilter#init: encoding from initial parametr: " + encoding);
	}

	public void destroy() {
	}
}

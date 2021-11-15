package com.java.controller;

/**
 * Path holder (jsp pages, controller commands).
 * 
 * @author D.Kolesnikov
 * 
 */
public final class Path {

	// pages
	public static final String PAGE__LOGIN = "jsp/login.jsp";
	public static final String PAGE__MAIN = "jsp/main.jsp";

	// public static final String PAGE__ERROR_PAGE = "/WEB-INF/jsp/error_page.jsp";
//	public static final String PAGE__LIST_MENU = "/WEB-INF/jsp/client/list_menu.jsp";
//	public static final String PAGE__LIST_ORDERS = "/WEB-INF/jsp/admin/list_orders.jsp";
//	public static final String PAGE__SETTINGS = "/WEB-INF/jsp/settings.jsp";

	public static final String PAGE__USER = "jsp/user.jsp";
	public static final String PAGE__USERS = "jsp/users.jsp";

	public static final String PAGE__TOPIC = "jsp/topic.jsp";
	public static final String PAGE__TOPICS = "jsp/topics.jsp";

	public static final String PAGE__COURSE = "jsp/course.jsp";
	public static final String PAGE__COURSES = "jsp/courses.jsp";
	public static final String PAGE__USER_COURSES = "jsp/user_courses.jsp";
	public static final String PAGE__USER_REG_COURSE = "jsp/reg_course.jsp";

	// courses commands

	// public static final String COMMAND__READ_USER_COURSES =
	// "controller?command=read_courses";

	public static final String COMMAND__READ_COURSES = "controller?command=read_courses";
	public static final String COMMAND__READ_COURSE = "controller?command=read_course";
	public static final String COMMAND__UPDATE_COURSE = "controller?command=update_course";
	public static final String COMMAND__CREATE_COURSE = "controller?command=create_course";

	// topic commands
	public static final String COMMAND__READ_TOPICS = "controller?command=read_topics";
	public static final String COMMAND__READ_TOPIC = "controller?command=read_topic";
	public static final String COMMAND__UPDATE_TOPIC = "controller?command=update_topic";
	public static final String COMMAND__CREATE_TOPIC = "controller?command=create_topic";

	// user commands
	public static final String COMMAND__READ_USERS = "controller?command=read_users";
	public static final String COMMAND__READ_USER = "controller?command=read_user";
	public static final String COMMAND__UPDATE_USER = "controller?command=update_user";
	public static final String COMMAND__CREATE_USER = "controller?command=create_user";

	// public static final String COMMAND__LIST_ORDERS =
	// "/controller?command=listOrders";
//	public static final String COMMAND__LIST_MENU = "/controller?command=listMenu";
}
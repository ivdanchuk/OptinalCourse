package com.java.controller;

/**
 * Path holder (jsp pages, controller commands).
 * 
 * @author D.Kolesnikov
 * 
 */
public final class Path {

	// pagesefe
	public static final String PAGE__LOGIN = "jsp/login.jsp";
	public static final String PAGE__MAIN = "jsp/main.jsp";

	public static final String PAGE__ERROR_PAGE = "/jsp/error.jsp";
//	public static final String PAGE__LIST_MENU = "/WEB-INF/jsp/client/list_menu.jsp";
//	public static final String PAGE__LIST_ORDERS = "/WEB-INF/jsp/admin/list_orders.jsp";
//	public static final String PAGE__SETTINGS = "/WEB-INF/jsp/settings.jsp";

	public static final String PAGE__USER = "jsp/user.jsp";
	public static final String PAGE__NEW_USER = "jsp/new_user.jsp";

	public static final String PAGE__USERS = "jsp/users.jsp";

	public static final String PAGE__TOPIC = "jsp/topic.jsp";
	public static final String PAGE__TOPICS = "jsp/topics.jsp";

	public static final String PAGE__COURSE = "jsp/course.jsp";
	public static final String PAGE__NEW_COURSE = "jsp/new_course.jsp";

	public static final String PAGE__COURSES = "jsp/courses.jsp";
	public static final String PAGE__REGISTER_TUTOR = "jsp/register_tutor.jsp";

	public static final String PAGE__USER_COURSES = "jsp/user_courses.jsp";
	public static final String PAGE__USER_REG_COURSE = "jsp/reg_course.jsp";
	public static final String PAGE___SET_MARK = "jsp/set_mark.jsp";

	// courses commands

	// course commands
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
	public static final String COMMAND__READ_USER = "controller?command=read_user";
	public static final String COMMAND__READ_USERS = "controller?command=read_users";
	public static final String COMMAND__READ_USER_COURSES = "controller?command=read_user_courses";
	public static final String COMMAND__REG_USER_FOR_COURSE = "";
	public static final String COMMAND__UNREG_USER_FOR_COURSE = "controller?command=unreg_user_for_course";

	public static final String COMMAND__UPDATE_USER = "controller?command=update_user";
	public static final String COMMAND__CREATE_USER = "controller?command=create_user";
	// ?
	public static final String COMMAND__SORT_COURSES = "controller?command=sort_courses";
	public static final String COMMAND__READ_USERS_OF_COURSE = "controller?command=read_users_of_course";
	public static final String COMMAND__SHOW_TUTOR_REG_FORM = "controller?command=show_tutor_reg_form";

	// public static final String COMMAND__LIST_MENU =
	// "/controller?command=listMenu";
}
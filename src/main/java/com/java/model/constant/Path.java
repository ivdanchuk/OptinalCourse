package com.java.model.constant;

public final class Path {

	public static final String LOCALE_NAME_RU = "ru";
	public static final String LOCALE_NAME_EN = "en";

	public static final String PAGE__LOGIN = "jsp/login.jsp";
	public static final String PAGE__MAIN = "jsp/main.jsp";

	public static final String PAGE__ERROR_PAGE = "jsp/error.jsp";

	public static final String PAGE__USER = "jsp/user.jsp";
	public static final String PAGE__NEW_USER = "jsp/new_user.jsp";
	public static final String PAGE__SIGNUP = "jsp/signup.jsp";

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
	public static final String COMMAND__READ_CURRENT_USER = "controller?command=read_current_user";
	public static final String COMMAND__READ_USER = "controller?command=read_user";
	public static final String COMMAND__READ_USERS = "controller?command=read_users";
	public static final String COMMAND__UPDATE_USER = "controller?command=update_user";
	public static final String COMMAND__CREATE_USER = "controller?command=create_user";

	// student
	public static final String COMMAND__READ_STUDENT_COURSES = "controller?command=read_student_courses";
	public static final String COMMAND__REG_USER_FOR_COURSE = "";
	public static final String COMMAND__UNREG_STUDENT_FOR_COURSE = "controller?command=unreg_student_for_course";

	//
	public static final String COMMAND__SORT_COURSES = "controller?command=sort_courses";
	public static final String COMMAND__READ_USERS_OF_COURSE = "controller?command=read_users_of_course";
	public static final String COMMAND__SHOW_TUTOR_REG_FORM = "controller?command=show_tutor_reg_form";
}
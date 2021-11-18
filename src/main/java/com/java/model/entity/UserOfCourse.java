package com.java.model.entity;

import java.time.LocalDate;

public class UserOfCourse {
	private long user_id;
	private long course_id;
	private int mark;
	private LocalDate reg_date;
	private String f_name;
	private String l_name;
	private String email;
	private long role_id;

	/**
	 * @return the f_name
	 */
	public String getF_name() {
		return f_name;
	}

	/**
	 * @param f_name the f_name to set
	 */
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	/**
	 * @return the l_name
	 */
	public String getL_name() {
		return l_name;
	}

	/**
	 * @param l_name the l_name to set
	 */
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the role_id
	 */
	public long getRole_id() {
		return role_id;
	}

	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}

	public UserOfCourse() {
	}

	public UserOfCourse(long user_id, long course_id, int mark, LocalDate reg_date) {
		this.user_id = user_id;
		this.course_id = course_id;
		this.mark = mark;
		this.reg_date = reg_date;
	}

	/**
	 * @return the user_id
	 */
	public long getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the course_id
	 */
	public long getCourse_id() {
		return course_id;
	}

	/**
	 * @param course_id the course_id to set
	 */
	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}

	/**
	 * @return the mark
	 */
	public int getMark() {
		return mark;
	}

	/**
	 * @param mark the mark to set
	 */
	public void setMark(int mark) {
		this.mark = mark;
	}

	/**
	 * @return the reg_date
	 */
	public LocalDate getReg_date() {
		return reg_date;
	}

	/**
	 * @param reg_date the reg_date to set
	 */
	public void setReg_date(LocalDate reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsersCourses [user_id=");
		builder.append(user_id);
		builder.append(", course_id=");
		builder.append(course_id);
		builder.append(", mark=");
		builder.append(mark);
		builder.append(", reg_date=");
		builder.append(reg_date);
		builder.append("]");
		return builder.toString();
	}
}

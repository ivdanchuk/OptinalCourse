package com.java.model.dto;

import java.time.LocalDate;

public class CourseOfStudent {
	private static final long serialVersionUID = 1L;
	// users
	private long id;
	private String name;
	private int duration;
	private LocalDate start_date;
	private LocalDate end_date;
	private long topic_id;
	private long user_id;
	private int counter;

	public CourseOfStudent() {
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the start_date
	 */
	public LocalDate getStart_date() {
		return start_date;
	}

	/**
	 * @param start_date the start_date to set
	 */
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	/**
	 * @return the end_date
	 */
	public LocalDate getEnd_date() {
		return end_date;
	}

	/**
	 * @param end_date the end_date to set
	 */
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	/**
	 * @return the topic_id
	 */
	public long getTopic_id() {
		return topic_id;
	}

	/**
	 * @param topic_id the topic_id to set
	 */
	public void setTopic_id(long topic_id) {
		this.topic_id = topic_id;
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
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * @param counter the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
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

	private int state;
	// m2m_users_courses
	private int mark;
	private LocalDate reg_date;
}

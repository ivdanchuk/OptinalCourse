package com.java.model.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Course extends Entity {
	private static final long serialVersionUID = 1L;
	private String name;
	private int duration;
	private LocalDate start_date;
	private LocalDate end_date;
	private long topic_id;
	private long user_id;
	private long counter;

	public Course(long id, String name, int duration, LocalDate start_date, LocalDate end_date, long topic_id,
			long user_id) {
		super(id);
		this.name = name;
		this.duration = duration;
		this.start_date = start_date;
		this.end_date = end_date;
		this.topic_id = topic_id;
		this.user_id = user_id;
//		this.count = count;
	}

	public Course() {
		super();
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
	 * @return the counter
	 */
	public long getCounter() {
		return counter;
	}

	/**
	 * @param counter the counter to set
	 */
	public void setCounter(long counter) {
		this.counter = counter;
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
	 * @param topic_id the topic_id to set
	 */
	public void setTopic_id(long topic_id) {
		this.topic_id = topic_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Course [name=");
		builder.append(name);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", start_date=");
		builder.append(start_date);
		builder.append(", end_date=");
		builder.append(end_date);
		builder.append(", topic_id=");
		builder.append(topic_id);
		builder.append(", user_id=");
		builder.append(user_id);
		builder.append(", id=");
		builder.append(id);
		builder.append(", count=");
		builder.append(counter);
		builder.append("]");
		return builder.toString();
	}
}

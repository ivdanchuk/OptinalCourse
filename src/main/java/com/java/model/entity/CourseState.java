package com.java.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class CourseState implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;

	public CourseState() {
	}

	public CourseState(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseState other = (CourseState) obj;
		return id == other.id && Objects.equals(name, other.name);
	}
}

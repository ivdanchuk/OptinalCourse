package com.java.model.entity;

import java.io.Serializable;
import java.util.Objects;

public abstract class Entity implements Serializable {
	private static final long serialVersionUID = 1L;
	protected long id;

	public Entity() {
	}

	public Entity(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		return id == other.id;
	}
}

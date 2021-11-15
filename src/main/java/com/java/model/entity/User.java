package com.java.model.entity;

import java.util.Objects;

public class User extends Entity {
	private static final long serialVersionUID = 1L;
	private String f_name;
	private String l_name;
	private String email;
	private String password;
	private long role_id;

	public User() {
	}

	public User(long id, String f_name, String l_name, String email, String password, long role_id) {
		super(id);
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
		this.password = password;
		this.role_id = role_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getRole_id() {
		return role_id;
	}

	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [f_name=");
		builder.append(f_name);
		builder.append(", l_name=");
		builder.append(l_name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", role_id=");
		builder.append(role_id);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(email, f_name, l_name);
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
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(f_name, other.f_name)
				&& Objects.equals(l_name, other.l_name);
	}

}

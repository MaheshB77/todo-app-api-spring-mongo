package com.todo.todoapi.common.beans;

import org.springframework.stereotype.Component;

import com.todo.todoapi.models.User;

@Component
public class UserWithToken {
	private User user;
	private String token;

	public UserWithToken() {
		super();
	}

	public UserWithToken(User user, String token) {
		super();
		this.user = user;
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "UserWithToken [user=" + user + ", token=" + token + "]";
	}
	

}

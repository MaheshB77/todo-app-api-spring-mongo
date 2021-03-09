package com.todo.todoapi.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
public class User {
	@Id
	@Field(name = "_id")
	private String id;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String password;
	private boolean isActive = true;
	private List<Todo> userTodos;

	public User() {
		super();
	}

	public User(String id, String userFirstName, String userLastName, String userEmail, String password,
			boolean isActive, List<Todo> userTodos) {
		super();
		this.id = id;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.password = password;
		this.isActive = isActive;
		this.userTodos = userTodos;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Todo> getUserTodos() {
		return userTodos;
	}

	public void setUserTodos(List<Todo> userTodos) {
		this.userTodos = userTodos;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userEmail=" + userEmail + ", password=" + password + ", isActive=" + isActive + ", userTodos="
				+ userTodos + "]";
	}
	
}

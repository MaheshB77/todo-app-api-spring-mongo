package com.todo.todoapi.models;

public class UserLoginModel {
	private String userEmail;
	private String password;
	public UserLoginModel() {
		super();
	}
	public UserLoginModel(String userEmail, String password) {
		super();
		this.userEmail = userEmail;
		this.password = password;
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
	@Override
	public String toString() {
		return "UserLoginModel [userEmail=" + userEmail + ", password=" + password + "]";
	}
	
	

}

package com.todo.todoapi.common.beans;

import org.springframework.stereotype.Component;

@Component
public class ResponseBean<T> {
	private boolean success;
	private String message;
	private T data;
	
	public ResponseBean() {
		super();
	}

	public ResponseBean(boolean success, String message, T data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}
}

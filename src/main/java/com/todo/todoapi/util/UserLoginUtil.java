package com.todo.todoapi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todo.todoapi.models.User;
import com.todo.todoapi.repositories.UserRepository;

@Component
public class UserLoginUtil {
	
	@Autowired
	private UserRepository userRepository;
	
	public User signIn(String userEmail, String password) {
		User user = userRepository.findByUserEmailAndPassword(userEmail, password);
		return user;
	}
}

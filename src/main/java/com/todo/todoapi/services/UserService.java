package com.todo.todoapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todoapi.models.User;
import com.todo.todoapi.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
//	public User addUser(User userToAdd) {
//		
//	}
}

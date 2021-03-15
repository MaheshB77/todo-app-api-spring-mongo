package com.todo.todoapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todoapi.models.Todo;
import com.todo.todoapi.models.User;
import com.todo.todoapi.repositories.UserRepository;

/**
 * @author mahesh
 *
 */
@Service
public class TodoService {
	@Autowired
	private UserRepository userRepository;

	/**
	 * @param userId
	 * @return List<Todo>
	 */
	public List<Todo> getAllTodos(String userId) {
		User user = userRepository.findById(userId).get();
		List<Todo> todos = user.getUserTodos();
		return todos;
	}

	/**
	 * @param userId
	 * @param userToBeUpdated
	 * @return User
	 */
	public User updateTodos(String userId, User userToBeUpdated) {
		User user = userRepository.findById(userId).get();
		user.setUserTodos(userToBeUpdated.getUserTodos());
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}

}

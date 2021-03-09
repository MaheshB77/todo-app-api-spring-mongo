package com.todo.todoapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todoapi.models.Todo;
import com.todo.todoapi.models.User;
import com.todo.todoapi.repositories.UserRepository;
import com.todo.todoapi.services.TodoService;

@RestController
@RequestMapping("/api/users/todos")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/{userId}")
	public ResponseEntity<List<Todo>> getAllTodos(@PathVariable(name = "userId") String userId) {
		User user = userRepository.findById(userId).get();
		List<Todo> todos = user.getUserTodos();
		return new ResponseEntity<List<Todo>>(todos, HttpStatus.OK);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<String> updateTodos(@PathVariable(name = "userId") String userId, @RequestBody User userToBeUpdated) {
		User user = userRepository.findById(userId).get();
		user.setUserTodos(userToBeUpdated.getUserTodos());
		userRepository.save(user);
		
		return new ResponseEntity<String>("Updated todos", HttpStatus.OK);
	}

}

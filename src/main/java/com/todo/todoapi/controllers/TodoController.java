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

	@GetMapping("/{userId}")
	public ResponseEntity<List<Todo>> getAllTodos(@PathVariable(name = "userId") String userId) {
		List<Todo> todos = this.todoService.getAllTodos(userId);
		return new ResponseEntity<List<Todo>>(todos, HttpStatus.OK);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<User> updateTodos(@PathVariable(name = "userId") String userId,
			@RequestBody User userToBeUpdated) {
		User updatedUser = this.todoService.updateTodos(userId, userToBeUpdated);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}

}

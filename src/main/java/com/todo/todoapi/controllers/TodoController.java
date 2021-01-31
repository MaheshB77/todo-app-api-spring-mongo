package com.todo.todoapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todoapi.models.Todo;
import com.todo.todoapi.services.TodoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {
	
	private final TodoService todoService;
	
	@Autowired
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping("/")
	public String home() {
		return "Home";
	}
	
//	Get all todos
	@GetMapping("/todos")
	public List<Todo> getAllTodos(){
		return this.todoService.getTodos();
	}
	
//	Get todo by todoId
	@GetMapping("/todos/{todoId}")
	public Optional<Todo> getTodo(@PathVariable("todoId") String todoId) {
		return this.todoService.getTodo(todoId);
	}
	
//	Add todo
	@PostMapping("/todos/add-todo")
	public Todo addTodo(@RequestBody Todo todo) {
		return this.todoService.addTodo(todo);
	}
	
//	Update todo
	@PutMapping("todos/{todoId}")
	public Todo updateTodo(@PathVariable("todoId") String todoId, @RequestBody Todo todo) throws Exception {
		return this.todoService.updateTodo(todoId, todo);
	}
	
//	Delete todo
	@DeleteMapping("/todos/{todoId}")
	public String deleteTodo(@PathVariable("todoId") String todoId) {
		return this.todoService.deleteTodo(todoId);
	}

}

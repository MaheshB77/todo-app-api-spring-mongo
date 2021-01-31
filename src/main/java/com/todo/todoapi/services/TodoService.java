package com.todo.todoapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todoapi.models.Todo;
import com.todo.todoapi.repositories.TodoRepository;

@Service
public class TodoService {
	
	private final TodoRepository todoRepository;

	@Autowired
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public List<Todo> getTodos(){
		List<Todo> todos = this.todoRepository.findAll();
		return todos;
	}
	
	public Optional<Todo> getTodo(String todoId) {
		Optional<Todo> todo = this.todoRepository.findById(todoId);
		return todo;
	}
	
	public Todo addTodo(Todo todo) {
		return this.todoRepository.save(todo);
	}
	
	public Todo updateTodo(String todoId, Todo todo) throws Exception {
		Todo todoToUpdate = this.todoRepository.findById(todoId).orElseThrow(() -> new Exception("Todo not found"));
		
		todoToUpdate.setTodoStatus(todo.getTodoStatus());
		todoToUpdate.setTodoTitle(todo.getTodoTitle());
		return this.todoRepository.save(todoToUpdate);
	}
	
	public String deleteTodo(String todoId) {
		this.todoRepository.deleteById(todoId);
		return "Deleted";
	}

}

package com.todo.todoapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.todo.todoapi.models.Todo;

public interface TodoRepository extends MongoRepository<Todo, String> {

}

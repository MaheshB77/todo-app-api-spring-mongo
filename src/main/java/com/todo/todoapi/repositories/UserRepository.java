package com.todo.todoapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.todo.todoapi.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	public User findByUserEmailAndPassword(String userEmail, String password);
}

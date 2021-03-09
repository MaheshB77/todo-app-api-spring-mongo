package com.todo.todoapi.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todoapi.common.beans.UserWithToken;
import com.todo.todoapi.common.service.TokenService;
import com.todo.todoapi.models.User;
import com.todo.todoapi.models.UserLoginModel;
import com.todo.todoapi.repositories.UserRepository;
import com.todo.todoapi.util.UserLoginUtil;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private UserLoginUtil userLoginUtil;

//	This end point is for testing purpose
	@GetMapping("/")
	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}

//	Create user and return that user along with jwt token
	@PostMapping("/")
	public ResponseEntity<UserWithToken> addUser(@RequestBody User userToAdd) {
//		Temp
		userToAdd.setId(UUID.randomUUID().toString());
		User newlyAddedUser = userRepository.save(userToAdd);
		
//		Generate a token
		String token = tokenService.generateTokenFromUserEmail(userToAdd.getUserEmail());
		
//		Wrapping newly created user and jwt token into an object
		UserWithToken userWithToken = new UserWithToken(newlyAddedUser, token);
		
		return new ResponseEntity<UserWithToken>(userWithToken, HttpStatus.OK);
	}

//	Do the login validation and return jwt token
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserLoginModel userLoginModel) {
//		Do validation
		User user = userLoginUtil.signIn(userLoginModel.getUserEmail(), userLoginModel.getPassword());
		
//		If user is validated then generate a token
		if(user != null) {
//			Generate token
			String jwtToken = tokenService.generateTokenFromUserEmail(userLoginModel.getUserEmail());
			return new ResponseEntity<String>(jwtToken, HttpStatus.OK);
		}

//		If user is not valid
		return new ResponseEntity<String>("Invalid email or password", HttpStatus.UNAUTHORIZED);
	}
}

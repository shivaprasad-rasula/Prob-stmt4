package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.ServerInfo;
import com.user.entity.User;
import com.user.service.UserService;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	UserService userService;
	
	/* dashboard user login */
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		return userService.login(user);
	}
	
	/*
	 *  creating the new user
	 */
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	/* find the all user */
	@GetMapping("/users")
	public List<User> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return users;
	}
	
	
	
}

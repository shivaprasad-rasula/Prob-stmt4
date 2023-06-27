package com.user.service;

import java.util.List;

import com.user.entity.User;

public interface UserService {

	String login(User user);

	User createUser(User user);

	List<User> getAllUsers();


}

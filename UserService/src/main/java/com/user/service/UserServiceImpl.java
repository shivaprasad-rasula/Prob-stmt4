package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public String login(User user) {
		String response ="";
		String username = user.getUsername();
		String password = user.getPassword();
		User findUserByuserNameAndpassword = userRepository.findUserByuserNameAndpassword(username,password);	
		if(findUserByuserNameAndpassword!=null) {
			response ="success";
		}else {
			response = "fail";
		}
		return response;
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}

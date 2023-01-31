package com.app.service;

import com.app.entity.User;

import java.util.List;

import com.app.dto.Login;


public interface UserService {

	public User newUser(User user);
	
	public boolean validateUser(Login login);
	
	public List<User> searchUser(String email);
}

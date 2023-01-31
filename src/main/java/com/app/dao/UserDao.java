package com.app.dao;

import java.util.List;

import com.app.dto.Login;
import com.app.entity.User;


public interface UserDao {
	
	public User newUser(User user);
	public User fetchUser(Login login);
	public List<User> searchUser(String email);
}

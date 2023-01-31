package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.dao.UserDao;
import com.app.dto.Login;
import com.app.entity.User;



@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao udao;

	
	@Override
	public User newUser(User user) {
		return udao.newUser(user);
	}

	@Override
	public boolean validateUser(Login login) {
		if(udao.fetchUser(login) != null)
			return true;
		return false;

	}
	
	@Override
	public List<User> searchUser(String email) {
		return udao.searchUser(email);
	}
}

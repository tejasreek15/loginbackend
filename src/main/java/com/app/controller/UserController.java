package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Login;
import com.app.entity.User;
import com.app.service.UserService;

@RestController
@CrossOrigin("https://tejasreefrontend11.azurewebsites.net")
public class UserController {

	@Autowired
	private UserService uService;
	
	@PostMapping("/user")
	public User newUser(@RequestBody User user)
	{
		return uService.newUser(user);
	}
	
	@PostMapping("/userlogin")
	public boolean userLogin(@RequestBody Login login) {
		boolean isValidUser = uService.validateUser(login);
		if(isValidUser)
			return true;
		return false;
	}
	
	@GetMapping("/searchuser/{email}")
	public List<User> searchUser(@PathVariable("email") String email) {
		return uService.searchUser(email);
	}
}

package com.cybage.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.app.entity.User;
import com.cybage.app.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;
	
	public User addUser(String name) {
		User newUser = new User();
		newUser.setName(name);
		return userRepository.save(newUser);
	}

	public List<User> findAllusers() {
		return userRepository.findAll();
	}

}

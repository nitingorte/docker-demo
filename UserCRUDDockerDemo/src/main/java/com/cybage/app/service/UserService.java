package com.cybage.app.service;

import com.cybage.app.entity.User;
import com.cybage.app.exception.RecordNotFoundException;
import com.cybage.app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User addUser(String name) {
		if(Objects.isNull(name) || name.isBlank() || name.isEmpty()){
			throw new RecordNotFoundException("username-not-present","username is null", HttpStatus.BAD_REQUEST);
		}
		User newUser = new User();
		newUser.setName(name);
		return userRepository.save(newUser);
	}

	public List<User> findAllusers() {
		return userRepository.findAll();
	}

	public User getByName(String name){
		User existingUser = userRepository.findUserByName(name);
		if(Objects.isNull(existingUser))
			throw new RecordNotFoundException("user-not-found","user not found with "+name,HttpStatus.NOT_FOUND);
		return existingUser;
	}

}

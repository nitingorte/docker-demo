package com.cybage.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.app.entity.User;
import com.cybage.app.service.UserService;

@RestController
public class UserController {

	@Autowired
	public UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<User> addUser(@RequestParam String name){
		return new ResponseEntity<>(userService.addUser(name), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAll(){
		return new ResponseEntity<List<User>>(userService.findAllusers(), HttpStatus.OK);
	}
}

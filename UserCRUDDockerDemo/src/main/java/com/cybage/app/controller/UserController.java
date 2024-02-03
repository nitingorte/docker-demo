package com.cybage.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cybage.app.entity.User;
import com.cybage.app.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<User> addUser(@RequestParam String name){
		return new ResponseEntity<>(userService.addUser(name), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAll(){
		return new ResponseEntity<>(userService.findAllusers(), HttpStatus.OK);
	}

	@GetMapping("/{name}")
	public ResponseEntity<User> getUserByName(@PathVariable String name){
		return new ResponseEntity<>(userService.getByName(name), HttpStatus.OK);
	}
}

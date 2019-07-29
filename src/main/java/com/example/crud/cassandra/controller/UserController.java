package com.example.crud.cassandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.cassandra.model.User;
import com.example.crud.cassandra.model.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public void getAllUsers() {
		List<User>  users = userRepository.findAll();
		users.stream().forEach(System.out::println);
	}
}

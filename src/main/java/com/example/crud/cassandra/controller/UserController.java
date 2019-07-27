package com.example.crud.cassandra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.cassandra.model.Users;
import com.example.crud.cassandra.model.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/addUsers")
	public void addUsers() {
		List<Users>  users = new ArrayList<Users>();
		users.add(new Users(1,"neha"));
		users.add(new Users(2,"maryam"));
		users.add(new Users(3,"ibrahim"));
		userRepository.saveAll(users);
	}
	
	@GetMapping("/users")
	public void getAllUsers() {
		List<Users>  users = userRepository.findAll();
		users.stream().forEach(System.out::println);
	}
}

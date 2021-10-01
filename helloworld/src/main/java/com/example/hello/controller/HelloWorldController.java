package com.example.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.request.UserRequest;
//import com.example.hello.models.User;
import com.example.hello.response.UserResponse;
import com.example.hello.service.UserService;

@RestController
@RequestMapping("/user")
public class HelloWorldController {
	
	@Autowired
	UserService userService;
	
	/*
	 * http://localhost:8080/user/say-hello
	 * 
	 * @GetMapping("/say-hello")
	public String sayHello() {
		return "Hello world";
	}
	 * 
	 */
	
	@PostMapping()
	public UserResponse saveUser(@RequestBody UserRequest userRequest) {
		return userService.saveUser(userRequest);
	}
	
	@GetMapping
	public List<UserResponse> getAllUsers(){
		return userService.getAllUsers();
	}

}

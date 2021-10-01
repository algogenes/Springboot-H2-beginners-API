package com.example.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//import com.example.hello.controller.List;
import com.example.hello.models.User;
import com.example.hello.repository.UserRepository;
import com.example.hello.request.UserRequest;
import com.example.hello.response.UserResponse;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public UserResponse saveUser(UserRequest userRequest) {
		User user = new User();
		user.setAge(userRequest.getAge());
		user.setName(userRequest.getName());
		
		User savedUser = userRepository.save(user);
		
		UserResponse userResponse = getUserResponse(savedUser);
		
		return userResponse;
	}

	private UserResponse getUserResponse(User savedUser) {
		UserResponse userResponse = new UserResponse();
		
		userResponse.setAge(savedUser.getAge());
		
		userResponse.setName(savedUser.getName());
		
		userResponse.setId(savedUser.getId());
		
		return userResponse;
	}

	public List<UserResponse> getAllUsers() {
		List<UserResponse> userResponseList = new ArrayList<>();
		List<User> allUsers = userRepository.findAll();
		allUsers.forEach(user -> {
			userResponseList.add(getUserResponse(user));
		});
		return userResponseList;
	}

}

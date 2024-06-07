package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public User saveUser(UserDto userDto) {
		User user =  modelMapper.map(userDto, User.class);
		return userRepository.save(user);
	}
	
	public List<User> getUsers(){
		 return userRepository.findAll();
	}
}

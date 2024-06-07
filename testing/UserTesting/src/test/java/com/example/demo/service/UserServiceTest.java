package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {

	  @Autowired
	    private UserService userService;

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private ModelMapper modelMapper;

	    private UserDto userDto;

	    @BeforeEach
	    void setUp() {
        userRepository.deleteAll();  // Clear the repository before each test

	    	User user = new User() ;
	    	user.setName("John Doe");;
	    	
	        userDto = new UserDto();
	        userDto.setName("John Doe");
	    }

	    @Test
	    void testSaveUser() {
	        User savedUser = userService.saveUser(userDto);

	        assertNotNull(savedUser.getId());  // Ensure the ID is generated
	        assertEquals(userDto.getName(), savedUser.getName());

	        // Verify the user is actually saved in the repository
	        User foundUser = userRepository.findById(savedUser.getId()).orElse(null);
	        assertNotNull(foundUser);  // Ensure the user is found
	        assertEquals(savedUser, foundUser);
	    }

	    @Test
	    void testGetUsers() {
	        User savedUser = userService.saveUser(userDto);

	        List<User> users = userService.getUsers();

	        assertEquals(1, users.size());
	        assertEquals(savedUser.getName(), users.get(0).getName());
	    }
	
}

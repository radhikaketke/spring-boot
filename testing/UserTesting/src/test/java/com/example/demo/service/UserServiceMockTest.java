package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;


@ExtendWith(MockitoExtension.class)
public class UserServiceMockTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UserService userService;

    private UserDto userDto;
    private User user;

    @BeforeEach
    void setUp() {
        userDto = new UserDto();
        userDto.setName("John Doe");

        user = new User();
        user.setId(1);
        user.setName("John Doe");
    }

    @Test
    void testSaveUser() {
        // Mock the behavior needed for this test
        when(modelMapper.map(any(UserDto.class), any(Class.class))).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.saveUser(userDto);

        assertNotNull(savedUser.getId());  // Ensure the ID is generated
        assertEquals(userDto.getName(), savedUser.getName());

        // Verify the user is actually saved in the repository (mocked behavior)
        when(userRepository.findById(savedUser.getId())).thenReturn(Optional.of(user));
        User foundUser = userRepository.findById(savedUser.getId()).orElse(null);
        assertNotNull(foundUser);  // Ensure the user is found
        assertEquals(savedUser, foundUser);
    }

    @Test
    void testGetUsers() {
        // Mock the behavior needed for this test
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));

        List<User> users = userService.getUsers();

        assertEquals(1, users.size());
        assertEquals(user.getName(), users.get(0).getName());
    }
}
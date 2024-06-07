package com.example.demo.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserDto {
	
 private int id;
 private String name;
 
}

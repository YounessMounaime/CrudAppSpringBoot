package com.crud.demo.ws.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

//import com.crud.demo.ws.serviceImpl.userDto;
import com.crud.demo.ws.shared.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	
	UserDto getUserByuserId(String userId);
	List<UserDto> getUsers();
	
	List<UserDto> getUsersByName();
	
	
	
	
	UserDto	updateUser(String userId , UserDto ud);
	void deleteUser(String userId);
	
	
	//login
    UserDto getUserByEmail(String email);
    boolean authenticate(String email, String password);
	

}

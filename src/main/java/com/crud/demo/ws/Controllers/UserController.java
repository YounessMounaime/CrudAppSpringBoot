package com.crud.demo.ws.Controllers;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.ws.exceptions.UserExceptions;
import com.crud.demo.ws.request.UserRequest;
import com.crud.demo.ws.response.ErrorMessages;
import com.crud.demo.ws.response.UserResponse;
import com.crud.demo.ws.services.UserService;
import com.crud.demo.ws.shared.UserDto;

import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService Us;

	@GetMapping(path = "/{id}")
	public ResponseEntity<UserResponse> getUser(@PathVariable String id) {

		UserDto ud = Us.getUserByuserId(id);
		UserResponse ur = new UserResponse();
		BeanUtils.copyProperties(ud, ur);
		return new ResponseEntity<>(ur, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<UserResponse>> getUsers() {
	    List<UserDto> userDtos = Us.getUsers();
		//List<UserDto> userDtos = Us.getUsersByName();
	    ModelMapper modelMapper = new ModelMapper();
	    
	    List<UserResponse> userResponses = userDtos.stream()
	            .map(userDto -> modelMapper.map(userDto, UserResponse.class))
	            .collect(Collectors.toList());
	    
	    return new ResponseEntity<>(userResponses, HttpStatus.OK);
	}


	@PostMapping()
	public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest) throws Exception {

		// UserDto userDto = new UserDto();
		// BeanUtils.copyProperties(userRequest, userDto);
		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto = modelMapper.map(userRequest, UserDto.class);

		UserDto createUser = Us.createUser(userDto);

		UserResponse userResponse = modelMapper.map(createUser, UserResponse.class);

		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);

	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<UserResponse> UpdatetUser(@PathVariable String id, @RequestBody UserRequest ur) {

		// couche presentation
		UserDto ud = new UserDto();
		BeanUtils.copyProperties(ur, ud);

		UserDto updateUser = Us.updateUser(id, ud);

		UserResponse reponse = new UserResponse();
		BeanUtils.copyProperties(updateUser, reponse);

		return new ResponseEntity<>(reponse, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(path = "/{id}")
	// 204
	public ResponseEntity<Object> deleteUser(@PathVariable String id) {

		Us.deleteUser(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

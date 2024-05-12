package com.crud.demo.ws.serviceImpl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.crud.demo.ws.Entity.AdrEntity;
//import com.crud.demo.ws.Entity.AddressEntity;
import com.crud.demo.ws.Entity.UserEntity;
import com.crud.demo.ws.repositry.UserRepositry;
import com.crud.demo.ws.services.UserService;
import com.crud.demo.ws.shared.AdrDto;
import com.crud.demo.ws.shared.UserDto;
import com.crud.demo.ws.shared.Utilise;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepositry userRepositry;
	@Autowired
	Utilise ut;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	/*
	 * public UserDto createUser(UserDto user) { /*if (user.getAdr() == null) {
	 * user.setAdr(new ArrayList<>()); } // Adresses statiques AdrDto address1 = new
	 * AdrDto(); address1.setCity("Fes"); address1.setStreet("Hay tarik");
	 * 
	 * AdrDto address2 = new AdrDto(); address2.setCity("Rabat");
	 * address2.setStreet("Agdal");
	 * 
	 * user.getAdr().add(address1); user.getAdr().add(address2);
	 * 
	 * ModelMapper modelMapper = new ModelMapper();
	 * 
	 * UserEntity userEntity = modelMapper.map(user, UserEntity.class);
	 * userEntity.setEncryptepassword(bCryptPasswordEncoder.encode(user.getPassword(
	 * ))); userEntity.setUserId(ut.generateStringId(32));
	 * 
	 * List<AdrEntity> adrEntities = new ArrayList<>(); for (AdrDto adrDto :
	 * user.getAdr()) { AdrEntity adrEntity = modelMapper.map(adrDto,
	 * AdrEntity.class); adrEntity.setAdrId(ut.generateStringId(30));
	 * adrEntity.setUser(userEntity); adrEntities.add(adrEntity); }
	 * userEntity.setAdr(adrEntities);
	 * 
	 * UserEntity newUser = userRepositry.save(userEntity);
	 * 
	 * return modelMapper.map(newUser, UserDto.class); }
	 */

	@Override
	public UserDto createUser(UserDto user) {

			
		for (int i = 0; i < user.getAdr().size(); i++) {

			AdrDto address = user.getAdr().get(i);
			address.setUser(user);
			address.setAdrId(ut.generateStringId(30));
			user.getAdr().set(i, address);
		}

		 user.getContact().setContactId(ut.generateStringId(30));
		 user.getContact().setUser(user);

		ModelMapper modelMapper = new ModelMapper();

		UserEntity userEntity = modelMapper.map(user, UserEntity.class);

		userEntity.setEncryptepassword(bCryptPasswordEncoder.encode(user.getPassword()));

		userEntity.setUserId(ut.generateStringId(32));

		UserEntity newUser = userRepositry.save(userEntity);

		UserDto userDto = modelMapper.map(newUser, UserDto.class);

		return userDto;
	}

	@Override
	public UserDto getUserByuserId(String userId) {
		UserEntity userEntity = userRepositry.findByuserId(userId);

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userEntity, userDto);

		return userDto;

	}

	@Override
	public UserDto updateUser(String userId, UserDto ud) {
		UserEntity userEntity = userRepositry.findByuserId(userId);
		userEntity.setNom(ud.getNom());
		userEntity.setPrenom(ud.getPrenom());
		UserEntity updateUser = userRepositry.save(userEntity);
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(updateUser, userDto);
		return userDto;
	}

	@Override
	public void deleteUser(String userId) {
		UserEntity userEntity = userRepositry.findByuserId(userId);
		userRepositry.delete(userEntity);

	}

	public List<UserDto> getUsers() {

		 /*List<UserEntity> users =  (List<UserEntity>) userRepositry.findAll();
		 
		 Type listType = new TypeToken<List<AdrDto>>() {}.getType();
		 List<UserDto> usersDto = new ModelMapper().map( users ,listType);
		return usersDto ;*/
		 ModelMapper modelMapper = new ModelMapper();
		    List<UserEntity> userEntities = (List<UserEntity>) userRepositry.findAll();
		    return userEntities.stream()
		            .map(userEntity -> modelMapper.map(userEntity, UserDto.class))
		            .collect(Collectors.toList());
	    
	  
	}


	public List<UserDto> getUsersByName() {
		  ModelMapper modelMapper = new ModelMapper();
	    List<UserEntity> userEntities = userRepositry.findAllByNom();
	    return userEntities.stream()
	            .map(userEntity -> modelMapper.map(userEntity, UserDto.class))
	            .collect(Collectors.toList());
	}


	public UserDto getUserByEmail(String email) {
          UserEntity userEntity = userRepositry.findByemail(email);
 		
		if(userEntity == null) throw new UsernameNotFoundException(email); 
		
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(userEntity, userDto);
		
		return userDto;
	}
	
	 public boolean authenticate(String email, String password) {
	        UserEntity user = userRepositry.findByemail(email);
	        if (user != null && user.getPassword().equals(password)) {
	            return true;
	        }
	  
	        return false;
	    }




}

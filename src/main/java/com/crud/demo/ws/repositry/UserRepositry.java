package com.crud.demo.ws.repositry;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crud.demo.ws.Entity.UserEntity;


public interface   UserRepositry extends CrudRepository<UserEntity, Long> {
	
	public UserEntity findByuserId(String userId);
	
	public UserEntity findByemail(String email);
	 
	@Query(value="SELECT * FROM user_crud u where u.nom ='Mnm' ", nativeQuery=true)
	public List<UserEntity> findAllByNom();


	
	

}

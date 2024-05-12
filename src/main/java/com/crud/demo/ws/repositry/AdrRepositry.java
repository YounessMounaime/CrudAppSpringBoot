package com.crud.demo.ws.repositry;

import org.springframework.data.repository.CrudRepository;

import com.crud.demo.ws.Entity.AdrEntity;
import com.crud.demo.ws.Entity.UserEntity;

public interface  AdrRepositry extends CrudRepository<AdrEntity, Long> {

}

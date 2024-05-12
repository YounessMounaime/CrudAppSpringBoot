package com.crud.demo.ws.serviceImpl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.demo.ws.Entity.AdrEntity;
import com.crud.demo.ws.repositry.AdrRepositry;
import com.crud.demo.ws.response.AdrResponse;
import com.crud.demo.ws.services.AdrService;
import com.crud.demo.ws.shared.AdrDto;

@Service
public class  AdrServiceImpl implements AdrService {
	
	@Autowired
	AdrRepositry  adrRepositry;

	@Override
	public List<AdrDto> getAdrs() {		
		 List<AdrEntity> adrs =  (List<AdrEntity>) adrRepositry.findAll();
		 
		 Type listType = new TypeToken<List<AdrDto>>() {}.getType();
		 List<AdrDto> addressesDto = new ModelMapper().map(adrs ,listType);
		return addressesDto ;
	}
	
	
	
	

	
	
	

}

package com.crud.demo.ws.Controllers;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.ws.response.AdrResponse;

import com.crud.demo.ws.services.AdrService;
import com.crud.demo.ws.shared.AdrDto;


@RestController
@RequestMapping("/Adr")
public class AdrController {
	
	@Autowired
	AdrService adrService;
	
	@GetMapping()
	public ResponseEntity<List<AdrResponse>> getAdrs(){
		   List<AdrDto> adr =  adrService.getAdrs();
			 Type listType = new TypeToken<List<AdrResponse>>() {}.getType();
			 List<AdrResponse> reponses = new ModelMapper().map(adr ,listType);
		
			 return new ResponseEntity<>(reponses, HttpStatus.OK);
			
	}
	

	
	
	

}

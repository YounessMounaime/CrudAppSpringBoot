package com.crud.demo.ws.exceptions;

import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

public class UserExceptions  extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -449612495665673357L;
	public UserExceptions(String message)
	{
		super(message);
	}
	public UserExceptions(String message, Throwable cause) {
        super(message, cause);
    }
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleValidationExceptions(MethodArgumentNotValidException ex) {
	    return ex.getBindingResult().getAllErrors().stream()
	            .map(DefaultMessageSourceResolvable::getDefaultMessage)
	            .collect(Collectors.joining(", "));
	}

	

}

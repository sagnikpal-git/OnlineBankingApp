package com.online.banking.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AadharNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public AadharNotFoundException(String message){
		super(message);
    	
	}}
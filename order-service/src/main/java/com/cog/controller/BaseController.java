package com.cog.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
	//Error handling
			@ExceptionHandler(MethodArgumentNotValidException.class)
			Map<String,String> handleException(MethodArgumentNotValidException ex) {
				Map<String,String> errors=new HashMap<>();
				ex.getBindingResult().getAllErrors().forEach(err->{
					String filedError=	((FieldError) err).getField();
					String msg=	((FieldError) err).getDefaultMessage();
				
				errors.put(filedError, msg);
				});
				return errors;
			}
}

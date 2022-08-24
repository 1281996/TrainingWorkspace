package com.cog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cog.entity.User;
import com.cog.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	
	Log LOGGER =LogFactory.getLog(UserController.class);
	@Autowired
	UserService userService;
	//get all registered userss
	@GetMapping
	List<User> getAllUsers(){
		return userService.findAllUsers();
		
	}
	//user registration
	@PostMapping
	User saveUser(@RequestBody User user){
		LOGGER.trace(user);
		return userService.registerUser(user);
		
	}
	//user path variable checking
		@PostMapping("/age/{age}/height/{height}")
		@ResponseStatus(code = HttpStatus.CREATED)
		User saveUser(@Valid @RequestBody User user,@PathVariable("age") int age,@PathVariable("height") float height ){
			LOGGER.trace(user);
			System.out.println(age+"-"+height);
			return null;
			
		}
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

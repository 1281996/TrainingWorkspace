package com.cog.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin
public class UserController extends BaseController {

	Log LOGGER = LogFactory.getLog(UserController.class);
	@Autowired
	UserService userService;

	// get all registered userss
	@GetMapping
	List<User> getAllUsers() {
		return userService.findAllUsers();

	}

	// user registration
	@PostMapping
	User saveUser(@RequestBody User user) {
		LOGGER.trace(user);
		return userService.registerUser(user);

	}

	// user path variable checking
	@PostMapping("/age/{age}/height/{height}")
	@ResponseStatus(code = HttpStatus.CREATED)
	ResponseEntity saveUser(@Valid @RequestBody User user, @PathVariable("age") int age,
			@PathVariable("height") float height) {
		LOGGER.trace(user);
		LOGGER.trace(age + "-" + height);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("sample", "sample1");
		ResponseEntity res = new ResponseEntity(user, headers, HttpStatus.ACCEPTED);

		return res;

	}
//delete user
	@DeleteMapping("/{id}")
	ResponseEntity deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
		ResponseEntity res = new ResponseEntity(getAllUsers(), HttpStatus.ACCEPTED);
		return res;
	}
}

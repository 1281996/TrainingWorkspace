package com.cog.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cog.entity.User;
import com.cog.service.UserService;
@ExtendWith(MockitoExtension.class)
class UserControllerTest {
	@Mock
	UserService userService;
	@InjectMocks
	UserController userController;

	@Test
	void testSaveUserUser() {
		User user=new User();
		user.setId(1);;
		when(userService.registerUser(user)).thenReturn(user);
		assertEquals(1, userController.saveUser(user));
	}

}

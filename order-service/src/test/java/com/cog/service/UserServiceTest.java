package com.cog.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cog.entity.User;
import com.cog.repo.UserRepostority;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	@InjectMocks
	UserService userService;

	@Mock
	UserRepostority userRepo;

	@Test
	void testFindAllUsers() {
		User user = getUser();

		List<User> allUsers = new ArrayList<>();
		allUsers.add(user);
		when(userRepo.findAll()).thenReturn(allUsers);
		assertEquals(1, userService.findAllUsers().size());
	}

	@Test
	void testRegisterUser() {
		User user = getUser();
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(1, userService.registerUser(user).getId());
	}

	private static User getUser() {
		User user = new User();
		user.setId(1);
		user.setName("Mallika");
		user.setAge(2);
		user.setSal(5678.0);
		return user;
	}
}

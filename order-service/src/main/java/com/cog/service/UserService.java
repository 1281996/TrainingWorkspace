package com.cog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cog.entity.User;
import com.cog.repo.UserRepostority;

@Service
public class UserService {
	@Autowired
	UserRepostority userRepo;

	public List<User> findAllUsers() {

		return userRepo.findAll();
	}

	public User registerUser(User user) {

		return userRepo.save(user);
	}

	public void deleteUser(Integer id) {
		userRepo.deleteById(id);
		
	}

}

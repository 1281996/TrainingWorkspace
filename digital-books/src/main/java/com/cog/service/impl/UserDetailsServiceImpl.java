package com.cog.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cog.dao.UserMappingRepository;
import com.cog.dao.UserRepository;
import com.cog.entity.User;
import com.cog.entity.UserMapping;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserMappingRepository userMappingRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		User user = userRepository.findByEmailId(emailId);
		Set<UserMapping> userMapping=userMappingRepository.findByUserId(user.getId())	;	
		return UserDetailsImpl.build(user,userMapping);
	}

}

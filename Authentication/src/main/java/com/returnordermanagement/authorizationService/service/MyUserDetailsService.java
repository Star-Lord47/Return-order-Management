package com.returnordermanagement.authorizationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.returnordermanagement.authorizationService.Repository.UserRepository;
import com.returnordermanagement.authorizationService.model.MyUser;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser cusUser = userRepo.findByUsername(username);
		return new User(cusUser.getUsername(), cusUser.getPassword(), new ArrayList<>());
		// return new User("foo","foo",new ArrayList<>());
	}

}

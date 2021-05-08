package com.returnordermanagement.returnorderportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.returnordermanagement.returnorderportal.model.User;
import com.returnordermanagement.returnorderportal.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginService {
	
	@Autowired
	User user;
	
	@Autowired
	private UserRepository userRepo;

	public void createUser(int userID, String userName, String password, String jwtToken, boolean isValid) {
		user = new User(userID, userName, password, jwtToken, isValid);
		log.info("Start");
		userRepo.save(user);
		log.info("End");
	}
	
}

package com.returnordermanagement.returnorderportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.returnordermanagement.returnorderportal.model.User;
import com.returnordermanagement.returnorderportal.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenticateService {

	@Autowired
	private UserRepository userRepository;

	public Boolean loadUserByUsername(String username,String password){
		log.info("Start");
		User user= userRepository.findByUsernameAndPassword(username, password);
		log.info("End");
		return user!=null;
	}
}

package com.returnordermanagement.returnorderportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.returnordermanagement.returnorderportal.client.AuthenticationFeignClient;
import com.returnordermanagement.returnorderportal.model.AuthenticationRequest;
import com.returnordermanagement.returnorderportal.model.AuthenticationResponse;
import com.returnordermanagement.returnorderportal.model.User;
import com.returnordermanagement.returnorderportal.service.LoginService;

import lombok.extern.slf4j.Slf4j;

/*
 * @author Manan
 */
@Controller
@Slf4j
public class LoginController {

	/*
	 * AuthenticationFeignClient is called to verify username and password
	 */

	@Autowired
	AuthenticationFeignClient authenticationFeignClient;

	/*
	 * AuthenticationRequest is passed to AuthenticationFeignClient for validation
	 */

	@Autowired
	AuthenticationRequest authenticationRequest;
	/*
	 * AuthenticationRespone is Called and token is generated is valid username and
	 * password
	 */
	@Autowired
	private AuthenticationResponse authenticationResponse;
	/*
	 * Login
	 */
	@Autowired
	private LoginService loginservice;
	@Autowired
	User user;
	@Value("${authentication-error}")
	private String authError;

	/*
	 * In The Login Page
	 */
	@RequestMapping("/")
	public String login() {
		log.info("In landing Page");
		return "index.jsp";
	}

	/*
	 * @param username
	 * 
	 * @param password
	 * 
	 * @return next page if valid username and password else model map shows
	 * authError message
	 */
	@RequestMapping("/index")
	public String logedin(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {
		authenticationRequest = new AuthenticationRequest(username, password);
		try {
			user.setUsername(username);
			log.info("Login Controller :: Authentication MicroService Called For validation");
			authenticationResponse = authenticationFeignClient.createAuthenticationToken(authenticationRequest);
			String jwtToken = authenticationResponse.getJwtToken();
			boolean isValid = authenticationResponse.getValid();
			loginservice.createUser(101, username, password, jwtToken, isValid);
			if (isValid) {
				model.addAttribute("username", user.getUsername());
				log.info("Authentication MicroService Called For validation :: Login Success");
			}
			return "home.jsp";
		} catch (Exception e) {
			model.addAttribute("invalidlogin", authError);
			log.info("Login Controller :: Authentication MicroService Called For validation :: Login failed");
		}
		return "index.jsp";
	}
}

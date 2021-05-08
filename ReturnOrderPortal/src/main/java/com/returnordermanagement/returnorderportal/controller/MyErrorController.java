package com.returnordermanagement.returnorderportal.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MyErrorController implements ErrorController {
	/*
	 * Invalid URL shows 404 page not found
	 */
	@RequestMapping("/error")
	public String handleError() {
		log.info("Error Controller :: Please Enter valid URL");
		return "404.jsp";
	}

	@Override
	public String getErrorPath() {
		return null;
	}
}
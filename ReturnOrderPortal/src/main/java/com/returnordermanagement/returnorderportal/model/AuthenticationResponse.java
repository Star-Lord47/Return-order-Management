package com.returnordermanagement.returnorderportal.model;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Component
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

	private String jwtToken;
	private Boolean valid;

}
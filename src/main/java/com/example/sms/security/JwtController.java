package com.example.sms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {
	

	@Autowired
	private JwtServiceImpl jwtServiceImplementation;

	@PostMapping("/Auth")
	public JwtResponse generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

		return jwtServiceImplementation.createJwtToken(jwtRequest);
	}
}

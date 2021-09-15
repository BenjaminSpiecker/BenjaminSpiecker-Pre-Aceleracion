package com.alkemy.javaChallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.javaChallenge.dto.UserDto;
import com.alkemy.javaChallenge.model.AuthenticationRequest;
import com.alkemy.javaChallenge.model.AuthenticationResponse;
import com.alkemy.javaChallenge.model.User;
import com.alkemy.javaChallenge.service.IUserService;
import com.alkemy.javaChallenge.service.impl.UserDetailsServiceImpl;
import com.alkemy.javaChallenge.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/authentication")
	public ResponseEntity<?> createAuthentication(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
				);
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		UserDetails usuario = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		String jwt = jwtUtil.generateToken(usuario);
		return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> createAccount(@RequestBody UserDto userDto){
		User user = userService.save(userDto);
		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}
}

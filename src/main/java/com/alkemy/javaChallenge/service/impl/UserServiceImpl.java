package com.alkemy.javaChallenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.javaChallenge.dto.UserDto;
import com.alkemy.javaChallenge.model.User;
import com.alkemy.javaChallenge.model.builder.UserBuilder;
import com.alkemy.javaChallenge.repository.UserRepository;
import com.alkemy.javaChallenge.service.ISendMailService;
import com.alkemy.javaChallenge.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ISendMailService sendMailService;
	
	@Override
	public User findByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}

	@Override
	public User save(UserDto userDto) {
		User user = new UserBuilder().withUsuarioDto(userDto).build();
		user = userRepository.save(user);
		sendMailService.sendMail(user);
		return user;
	}
}

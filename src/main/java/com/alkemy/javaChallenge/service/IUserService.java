package com.alkemy.javaChallenge.service;

import com.alkemy.javaChallenge.dto.UserDto;
import com.alkemy.javaChallenge.model.User;

public interface IUserService {
	public User findByUsername(String username);
	public User save(UserDto usuarioDto);
}

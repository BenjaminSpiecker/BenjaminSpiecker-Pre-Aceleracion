package com.alkemy.javaChallenge.model.builder;

import com.alkemy.javaChallenge.dto.UserDto;
import com.alkemy.javaChallenge.model.User;

public class UserBuilder {
	private String name;
	private String lastName;
	private String mail;
	private String username;
	private String password;
	
	public UserBuilder withUsuarioDto(UserDto usuarioDto) {
		this.name = usuarioDto.getName();
		this.lastName = usuarioDto.getLastName();
		this.mail = usuarioDto.getMail();
		this.username = usuarioDto.getUsername();
		this.password = usuarioDto.getPassword();
		return this;
	}
	
	public User build() {
		return new User(name, lastName, mail, username, password);
	}
}

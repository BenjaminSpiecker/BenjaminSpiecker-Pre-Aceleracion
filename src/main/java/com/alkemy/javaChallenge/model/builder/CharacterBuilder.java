package com.alkemy.javaChallenge.model.builder;

import com.alkemy.javaChallenge.dto.CharacterDto;
import com.alkemy.javaChallenge.model.Character;

public class CharacterBuilder {
	 
	private String name;
	private Integer age;
	private Integer weight;
	private String image;
	private String history;
	
	public CharacterBuilder withCharacterDto( CharacterDto characterDto) {
		this.name = characterDto.getName();
		this.age = characterDto.getAge();
		this.weight = characterDto.getWeight();
		this.image = characterDto.getImage();
		this.history = characterDto.getHistory();
		return this;
	}
	
	public Character build() {
		return new Character(this.name, this.age, this.weight, this.image, this.history);
	}
}

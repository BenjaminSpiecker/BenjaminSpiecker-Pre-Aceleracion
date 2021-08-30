package com.alkemy.javaChallenge.service;

import com.alkemy.javaChallenge.model.Character;
import java.util.List;

public interface ICharacterService {
	public Character getById(int id);
	public List<Character> findAll();
	public void createCharacter(Character character);
	public void updateCharacter(int id, Character character);
	public void deleteCharacter(int id);
	
}

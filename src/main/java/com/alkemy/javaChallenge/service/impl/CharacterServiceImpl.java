package com.alkemy.javaChallenge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.alkemy.javaChallenge.model.Character;
import com.alkemy.javaChallenge.repository.CharacterRepository;
import com.alkemy.javaChallenge.service.ICharacterService;

@Service
public class CharacterServiceImpl implements ICharacterService{

	@Autowired
	private CharacterRepository repository;
	@Override
	@Query()
	public List<Character> findAllCharacters() {
		return (List<Character>) repository.findAll();
	}
	@Override
	public Character getById(int id) {
		return repository.findById(id);
	}
	@Override
	public void createCharacter(Character character) {
		repository.save(character);
	}
	@Override
	public void updateCharacter(int id, Character character) {
		repository.deleteById(id);
		repository.save(character);
	}
	@Override
	public void deleteCharacter(int id) {
		repository.deleteById(id);
	}

	
}

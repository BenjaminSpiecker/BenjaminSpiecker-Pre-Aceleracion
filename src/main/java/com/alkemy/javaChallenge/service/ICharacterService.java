package com.alkemy.javaChallenge.service;

import com.alkemy.javaChallenge.dto.CharacterDto;
import com.alkemy.javaChallenge.dto.CharacterListDto;
import com.alkemy.javaChallenge.dto.CharacterShowDto;
import com.alkemy.javaChallenge.model.Character;
import java.util.List;

public interface ICharacterService {
	public List<CharacterListDto> findAllCharacters();
	public CharacterShowDto findCharacterById(int id);
	public Character createCharacter(CharacterDto characterDto);
	public Character updateCharacter(int id, CharacterDto characterDto);
	public void deleteCharacter(int id);
}

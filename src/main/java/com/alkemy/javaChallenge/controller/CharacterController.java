package com.alkemy.javaChallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.javaChallenge.dto.CharacterDto;
import com.alkemy.javaChallenge.service.ICharacterService;

@RestController
@RequestMapping(value = "/characters")
public class CharacterController {
	@Autowired
	private ICharacterService characterService;
	
	@GetMapping
	public ResponseEntity<?> findAllCharacters() {
	    return new ResponseEntity<>(characterService.findAllCharacters(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findCharacterById(@PathVariable("id") int id) {
	    return new ResponseEntity<>(characterService.findCharacterById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> createCharacter(@RequestBody CharacterDto characterDto) {
		characterService.createCharacter(characterDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCharacter(@PathVariable("id") int id) {
		characterService.deleteCharacter(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCharacter(@PathVariable("id") int id, @RequestBody CharacterDto characterDto) {
		characterService.updateCharacter(id, characterDto);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}

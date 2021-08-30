package com.alkemy.javaChallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.javaChallenge.service.ICharacterService;
import com.alkemy.javaChallenge.model.Character;
import com.alkemy.javaChallenge.model.MovieSerie;

@RestController
public class MyController {
	@Autowired
	private ICharacterService characterService;
	
	@RequestMapping(value = "/characters", method = RequestMethod.GET)
	  public @ResponseBody Iterable<Character> getAllCharacters() {
	    return characterService.findAll();
	  }
	
	@RequestMapping(value = "/characters/{id}", method = RequestMethod.GET)
	  public @ResponseBody Character getCharacterById(@PathVariable("id") int id) {
	    return characterService.getById(id);
	  }
	@RequestMapping(value = "/characters/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteCharacter(@PathVariable("id") int id) {
		characterService.deleteCharacter(id);
		return "deleted";
	}
	@RequestMapping(value = "/characters", method = RequestMethod.POST)
	public @ResponseBody String createCharacter(@RequestBody Character character) {
		characterService.createCharacter(character);
		return "Saved";
	}
	@RequestMapping(value = "/characters/{id}", method = RequestMethod.PUT)
	public @ResponseBody String updateCharacter(@PathVariable("id") int id, @RequestBody Character character) {
		characterService.updateCharacter(id, character);
		return "updated";
	}
}

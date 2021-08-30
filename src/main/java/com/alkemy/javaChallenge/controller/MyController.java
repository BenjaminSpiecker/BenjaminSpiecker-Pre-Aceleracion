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
import com.alkemy.javaChallenge.service.IMovieSerieService;
import com.alkemy.javaChallenge.model.Character;
import com.alkemy.javaChallenge.model.MovieSerie;

@RestController
public class MyController {
	@Autowired
	private ICharacterService characterService;
	
	@Autowired
	private IMovieSerieService movieSerieService;
	
	@RequestMapping(value = "/characters", method = RequestMethod.GET)
	  public @ResponseBody Iterable<Character> getAllCharacters() {
	    return characterService.findAllCharacters();
	}
	@RequestMapping(value = "/characters/{id}", method = RequestMethod.GET)
	  public @ResponseBody Character getCharacterById(@PathVariable("id") int id) {
	    return characterService.getById(id);
	}
	@RequestMapping(value = "/characters/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteCharacter(@PathVariable("id") int id) {
		characterService.deleteCharacter(id);
		return "Deleted character";
	}
	@RequestMapping(value = "/characters", method = RequestMethod.POST)
	public @ResponseBody String createCharacter(@RequestBody Character character) {
		characterService.createCharacter(character);
		return "Saved character";
	}
	@RequestMapping(value = "/characters/{id}", method = RequestMethod.PUT)
	public @ResponseBody String updateCharacter(@PathVariable("id") int id, @RequestBody Character character) {
		characterService.updateCharacter(id, character);
		return "Updated character";
	}
	
	@RequestMapping(value = "/movies-series", method = RequestMethod.GET)
	public @ResponseBody Iterable<MovieSerie> getAllMoviesSeries() {
		return movieSerieService.findAll();
	}
	@RequestMapping(value = "/movies-series/{id}", method = RequestMethod.GET)
	  public @ResponseBody MovieSerie getMovieSerieById(@PathVariable("id") int id) {
	    return movieSerieService.getById(id);
	}
	@RequestMapping(value = "/movies-series/{id}", method = RequestMethod.DELETE)
	  public @ResponseBody String deleteMovieSerie(@PathVariable("id") int id) {
	    movieSerieService.deleteMovieSerie(id);
	    return "Deleted movie or serie";
	}
	@RequestMapping(value = "/movies-series", method = RequestMethod.POST)
	public @ResponseBody String createMovieSerie(@RequestBody MovieSerie movieSerie) {
		movieSerieService.createMovieSerie(movieSerie);
		return "Saved movie or serie";
	}
	@RequestMapping(value = "/movies-series/{id}", method = RequestMethod.PUT)
	public @ResponseBody String updateMovieSerie(@PathVariable("id") int id, @RequestBody MovieSerie movieSerie) {
		movieSerieService.updateMovieSerie(id, movieSerie);
		return "Updated movie or serie";
	}
}

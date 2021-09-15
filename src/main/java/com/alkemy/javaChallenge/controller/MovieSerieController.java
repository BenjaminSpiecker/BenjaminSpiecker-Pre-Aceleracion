package com.alkemy.javaChallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.javaChallenge.dto.MovieSerieDto;
import com.alkemy.javaChallenge.service.IMovieSerieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieSerieController {
	@Autowired
	private IMovieSerieService movieSerieService;
	
	@GetMapping
	public ResponseEntity<?> findAllMoviesSeries(
			@RequestParam(required = false, name = "name") String name, 
			@RequestParam(required = false, name = "genre") String genre,
			@RequestParam(required = false, name = "order") String order) {
		 
	    return new ResponseEntity<>(movieSerieService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findMovieSerieById(@PathVariable("id") int id) {
	    return new ResponseEntity<>(movieSerieService.getById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> createMovieSerie(@RequestBody MovieSerieDto movieSerieDto) {
		movieSerieService.createMovieSerie(movieSerieDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMovieSerie(@PathVariable("id") int id) {
		movieSerieService.deleteMovieSerie(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateMovieSerie(@PathVariable("id") int id, @RequestBody MovieSerieDto movieSerieDto) {
		movieSerieService.updateMovieSerie(id, movieSerieDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

package com.alkemy.javaChallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.javaChallenge.service.IGenreService;

@RestController
@RequestMapping(value = "/genre")
public class GenreController {
	@Autowired
	private IGenreService genreService;
	
	@GetMapping
	public ResponseEntity<?> getAllGenres() {
		return new ResponseEntity<>(genreService.findAllGenres(), HttpStatus.OK);
	}
}

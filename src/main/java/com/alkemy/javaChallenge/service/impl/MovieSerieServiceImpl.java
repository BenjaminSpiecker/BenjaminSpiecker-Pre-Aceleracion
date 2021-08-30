package com.alkemy.javaChallenge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.javaChallenge.model.MovieSerie;
import com.alkemy.javaChallenge.repository.MovieSerieRepository;
import com.alkemy.javaChallenge.service.IMovieSerieService;

@Service
public class MovieSerieServiceImpl implements IMovieSerieService{
	
	@Autowired
	private MovieSerieRepository repository;
	
	@Override
	public MovieSerie getById(int id) {
		return repository.findById(id);
	}

	@Override
	public List<MovieSerie> findAll() {
		return (List<MovieSerie>) repository.findAll();
	}

	@Override
	public void createMovieSerie(MovieSerie movieSerie) {
		repository.save(movieSerie);
	}

	@Override
	public void updateMovieSerie(int id, MovieSerie movieSerie) {
		repository.deleteById(id);
		repository.save(movieSerie);
	}

	@Override
	public void deleteMovieSerie(int id) {
		repository.deleteById(id);
	}

}

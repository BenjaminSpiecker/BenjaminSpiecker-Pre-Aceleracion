package com.alkemy.javaChallenge.service;

import java.util.List;

import com.alkemy.javaChallenge.model.MovieSerie;

public interface IMovieSerieService {
	public MovieSerie getById(int id);
	public List<MovieSerie> findAll();
	public void createMovieSerie(MovieSerie movieSerie);
	public void updateMovieSerie(int id, MovieSerie movieSerie);
	public void deleteMovieSerie(int id);
}

package com.alkemy.javaChallenge.service;

import java.text.ParseException;
import java.util.List;

import com.alkemy.javaChallenge.dto.MovieSerieDto;
import com.alkemy.javaChallenge.dto.MovieSerieListDto;
import com.alkemy.javaChallenge.dto.MovieSerieShowDto;
import com.alkemy.javaChallenge.model.MovieSerie;

public interface IMovieSerieService {
	public MovieSerieShowDto getById(int id);
	public List<MovieSerieListDto> findAll();
	public MovieSerie createMovieSerie(MovieSerieDto movieSerieDto);
	public void updateMovieSerie(int id, MovieSerieDto movieSerieDto);
	public void deleteMovieSerie(int id);
}

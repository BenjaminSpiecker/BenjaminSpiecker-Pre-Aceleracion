package com.alkemy.javaChallenge.service;

import java.util.List;

import com.alkemy.javaChallenge.dto.GenreListDto;



public interface IGenreService {
	public List<GenreListDto> findAllGenres();
}

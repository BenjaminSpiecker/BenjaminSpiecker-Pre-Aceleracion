package com.alkemy.javaChallenge.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.javaChallenge.dto.CharacterListDto;
import com.alkemy.javaChallenge.dto.GenreListDto;
import com.alkemy.javaChallenge.model.Character;
import com.alkemy.javaChallenge.model.Genre;
import com.alkemy.javaChallenge.repository.GenreRepository;
import com.alkemy.javaChallenge.service.IGenreService;

@Service
public class GenreServiceImpl implements IGenreService{
	@Autowired
	private GenreRepository genreRepository;

	@Override
	public List<GenreListDto> findAllGenres() {
		
		List<GenreListDto> genresListDto = new ArrayList<GenreListDto>();
		List<Genre> genres = genreRepository.findAll();
		
		for(int i = 0; i < genres.size(); i++) {
			GenreListDto genreDto = new GenreListDto(
				genres.get(i).getId(),
				genres.get(i).getName(),
				genres.get(i).getImage()
			);
			genresListDto.add(genreDto);
		}
		return genresListDto;
	}
	
	
}

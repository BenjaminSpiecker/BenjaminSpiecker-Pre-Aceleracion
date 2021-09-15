package com.alkemy.javaChallenge.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.javaChallenge.dto.CharacterListDto;
import com.alkemy.javaChallenge.dto.GenreListDto;
import com.alkemy.javaChallenge.dto.MovieSerieDto;
import com.alkemy.javaChallenge.dto.MovieSerieListDto;
import com.alkemy.javaChallenge.dto.MovieSerieShowDto;
import com.alkemy.javaChallenge.model.Character;
import com.alkemy.javaChallenge.model.Genre;
import com.alkemy.javaChallenge.model.MovieSerie;
import com.alkemy.javaChallenge.model.builder.MovieSerieBuilder;
import com.alkemy.javaChallenge.repository.CharacterRepository;
import com.alkemy.javaChallenge.repository.GenreRepository;
import com.alkemy.javaChallenge.repository.MovieSerieRepository;
import com.alkemy.javaChallenge.service.IMovieSerieService;

@Service
public class MovieSerieServiceImpl implements IMovieSerieService{
	
	@Autowired
	private MovieSerieRepository movieSerieRepository;
	
	@Autowired 
	private CharacterRepository characterRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Override
	public MovieSerieShowDto getById(int id) {
		
		MovieSerie movieSerie = movieSerieRepository.findById(id);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Character> listCharacters = movieSerie.getCharacters();
		List<CharacterListDto> listCharactersDto = new ArrayList<CharacterListDto>();
		
		for(int i = 0; i < listCharacters.size(); i++) {
			CharacterListDto characterListDto = new CharacterListDto(
				listCharacters.get(i).getId(),
				listCharacters.get(i).getName(),
				listCharacters.get(i).getImage()
			);
			
			listCharactersDto.add(characterListDto);
		}
		
		List<Genre> listGenres = movieSerie.getGenres();
		List<GenreListDto> listGenresDto = new ArrayList<GenreListDto>();
		
		for(int i = 0; i < listGenres.size(); i++) {
			GenreListDto genreListDto = new GenreListDto(
					listGenres.get(i).getId(),
					listGenres.get(i).getName(),
					listGenres.get(i).getImage()
			);
			
			listGenresDto.add(genreListDto);
		}
		
		MovieSerieShowDto movieSerieShowDto = new MovieSerieShowDto(
				movieSerie.getId(), 
				movieSerie.getImage(), 
				movieSerie.getTitle(), 
				format.format(movieSerie.getCreationDate()), 
				movieSerie.getQualification(),
				listCharactersDto,
				listGenresDto);
		
		return movieSerieShowDto;
	}

	@Override
	public List<MovieSerieListDto> findAll() {
		
		List<MovieSerieListDto> moviesSeriesListDto = new ArrayList<MovieSerieListDto>();
		List<MovieSerie> moviesSeries = movieSerieRepository.findAll();

		for(int i = 0 ; i < moviesSeries.size() ; i++) {
			MovieSerieListDto movieSerieListDto = new MovieSerieListDto(
				moviesSeries.get(i).getId(),
				moviesSeries.get(i).getImage(),
				moviesSeries.get(i).getTitle(),
				moviesSeries.get(i).getCreationDate()
			);
			
			movieSerieListDto.setId(moviesSeries.get(i).getId());
			
			moviesSeriesListDto.add(movieSerieListDto);
		}
		return moviesSeriesListDto;
	}

	@Override
	public MovieSerie createMovieSerie(MovieSerieDto movieSerieDto) {
		
		MovieSerie newMovieSerie = new MovieSerieBuilder().withMovieSerieDto(movieSerieDto).build();
		
		int[] listCharactersId = movieSerieDto.getCharacters();
		List<Character> listCharacters = new ArrayList<Character>();
		
		for(int i = 0; i < listCharactersId.length; i++) {
			listCharacters.add(characterRepository.getById(listCharactersId[i]));
		}
		newMovieSerie.setCharacters(listCharacters);
		
		movieSerieRepository.save(newMovieSerie);
		
		int[] listGenresId = movieSerieDto.getGenres();
		List<Genre> listGenres = new ArrayList<Genre>();
		
		for(int i = 0; i < listGenresId.length; i++) {
			Genre genre = genreRepository.getById(listGenresId[i]);
			List<MovieSerie> movieSerieList = genre.getGenreMoviesSeries();
			movieSerieList.add(newMovieSerie);
			genre.setGenreMoviesSeries(movieSerieList);
			genreRepository.save(genre);
		}
		
		return newMovieSerie;
	}

	@Override
	public void updateMovieSerie(int id, MovieSerieDto movieSerieDto) {
		
		MovieSerie movieSerie = movieSerieRepository.findById(id);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		movieSerie.setTitle(movieSerieDto.getTitle());
		movieSerie.setImage(movieSerieDto.getImage());
		movieSerie.setQualification(movieSerieDto.getQualification());
		try {
			Date dateCreation = format.parse(movieSerieDto.getCreationDate());
			movieSerie.setCreationDate(dateCreation);
		} catch(ParseException ex) {
			System.out.println(ex);
		}
		
		movieSerieRepository.save(movieSerie);
	
		int[] listCharactersId = movieSerieDto.getCharacters();

		for(int i = 0; i < listCharactersId.length; i++) {
			Character character = characterRepository.findById(listCharactersId[i]);
			List<MovieSerie> movieSerieList = character.getMoviesSeries();
			movieSerieList.add(movieSerie);
			character.setMoviesSeries(movieSerieList);
			characterRepository.save(character);
		}
		
		
		int[] listGenresId = movieSerieDto.getGenres();
		
		for(int i = 0; i < listGenresId.length; i++) {
			Genre genre = genreRepository.getById(listGenresId[i]);
			List<MovieSerie> movieSerieList = genre.getGenreMoviesSeries();
			movieSerieList.add(movieSerie);
			genre.setGenreMoviesSeries(movieSerieList);
			genreRepository.save(genre);
		}
	}

	@Override
	public void deleteMovieSerie(int id) {
		movieSerieRepository.deleteById(id);
	}

}

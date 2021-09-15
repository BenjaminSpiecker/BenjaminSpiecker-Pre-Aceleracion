package com.alkemy.javaChallenge.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.javaChallenge.dto.CharacterDto;
import com.alkemy.javaChallenge.dto.CharacterListDto;
import com.alkemy.javaChallenge.dto.CharacterShowDto;
import com.alkemy.javaChallenge.dto.MovieSerieListDto;
import com.alkemy.javaChallenge.model.Character;
import com.alkemy.javaChallenge.model.MovieSerie;
import com.alkemy.javaChallenge.model.builder.CharacterBuilder;
import com.alkemy.javaChallenge.repository.CharacterRepository;
import com.alkemy.javaChallenge.repository.MovieSerieRepository;
import com.alkemy.javaChallenge.service.ICharacterService;

@Service
public class CharacterServiceImpl implements ICharacterService{

	@Autowired
	private CharacterRepository characterRepository;
	
	@Autowired
	private MovieSerieRepository  movieSerieRepository;
	
	@Override
	public List<CharacterListDto> findAllCharacters() {

		List<CharacterListDto> charactersListDto = new ArrayList<CharacterListDto>();
		List<Character> characters = characterRepository.findAll();

		for(int i = 0 ; i < characters.size() ; i++) {
			CharacterListDto characterListDto = new CharacterListDto(
				characters.get(i).getId(),
				characters.get(i).getName(),
				characters.get(i).getImage()
			);
			charactersListDto.add(characterListDto);
		}
		return charactersListDto;
	}
	
	@Override
	public CharacterShowDto findCharacterById(int id) {
		Character character = characterRepository.findById(id);
		
		List<MovieSerie> listMovieSerie = character.getMoviesSeries();
		List<MovieSerieListDto> listMovieSerieDto = new ArrayList<MovieSerieListDto>();
		
		for(int i = 0; i < listMovieSerie.size(); i++) {
			MovieSerieListDto movieSerieListDto = new MovieSerieListDto(
				listMovieSerie.get(i).getId(),
				listMovieSerie.get(i).getImage(),
				listMovieSerie.get(i).getTitle(),
				listMovieSerie.get(i).getCreationDate()
			);
			listMovieSerieDto.add(movieSerieListDto);
		}
		
		CharacterShowDto characterShowDto = new CharacterShowDto(
			character.getName(),
			character.getAge(),
			character.getWeight(),
			character.getImage(),
			character.getHistory(),
			listMovieSerieDto
		);
		
		return characterShowDto;
	}

	@Override
	public Character createCharacter(CharacterDto characterDto) {
		Character newCharacter = new CharacterBuilder().withCharacterDto(characterDto).build();
		
		int[] listMoviesSeriesId = characterDto.getMoviesSeries();
		List<MovieSerie> listMoviesSeries = new ArrayList<MovieSerie>();
		
		if(listMoviesSeriesId != null) {
			for(int i = 0; i < listMoviesSeriesId.length; i++) {
				listMoviesSeries.add(movieSerieRepository.getById(listMoviesSeriesId[i]));
			}
			newCharacter.setMoviesSeries(listMoviesSeries);
		}
		characterRepository.save(newCharacter);
		
		return newCharacter;
	}

	@Override
	public Character updateCharacter(int id, CharacterDto characterDto) {
		Character character = characterRepository.findById(id);
		character.setName(characterDto.getName());
		character.setAge(characterDto.getAge());
		character.setWeight(characterDto.getWeight());
		character.setImage(characterDto.getImage());
		character.setHistory(characterDto.getHistory());
		
		int[] listMoviesSeriesId = characterDto.getMoviesSeries();
		List<MovieSerie> listMoviesSeries = new ArrayList<MovieSerie>();
		
		if(listMoviesSeriesId != null) {
			for(int i = 0; i < listMoviesSeriesId.length; i++) {
				listMoviesSeries.add(movieSerieRepository.getById(listMoviesSeriesId[i]));
			}
		}
		character.setMoviesSeries(listMoviesSeries);
		return characterRepository.save(character);
	}

	@Override
	public void deleteCharacter(int id) {
		characterRepository.deleteById(id);
	}
	
}

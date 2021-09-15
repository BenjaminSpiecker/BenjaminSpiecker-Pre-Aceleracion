package com.alkemy.javaChallenge.dto;

import java.util.List;

public class MovieSerieShowDto {
	private int id;
	private String image;
	private String title;
	private String creationDate;
	private float qualification;
	private List<CharacterListDto> characters;
	private List<GenreListDto> genres;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public float getQualification() {
		return qualification;
	}
	public void setQualification(float qualification) {
		this.qualification = qualification;
	}
	public List<CharacterListDto> getCharacters() {
		return characters;
	}
	public void setCharacters(List<CharacterListDto> characters) {
		this.characters = characters;
	}
	
	public MovieSerieShowDto(int id, String image, String title, String creationDate, float qualification,
			List<CharacterListDto> characters, List<GenreListDto> genres) {
		super();
		this.id = id;
		this.image = image;
		this.title = title;
		this.creationDate = creationDate;
		this.qualification = qualification;
		this.characters = characters;
		this.setGenres(genres);
	}
	
	public MovieSerieShowDto() {
		super();
	}
	public List<GenreListDto> getGenres() {
		return genres;
	}
	public void setGenres(List<GenreListDto> genres) {
		this.genres = genres;
	}
}

package com.alkemy.javaChallenge.dto;

import java.util.List;

public class CharacterShowDto {
	private String name;
	private Integer age;
	private Integer weight;
	private String image;
	private String history;
	private List<MovieSerieListDto> moviesSeries;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public List<MovieSerieListDto> getMoviesSeries() {
		return moviesSeries;
	}
	public void setMoviesSeries(List<MovieSerieListDto> moviesSeries) {
		this.moviesSeries = moviesSeries;
	}
	
	public CharacterShowDto(String name, Integer age, Integer weight, String image, String history,
			List<MovieSerieListDto> moviesSeries) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.image = image;
		this.history = history;
		this.moviesSeries = moviesSeries;
	}
	
	public CharacterShowDto() {
		super();
	}
	
	
}

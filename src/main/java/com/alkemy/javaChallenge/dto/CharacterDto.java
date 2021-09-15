package com.alkemy.javaChallenge.dto;

import java.util.List;

public class CharacterDto {
	private int id;
	private String name;
	private Integer age;
	private Integer weight;
	private String image;
	private String history;
	private int[] moviesSeries;

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

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int[] getMoviesSeries() {
		return moviesSeries;
	}

	public void setMoviesSeries(int[] moviesSeries) {
		this.moviesSeries = moviesSeries;
	}

	public CharacterDto() {
		super();
	}

	public CharacterDto(int id, String name, Integer age, Integer weight, String image, String history, int[] moviesSeries) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.image = image;
		this.history = history;
		this.moviesSeries = moviesSeries;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}

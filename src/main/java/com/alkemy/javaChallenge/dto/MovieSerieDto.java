package com.alkemy.javaChallenge.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MovieSerieDto {
	private int id;
	private String image;
	private String title;
	private String creationDate;
	private float qualification;
	private int[] characters;
	private int[] genres;

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

	public float getQualification() {
		return qualification;
	}

	public void setQualification(float qualification) {
		this.qualification = qualification;
	}

	public int[] getCharacters() {
		return characters;
	}

	public void setCharacters(int[] characters) {
		this.characters = characters;
	}

	public int[] getGenres() {
		return genres;
	}

	public void setGenres(int[] genres) {
		this.genres = genres;
	}

	public MovieSerieDto() {
		super();
	}

	public MovieSerieDto(String title, String creationDate, float qualification, int[] characters,
			int[] genres) {
		super();
		this.title = title;
		this.creationDate = creationDate;
		this.qualification = qualification;
		this.characters = characters;
		this.genres = genres;
	}
	
	public MovieSerieDto(int id, String image, String title, Date creationDate, float qualification, int[] characters,
			int[] genres) {
		super();
		this.id = id;
		this.image = image;
		this.title = title;SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		this.creationDate = format.format(creationDate);
		this.qualification = qualification;
		this.characters = characters;
		this.genres = genres;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	/*
	public Date getCreationDateToDate() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date cd = null;
		try {
			cd = format.parse(creationDate);
		} catch(ParseException ex) {
			System.out.println(ex);
		}
		return cd;
	}
	
	public void setCreationDateToDate(Date creationDate) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		this.creationDate = format.format(creationDate);
	}
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

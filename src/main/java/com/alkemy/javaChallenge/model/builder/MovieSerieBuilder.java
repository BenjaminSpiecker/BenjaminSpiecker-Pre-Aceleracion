package com.alkemy.javaChallenge.model.builder;

import com.alkemy.javaChallenge.dto.MovieSerieDto;
import com.alkemy.javaChallenge.model.MovieSerie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MovieSerieBuilder {
	private String title;
	private String image;
	private float qualification;
	private Date creationDate;
	
	public MovieSerieBuilder withMovieSerieDto( MovieSerieDto movieSerieDto) {
		Date dateCreation = null;
		
		this.title = movieSerieDto.getTitle();
		this.qualification = movieSerieDto.getQualification();
		this.image = movieSerieDto.getImage();
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			dateCreation = format.parse(movieSerieDto.getCreationDate());
		} catch(ParseException ex) {
			System.out.println(ex);
		}
		this.creationDate = dateCreation;
		return this;
	}
	
	public MovieSerie build() {
		return new MovieSerie(this.image, this.title, this.creationDate, this.qualification);
	}
}

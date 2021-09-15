package com.alkemy.javaChallenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "genres")
public class Genre {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column()
	private String name;
	@Column()
	private String image;
	@ManyToMany
	  @JoinTable(
			  name = "genre_movies_series",
			  joinColumns = @JoinColumn(name = "genre_id"),
			  inverseJoinColumns = @JoinColumn(name = "movies_series_id"))
	private List<MovieSerie> genreMoviesSeries;
	
	public Genre(String name, String image) {
		super();
		this.name = name;
		this.image = image;
	}

	public Genre() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<MovieSerie> getGenreMoviesSeries() {
		return genreMoviesSeries;
	}

	public void setGenreMoviesSeries(List<MovieSerie> genreMoviesSeries) {
		this.genreMoviesSeries = genreMoviesSeries;
	}

}

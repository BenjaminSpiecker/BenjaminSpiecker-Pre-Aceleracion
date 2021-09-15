package com.alkemy.javaChallenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "movies_series")
public class MovieSerie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(length=521)
	private String image;
	@Column()
	private String title;
	@Column(name = "creation_date")
	private Date creationDate;
	@Column()
	private float qualification;
	@ManyToMany(mappedBy = "characterMoviesSeries")
	private List<Character> characters;
	@ManyToMany(mappedBy = "genreMoviesSeries")
	private List<Genre> genres;
	
	public MovieSerie() {
		
	}
	
	public MovieSerie(String image, String title, Date creationDate, float qualification) {
		super();
		this.image = image;
		this.title = title;
		this.creationDate = creationDate;
		this.qualification = qualification;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public float getQualification() {
		return qualification;
	}
	public void setQualification(float qualification) {
		this.qualification = qualification;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}


	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

}

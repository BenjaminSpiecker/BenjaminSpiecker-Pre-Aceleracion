package com.alkemy.javaChallenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "movies_series")
public class MovieSerie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column()
	private String title;
	@Column(name = "creation_date")
	private LocalDateTime creationDate;
	@Column()
	private Integer qualification;
	@ManyToMany(mappedBy = "characterMoviesSeries")
	private List<Character> characters;
	@ManyToMany(mappedBy = "genreMoviesSeries")
	private List<Genre> genres;
	
	public MovieSerie() {
		
	}
	
	public MovieSerie(Integer id, String title, LocalDateTime creationDate, Integer qualification, List<Character> characters) {
		super();
		this.title = title;
		this.creationDate = creationDate;
		this.qualification = qualification;
		this.characters = characters;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getQualification() {
		return qualification;
	}
	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	@Override
	public String toString() {
		return "MovieSerie [id=" + id + ", title=" + title + ", creationDate=" + creationDate + ", qualification="
				+ qualification + ", characters=" + characters + "]";
	}	
	
}

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
@Table(name = "characters")
public class Character {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  @Column()
  private String name;
  @Column()
  private Integer age;
  @Column()
  private Integer weight;
  @Column(length=512)
  private String image;
  @Column(length=512)
  private String history;
  @ManyToMany
  @JoinTable(
		  name = "characters_movies_series",
		  joinColumns = @JoinColumn(name = "character_id"),
		  inverseJoinColumns = @JoinColumn(name = "movies_series_id"))
  private List<MovieSerie> characterMoviesSeries;
  
  public Character() {
	
  }
  
  
  
  public Character(String name, Integer age, Integer weight, String image, String history) {
	super();
	this.name = name;
	this.age = age;
	this.weight = weight;
	this.image = image;
	this.history = history;
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
  public void setImage(String image) {
	this.image = image;
  }
  
  public List<MovieSerie> getMoviesSeries() {
	return characterMoviesSeries;
  }
  
  public void setMoviesSeries(List<MovieSerie> characterMoviesSeries) {
	this.characterMoviesSeries = characterMoviesSeries;
  }
  
}
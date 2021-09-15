package com.alkemy.javaChallenge.dto;

public class CharacterListDto {
	
	private int id;
	private String name;
	private String image;
	
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
	public CharacterListDto(int id, String name, String image) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
	}
	public CharacterListDto() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}

package com.alkemy.javaChallenge.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MovieSerieListDto {
	private int id;
	private String image;
	private String title;
	private String creationDate;
	
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
	/*public Date getCreationDateToDate() {
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
	}*/
	public MovieSerieListDto(int id, String image, String title, String creationDate) {
		super();
		this.id = id;
		this.image = image;
		this.title = title;
		this.creationDate = creationDate;
	}
	public MovieSerieListDto(int id, String image, String title, Date creationDate) {
		super();
		this.id = id;
		this.image = image;
		this.title = title;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		this.creationDate = format.format(creationDate);
	}
	public MovieSerieListDto() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}

package com.alkemy.javaChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.javaChallenge.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{
	public Genre findById(int id);
}

package com.alkemy.javaChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.javaChallenge.model.MovieSerie;

@Repository
public interface MovieSerieRepository extends JpaRepository<MovieSerie, Integer>{
	public MovieSerie findById(int id);
}

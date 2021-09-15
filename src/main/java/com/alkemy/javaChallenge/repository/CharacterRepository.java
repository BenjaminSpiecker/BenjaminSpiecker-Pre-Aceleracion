package com.alkemy.javaChallenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.alkemy.javaChallenge.model.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer>{
	public Character findById(int id);
	public Character findByName(String name);
	public List<Character> findAll();
}

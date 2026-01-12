package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Membre;

public interface MembreRepository extends JpaRepository<Membre,Long> {
	 Membre findByCin(String cin);
	 List<Membre>findByNomStartingWith(String caractere);
	 Membre findByEmail(String email);
}

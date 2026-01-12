package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.EnseignantChercheur;

public interface EnseignantChercheurRepository extends JpaRepository<EnseignantChercheur, Long> {
	 List<EnseignantChercheur>findByGrade(String grade);
	 List<EnseignantChercheur>findByEtablissement(String etablissement);
}

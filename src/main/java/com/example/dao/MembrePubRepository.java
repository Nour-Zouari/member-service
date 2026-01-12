package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Membre_Pub_Id;
import com.example.entities.Membre_publication;

public interface MembrePubRepository extends JpaRepository<Membre_publication, Membre_Pub_Id> {
	@Query("select m from Membre_publication m where m.id.auteur_id=:x")
	 List<Membre_publication> findpubId(@Param ("x") Long autId);
}

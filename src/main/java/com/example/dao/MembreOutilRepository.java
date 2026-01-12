package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Membre_Outil;
import com.example.entities.Membre_Outil_Id;

public interface MembreOutilRepository
        extends JpaRepository<Membre_Outil, Membre_Outil_Id> {

    @Query("select m from Membre_Outil m where m.id.membre_id = :x")
    List<Membre_Outil> findOutils(@Param("x") Long idMembre);
}

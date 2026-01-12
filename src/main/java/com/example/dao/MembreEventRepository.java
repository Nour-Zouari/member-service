package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Membre_Evenement;
import com.example.entities.Membre_Event_Id;

public interface MembreEventRepository
        extends JpaRepository<Membre_Evenement, Membre_Event_Id> {

    @Query("select m from Membre_Evenement m where m.id.membre_id = :x")
    List<Membre_Evenement> findEvents(@Param("x") Long id);
}

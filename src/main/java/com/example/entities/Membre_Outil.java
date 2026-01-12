package com.example.entities;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Membre_Outil implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private Membre_Outil_Id id;

    @ManyToOne
    @MapsId("membre_id")
    private Membre membre;
}

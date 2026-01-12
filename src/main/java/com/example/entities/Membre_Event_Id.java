package com.example.entities;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@Data 
@AllArgsConstructor 
@NoArgsConstructor
public class Membre_Event_Id implements Serializable {
    private Long evenement_id;
    private Long membre_id;
}

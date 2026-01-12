package com.example.entities;

import java.util.Collection;
import java.util.Date;

import com.example.beans.PublicationBean;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true) 
@DiscriminatorValue("etd") 
public class Etudiant extends Membre {
    private Date dateInscription;
    private String diplome;
    @ManyToOne
    private EnseignantChercheur encadrant;
    
    @Builder
    public Etudiant(Long id, String cin, String nom, String prenom, Date dateNaissance, byte[] photo, String cv,
			String email, String password, Collection<PublicationBean> pubs, Date dateInscription, String diplome,
			EnseignantChercheur encadrant) {
		super(id, cin, nom, prenom, dateNaissance, photo, cv, email, password, pubs);
		this.dateInscription = dateInscription;
		this.diplome = diplome;
		this.encadrant = encadrant;
	}

	
    
}
 
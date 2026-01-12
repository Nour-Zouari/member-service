package com.example.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.example.beans.PublicationBean;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("ens")
public class EnseignantChercheur extends Membre {
    private String grade;
    private String etablissement;
    
    @Builder
    public EnseignantChercheur(Long id, String cin, String nom, String prenom, Date dateNaissance, byte[] photo,
			String cv, String email, String password, Collection<PublicationBean> pubs, String grade,
			String etablissement) {
		super(id, cin, nom, prenom, dateNaissance, photo, cv, email, password, pubs);
		this.grade = grade;
		this.etablissement = etablissement;
	}

	
}

package com.example.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.example.beans.EvenementBean;
import com.example.beans.OutilBean;
import com.example.beans.PublicationBean;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name = "type_mbr",
    discriminatorType = DiscriminatorType.STRING,
    length = 3
)
@Getter
@Setter
@NoArgsConstructor
public abstract class Membre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cin;
    private String nom;
    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private byte[] photo;
    private String cv;
    private String email;
    private String password;

    @Transient
    private Collection<PublicationBean> pubs;

    @Transient
    private List<EvenementBean> evenements;
    protected Membre(Long id, String cin, String nom, String prenom,
            Date dateNaissance, byte[] photo, String cv,
            String email, String password,
            Collection<PublicationBean> pubs) {
this.id = id;
this.cin = cin;
this.nom = nom;
this.prenom = prenom;
this.dateNaissance = dateNaissance;
this.photo = photo;
this.cv = cv;
this.email = email;
this.password = password;
this.pubs = pubs;
}
    @Transient
    private List<OutilBean> outils;

}
